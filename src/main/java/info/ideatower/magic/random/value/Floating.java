package info.ideatower.magic.random.value;

import info.ideatower.magic.random.AbstractRandomValue;

/**
 * float 数值
 */
public class Floating extends AbstractRandomValue<Float> {

    private float min = Float.MIN_VALUE;
    private float max = Float.MAX_VALUE;

    public Floating(String mark) {
        super(mark);
    }

    public Floating min(float min) {
        this.min = min;
        return this;
    }

    public Floating max(float max) {
        this.max = max;
        return this;
    }

    public Floating between(float min, float max) {
        this.min = min;
        this.max = max;
        return this;
    }

    @Override
    public Float next() {
        return min + getRandom().nextFloat() * max;
    }
}
