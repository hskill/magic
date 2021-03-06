package info.ideatower.magic.random.value;

import com.google.common.collect.Lists;
import info.ideatower.magic.Randomable;
import info.ideatower.magic.random.AbstractRandomValue;

import java.util.List;

/**
 * 随机挑选已有列表数据，列表数据可以使用 Randomable
 * @param <T>
 */
public class Picker<T> extends AbstractRandomValue<T> {

    private List<T> values = Lists.newArrayList();

    public Picker(String mark) {
        super(mark);
    }

    public Picker values(T... params) {
        return values(Lists.newArrayList(params));
    }

    public Picker values(List<T> values) {
        this.values = values;
        return this;
    }

    @Override
    public T next() {
        if (this.values.isEmpty()) {
            return null;
        }
        int index = getRandom().nextInt(values.size());
        Object item = this.values.get(index);
        if (item instanceof Randomable) {
            return (T) ((Randomable) item).next();
        }
        return (T) item;
    }
}
