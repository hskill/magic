package info.ideatower.magic;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import info.ideatower.magic.random.value.Picker;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 元数据
 */
public class Schema {

    private final Map<String, Randomable> container;
    private final Map<String, Set<Object>> yielded;

    public Schema() {
        this.container = Maps.newHashMap();
        this.yielded = Maps.newHashMap();
    }

    public void add(Randomable able) {
        this.container.put(able.getMark(), new RandomableProxy(able, this.yielded));
    }

    public List<Randomable> getRandomable() {
        return Lists.newArrayList(this.container.values());
    }

    /**
     * 对指定名称，获取该属性已经产生过的数据
     * @param mark 名称
     * @return Set<Object> 集合（无重复元素）
     */
    public Set<Object> getProduced(String mark) {
        return this.yielded.getOrDefault(mark, Collections.EMPTY_SET);
    }

    /**
     * 对指定名称，获取该属性已经产生过的数据
     * @param newMark 新创建的属性名称
     * @param fromMark 来自哪一个属性名称
     * @return
     */
    public Picker<Object> getProduced(String newMark, String fromMark) {
        return new Picker(newMark, Lists.newArrayList(getProduced(fromMark)));
    }

    /**
     * 通过代理类，在获取值后，进行存储
     */
    private class RandomableProxy implements Randomable {
        private final Map<String, Set<Object>> yielded;
        private final Randomable able;

        public RandomableProxy(Randomable able, Map<String, Set<Object>> yielded) {
            this.able = able;
            this.yielded = yielded;
        }

        @Override
        public String getMark() {
            return this.able.getMark();
        }

        @Override
        public Object next() {
            Object value = this.able.next();
            if (this.yielded.containsKey(this.able.getMark())) {
                this.yielded.get(this.able.getMark()).add(value);
            }
            else {
                Set<Object> values = Sets.newHashSet(value);
                this.yielded.put(this.able.getMark(), values);
            }
            return value;
        }
    }
}
