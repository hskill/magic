package info.ideatower.magic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.result.Jdbc;
import info.ideatower.magic.result.Json;
import info.ideatower.magic.result.Obj;
import info.ideatower.magic.result.Text;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 总体随机数据域
 */
public class Schema implements Randomable<List<Map<String, Object>>> {

    public static final int DEFAULT_PRODUCE_COUNT = 100;

    /** schema 存储 */
    private static final Map<String, Schema> SCHEMA_MAP = Maps.newHashMap();

    /**
     * 设置数据属性
     * @param name 名称，唯一标识
     * @param ables 随机生成域
     * @return
     */
    public static Schema of(String name, Randomable... ables) {
        Schema schema = new Schema(name);
        for (Randomable able : ables) {
            schema.add(able);
        }
        SCHEMA_MAP.put(name, schema);
        return schema;
    }

    /**
     * 设置数据属性
     * @param ables 随机生成域
     * @return
     */
    public static Schema of(Randomable... ables) {
        return of(RandomStringUtils.random(6, "abcdefghijklmnopqrstuvwxyz"), ables);
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

    private final String mark;
    private final Map<String, RecordRandomableProxy> container;
    private int count = DEFAULT_PRODUCE_COUNT;

    public Schema(String mark) {
        this.container = Maps.newHashMap();
        this.mark = mark;
    }

    public String getMark() {
        return this.mark;
    }

    public Schema count(int count) {
        if (count < 1) {
            return this;
        }
        this.count = count;
        return this;
    }

    /**
     * 增加随机数据域
     * @param able
     */
    public void add(Randomable able) {
        this.container.put(able.getMark(), new RecordRandomableProxy(able));
    }

    /**
     * 产生数据
     * @return 数据列表
     */
    @Override
    public List<Map<String, Object>> next() {
        List<Map<String, Object>> result = Lists.newArrayList();
        if (!this.container.isEmpty()) {
            for (int i = 0; i < this.count; i++) {
                Map<String, Object> item = Maps.newHashMap();
                for (Randomable able : this.container.values()) {
                    item.put(able.getMark(), able.next());
                }
                result.add(item);
            }
        }
        return result;
    }

    /**
     * 生成为对象
     * @return
     */
    public Obj asObj() {
        return (new Obj(this));
    }

    /**
     * 生成为文本
     * @return
     */
    public Text asText() {
        return new Text(this);
    }

    /**
     * 生成为json
     * @return
     */
    public Json asJson() {
        return new Json(this);
    }

    /**
     * 生成为jdbc数据库数据
     * @return
     */
    public Jdbc asJdbc() {
        return new Jdbc(this);
    }

    /**
     * 对指定名称，获取该属性已经产生过的数据
     * @param fromMark 名称
     * @return Randomable
     */
    public Randomable getProduced(String fromMark, String newMark) {
        return new MemoryRandomable(newMark, this.container.get(fromMark));
    }

    /**
     * 用来从已生成记录中随机获取数据
     */
    private class MemoryRandomable implements Randomable {

        private final RecordRandomableProxy proxy;
        private final String mark;
        private final Picker picker;

        public MemoryRandomable(String mark, RecordRandomableProxy proxy) {
            this.mark = mark;
            this.proxy = proxy;
            this.picker = new Picker(this.mark);
        }

        @Override
        public String getMark() {
            return this.mark;
        }

        @Override
        public Object next() {
             return picker.values(proxy.yielded.toArray()).next();
        }
    }

    /**
     * 通过代理类，在获取值后，进行生成值存储
     */
    private class RecordRandomableProxy implements Randomable {
        private final Set<Object> yielded;
        private final Randomable able;

        public RecordRandomableProxy(Randomable able) {
            this.able = able;
            this.yielded = Sets.newHashSet();
        }

        @Override
        public String getMark() {
            return this.able.getMark();
        }

        @Override
        public Object next() {
            Object value = this.able.next();
            this.yielded.add(value);
            return value;
        }
    }
}
