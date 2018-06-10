package info.ideatower.magic.random.identity;

import info.ideatower.magic.random.AbstractRandomValue;

/**
 * 自动按step增长
 */
public class Increment extends AbstractRandomValue<Integer> {

    private int current;
    private int step = 1;
    private int stop = Integer.MAX_VALUE;
    private int start = 0;

    public Increment(String mark) {
        super(mark);
    }

    public Increment start(int start) {
        this.start = this.current= start;
        return this;
    }

    public Increment stop(int stop) {
        this.stop = stop;
        return this;
    }

    public Increment step(int step) {
        this.step = step;
        return this;
    }


    @Override
    public Integer next() {
        if (this.current == this.stop) {
            this.current = this.start;
        }
        int result = this.current;
        this.current += this.step;
        return result;
    }
}
