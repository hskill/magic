package info.ideatower.magic.random.value;

import info.ideatower.magic.random.AbstractRandomValue;

/**
 * 步长整数生成
 */
public class Range extends AbstractRandomValue<Integer> {

    private int start = 0;
    private int stop;
    private int step = 1;

    private int current = 0;

    public Range(String mark) {
        this(mark, 0, 100, 1);
    }

    public Range(String mark, int start) {
        this(mark, start, start + 100, 1);
    }

    public Range(String mark, int start, int stop) {
        this(mark, start, stop, 1);
    }

    public Range(String mark, int start, int stop, int step) {
        super(mark);
        this.start = start;
        this.stop = stop;
        this.step = step;
    }

    @Override
    public Integer next() {
        if (this.current >= this.stop) {
            this.current = start;
        }
        int result = this.current;
        this.current += this.step;
        return result;
    }
}
