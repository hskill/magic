package info.ideatower.magic.random.value;

import com.google.common.primitives.Chars;

/**
 * 生成单个字符
 *
 * 与 Letter 的区别，Letter是生成单个字母字符，Char 是生成字符
 */
public class Char extends Picker<Character> {

    public static final char[] CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()".toCharArray();

    public Char(String mark) {
        super(mark, Chars.asList(CHARS));
    }

    public Char(String mark, String pool) {
        super(mark, Chars.asList(pool.toCharArray()));
    }
}
