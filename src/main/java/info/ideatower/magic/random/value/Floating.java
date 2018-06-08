package info.ideatower.magic.random.value;

import info.ideatower.magic.random.AbstractRandomValue;

public class Floating extends AbstractRandomValue<Float> {

    private final float min;
    private final float max;

    public Floating(String mark) {
        this(mark, Float.MIN_VALUE, Float.MAX_VALUE);
    }

    public Floating(String mark, float min) {
        this(mark, min, Float.MAX_VALUE);
    }

    public Floating(String mark, float min, float max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public Float next() {
        return min + getRandom().nextFloat() * max;
    }
}
