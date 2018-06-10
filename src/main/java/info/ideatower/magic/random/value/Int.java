package info.ideatower.magic.random.value;

import info.ideatower.magic.random.AbstractRandomValue;
import lombok.Data;

@Data
public class Int extends AbstractRandomValue<Integer> {

    protected int min = Integer.MIN_VALUE;
    protected int max = Integer.MAX_VALUE;


    public Int(String mark) {
        super(mark);
    }

    public Int min(int min) {
        this.min = min;
        return this;
    }

    public Int max(int max) {
        this.max = max;
        return this;
    }

    public Int between(int min, int max) {
        this.min = min;
        this.max = max;
        return this;
    }

    @Override
    public Integer next() {
        return min + getRandom().nextInt(max - (min < 0 ? 0 : min));
    }
}
