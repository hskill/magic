package info.ideatower.magic.random.value;

import com.google.common.collect.Lists;
import info.ideatower.magic.random.AbstractRandomValue;
import lombok.Data;

import java.util.List;

@Data
public class Picker<T> extends AbstractRandomValue<T> {

    private List<T> values;

    public Picker(String mark) {
        this(mark, Lists.newArrayList());
    }

    public Picker(String mark, List<T> values) {
        super(mark);
        this.values = values;
    }

    public Picker(String mark, T... values) {
        super(mark);
        this.values = Lists.newArrayList(values);
    }

    @Override
    public T next() {
        int index = getRandom().nextInt(values.size());
        return this.values.get(index);
    }

    public static Picker of(String mark, List<String> values) {
        return new Picker(mark, Lists.newArrayList(values));
    }
}
