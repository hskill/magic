package info.ideatower.magic.schema;

import com.google.common.collect.Maps;
import info.ideatower.magic.Randomable;
import info.ideatower.magic.Schema;

import java.util.Map;

public class OnlySchema extends Schema<Map<String, Object>> {

    public OnlySchema(String mark) {
        super(mark);
    }

    @Override
    public Map<String, Object> next() {
        Map<String, Object> item = Maps.newHashMap();
        if (!this.container.isEmpty()) {
            for (Randomable able : this.container.values()) {
                item.put(able.getMark(), able.next());
            }
        }
        return item;
    }
}
