package info.ideatower.magic;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Map;

public class Magic {

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
    public static Magic schame(String name, Randomable... ables) {
        Schema schema = new Schema();
        for (Randomable able : ables) {
            schema.add(able);
        }
        SCHEMA_MAP.put(name, schema);
        return new Magic(schema);
    }

    public static Magic schame(Randomable... fields) {
        return schame(RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyz"), fields);
    }

    public static Schema getSchema(String name) {
        return SCHEMA_MAP.get(name);
    }

    public Schema getSchema() {
        return this.schema;
    }

    public SimpleAssembler as() {
        return new SimpleAssembler(this.schema);
    }
}
