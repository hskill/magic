package info.ideatower.magic.result;

import info.ideatower.magic.Schema;
import info.ideatower.magic.schema.OnlySchema;
import info.ideatower.magic.schema.SerialSchema;
import info.ideatower.magic.util.TemplateRenderer;
import lombok.SneakyThrows;
import lombok.val;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * 生成结果转入jdbc
 */
public class Jdbc {

    private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";

    private final Schema schema;
    private final TemplateRenderer renderer;

    private String host;
    private String user;
    private String password;
    private String db;
    private String table;
    private String template;

    public Jdbc(Schema schema) {
        this.schema = schema;
        this.renderer = new TemplateRenderer();
    }

    public Jdbc template(String template) {
        this.template = template;
        return this;
    }

    public Jdbc host(String host) {
        this.host = host;
        return this;
    }

    public Jdbc user(String user) {
        this.user = user;
        return this;
    }

    public Jdbc password(String password) {
        this.password = password;
        return this;
    }

    public Jdbc db(String db) {
        this.db = db;
        return this;
    }

    public Jdbc table(String table) {
        this.table = table;
        return this;
    }

    @SneakyThrows
    public void to() {
        if (schema instanceof SerialSchema) {
            ((SerialSchema) schema).next().forEach((item) -> {
                handleData(item);
            });
        }
        else if (schema instanceof OnlySchema) {
            handleData(((OnlySchema) schema).next());
        }
    }

    private void handleData(Map<String, Object> item) {
        val conn = getConnection(this.host, this.user, this.password, this.db);
        val query = new QueryRunner();
        try {
            val sql = getSql(item);
            query.insert(conn, sql, (rs) -> {return null;});
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        DbUtils.closeQuietly(conn);
    }

    private String getSql(Object item) {
        Map<String, Object> itemMap = (Map<String, Object>) item;
        if (StringUtils.isNotBlank(this.template)) {
            return renderer.render(this.template, item);
        }

        val sql = new StringBuilder();
        sql.append("INSERT INTO `").append(this.table).append("`(");
        for (String key : itemMap.keySet()) {
            sql.append("`");
            sql.append(key);
            sql.append("`,");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(") VALUES(");

        for (Map.Entry<String, Object> entry : itemMap.entrySet()) {
            sql.append("'").append(entry.getValue()).append("'");
            sql.append(",");
        }
        sql.deleteCharAt(sql.length() - 1);
        sql.append(")");
        return sql.toString();

    }

    @SneakyThrows
    private Connection getConnection(String host, String user, String password, String db) {

        DbUtils.loadDriver(MYSQL_DRIVER);
        val url = MessageFormat.format("jdbc:mysql://{0}/{1}?useUnicode=true&characterEncoding=UTF8", host, db);
        Connection connection = DriverManager.getConnection(url, user , password) ;
        return connection;
    }
}
