package info.ideatower.magic.random.text;

import info.ideatower.magic.random.AbstractRandomValue;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 生成随机字符串，可以指定长度，或长度范围，以及指定字符池
 */
public class Str extends AbstractRandomValue<String> {

    public static final String STRS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";

    private String pool = STRS;
    private int count;
    private int min = 10;
    private int max = 20;

    public Str(String mark) {
        super(mark);
    }

    public Str count(int count) {
        this.count = count;
        return this;
    }

    public Str min(int min) {
        this.min = min;
        return this;
    }

    public Str max(int max) {
        this.max = max;
        return this;
    }

    public Str pool(String pool) {
        this.pool = pool;
        return this;
    }

    @Override
    public String next() {
        if (this.count > 0) {
            return RandomStringUtils.random(this.count, this.pool);
        }
        else {
            return RandomStringUtils.random(this.min + getRandom().nextInt(this.max - this.min), pool);
        }

    }
}
