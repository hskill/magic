package info.ideatower.magic.random.value;

import com.google.common.collect.Lists;
import info.ideatower.magic.Randomable;
import info.ideatower.magic.random.AbstractRandomValue;

import java.util.List;

/**
 * 按 Randomable 或 固定数据合并数据列表
 */
public class Union extends AbstractRandomValue<String> {

    private List<Object> values;

    public Union(String mark) {
        super(mark);
    }

    public Union values(Object... params) {
        return values(Lists.newArrayList(params));
    }

    private Union values(List<Object> values) {
        this.values = values;
        return this;
    }

    @Override
    public String next() {
        StringBuilder str = new StringBuilder();
        for (Object value : this.values) {
            if (value instanceof Randomable) {
                str.append(String.valueOf(((Randomable) value).next()));
            }
            else {
                str.append(String.valueOf(value));
            }
        }
        return str.toString();
    }
}
