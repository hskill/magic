package info.ideatower.magic.random.value;

import com.google.common.collect.Lists;
import info.ideatower.magic.Randomable;
import info.ideatower.magic.random.AbstractRandomValue;

import java.util.List;

/**
 * 按字符串合并数据列表
 */
public class Combine extends AbstractRandomValue<String> {

    private List<Randomable> values;

    public Combine(String mark) {
        super(mark);
    }

    public Combine values(Randomable... ables) {
        return values(Lists.newArrayList(ables));
    }

    private Combine values(List<Randomable> ables) {
        this.values = ables;
        return this;
    }

    @Override
    public String next() {
        StringBuilder str = new StringBuilder();
        for (Randomable able : this.values) {
            str.append(String.valueOf(able.next()));
        }
        return str.toString();
    }
}
