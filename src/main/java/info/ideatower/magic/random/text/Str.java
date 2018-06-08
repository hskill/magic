package info.ideatower.magic.random.text;

import info.ideatower.magic.random.AbstractRandomValue;
import org.apache.commons.lang3.RandomStringUtils;

public class Str extends AbstractRandomValue<String> {

    public static final String STRS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private int count;
    private int min;
    private int max;

    public Str(String mark) {
        this(mark, 5);
    }

    public Str(String mark, int count) {
        super(mark);
        this.count = count;
    }

    public Str(String mark, int min, int max) {
        super(mark);
        this.min = min;
        this.max = max;
    }

    @Override
    public String next() {
        if (this.count > 0) {
            return RandomStringUtils.random(this.count, STRS);
        }
        else {
            return RandomStringUtils.random(this.min + getRandom().nextInt(this.max - this.min), STRS);
        }

    }
}
