package info.ideatower.magic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import info.ideatower.magic.result.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Map;

/**
 * 应用入口
 */
public class Magic {

    /** schema 存储 */
    private static final Map<String, Schema> SCHEMA_MAP = Maps.newHashMap();

    private Schema schema;

    public Magic(Schema schema) {
        this.schema = schema;
    }

    /**
     * 设置数据属性
     * @param name 名称，唯一标识
     * @param ables 随机生成域
     * @return
     */
    public static Magic schema(String name, Randomable... ables) {
        Schema schema = new Schema();
        for (Randomable able : ables) {
            schema.add(able);
        }
        SCHEMA_MAP.put(name, schema);
        return new Magic(schema);
    }

    /**
     * 设置数据属性
     * @param ables 随机生成域
     * @return
     */
    public static Magic schema(Randomable... ables) {
        return schema(RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyz"), ables);
    }

    /**
     * 通过名称获取 schema
     * @param name 指定schema名称
     * @return
     */
    public static Schema getSchema(String name) {
        if (!SCHEMA_MAP.containsKey(name)) {
            throw new RuntimeException("cannot find schema name: " + name);
        }
        return SCHEMA_MAP.get(name);
    }

    /**
     * 获取所有 schema
     * @return
     */
    public static List<Schema> getSchemas() {
        return Lists.newArrayList(SCHEMA_MAP.values());
    }

    /**
     * 获取当前对象指定的 schema
     * @return
     */
    public Schema getSchema() {
        return this.schema;
    }

    /**
     * 生成为对象
     * @return
     */
    public Obj asObj() {
        return (new Obj(new Result(this.schema)));
    }

    /**
     * 生成为文本
     * @return
     */
    public Text asText() {
        return new Text(new Result(this.schema));
    }

    /**
     * 生成为json
     * @return
     */
    public Json asJson() {
        return new Json(new Result(this.schema));
    }

    /**
     * 生成为jdbc数据库数据
     * @return
     */
    public Jdbc asJdbc() {
        return new Jdbc(new Result(this.schema));
    }
}
