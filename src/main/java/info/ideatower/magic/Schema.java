package info.ideatower.magic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import info.ideatower.magic.random.value.Picker;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 总体随机数据域
 */
public class Schema {

    private final Map<String, RecordRandomableProxy> container;

    public Schema() {
        this.container = Maps.newHashMap();
    }

    /**
     * 增加随机数据域
     * @param able
     */
    public void add(Randomable able) {
        this.container.put(able.getMark(), new RecordRandomableProxy(able));
    }

    /**
     * 获取所有随机数据域
     * @return
     */
    public List<Randomable> getRandomable() {
        return Lists.newArrayList(this.container.values());
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
