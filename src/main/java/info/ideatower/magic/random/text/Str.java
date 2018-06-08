package info.ideatower.magic.random.text;

import info.ideatower.magic.random.AbstractRandomValue;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 生成随机字符串，可以指定长度，或长度范围，以及指定字符池
 */
public class Str extends AbstractRandomValue<String> {

    public static final String STRS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String pool = STRS;
    private int count;
    private int min;
    private int max;

    public Str(String mark) {
        this(mark, STRS, 5);
    }

    public Str(String mark, String pool, int count) {
        super(mark);
        this.pool = pool;
        this.count = count;
    }

    public Str(String mark, String pool, int min, int max) {
        super(mark);
        this.pool = pool;
        this.min = min;
        this.max = max;
    }

    public Str(String mark, String pool) {
        this(mark, 5);
        this.pool = pool;
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
