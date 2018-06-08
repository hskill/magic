package info.ideatower.magic.random.identity;

import info.ideatower.magic.random.AbstractRandomValue;

/**
 * 自动按step增长
 */
public class Increment extends AbstractRandomValue<Integer> {

    private int current;
    private int step;

    public Increment(String mark) {
        this(mark, 1);
    }

    public Increment(String mark, int step) {
        super(mark);
        this.current = 1;
        this.step = 1;
    }

    @Override
    public Integer next() {
        int result = this.current;
        this.current += this.step;
        return result;
    }
}
