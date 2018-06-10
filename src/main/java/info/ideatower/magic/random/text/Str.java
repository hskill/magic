package info.ideatower.magic.random.text;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Int;
import info.ideatower.magic.util.Repeater;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * 生成随机字符串，可以指定长度，或长度范围，以及指定字符池
 */
public class Str extends AbstractRandomValue<String> {

    public static final String STRS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";

    private final Char ch;
    private final Int integer;

    private int count;

    public Str(String mark) {
        super(mark);
        this.ch = new Char(mark).pool(STRS);
        this.integer = new Int(mark).between(10, 20);
    }

    public Str count(int count) {
        this.count = count;
        return this;
    }

    public Str count(int min, int max) {
        this.integer.between(min, max);
        return this;
    }

    public Str min(int min) {
        this.integer.min(min);
        return this;
    }

    public Str max(int max) {
        this.integer.max(max);
        return this;
    }

    public Str pool(String pool) {
        this.ch.pool(pool);
        return this;
    }

    @Override
    public String next() {
        if (this.count > 0) {
            return Repeater.str(this.ch, count);
        }
        else {
            return Repeater.str(this.ch, this.integer.next());
        }

    }
}
