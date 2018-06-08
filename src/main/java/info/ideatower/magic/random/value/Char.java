package info.ideatower.magic.random.value;

import com.google.common.collect.Lists;
import com.google.common.primitives.Chars;

public class Char extends Picker {

    public static final char[] CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()".toCharArray();

    public Char(String mark) {
        super(mark, Lists.newArrayList(CHARS));
    }

    public Char(String mark, String pool) {
        super(mark, Chars.asList(pool.toCharArray()));
    }
}
