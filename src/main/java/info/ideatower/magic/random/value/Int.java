package info.ideatower.magic.random.value;

import info.ideatower.magic.random.AbstractRandomValue;
import lombok.Data;

@Data
public class Int extends AbstractRandomValue<Integer> {

    protected int min;
    protected int max;


    public Int(String mark) {
        this(mark, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public Int(String mark, int min, int max) {
        super(mark);
        this.min = min;
        this.max = max;
    }


    @Override
    public Integer next() {
        return min + getRandom().nextInt(max - min);
    }
}
