package info.ideatower.magic.schema;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import info.ideatower.magic.Randomable;
import info.ideatower.magic.Schema;

import java.util.List;
import java.util.Map;

public class SerialSchema extends Schema<List<Map<String, Object>>> {

    private int count = DEFAULT_PRODUCE_COUNT;

    public SerialSchema(String mark) {
        super(mark);
    }

    public SerialSchema count(int count) {
        if (count < 1) {
            return this;
        }
        this.count = count;
        return this;
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
}
