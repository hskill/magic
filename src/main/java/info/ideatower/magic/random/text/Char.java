package info.ideatower.magic.random.text;

import info.ideatower.magic.random.AbstractRandomValue;

/**
 * 生成单个字符
 *
 * 与 Letter 的区别，Letter是生成单个字母字符，Char 是生成个人字符
 */
public class Char extends AbstractRandomValue<Character> {

    public static final char[] CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private char[] pool;

    public Char(String mark) {
        super(mark);
        this.pool = CHARS;
    }

    public Char pool(String pool) {
        this.pool = pool.toCharArray();
        return this;
    }

    public Char pool(char... pool) {
        this.pool = pool;
        return this;
    }

    @Override
    public Character next() {
        int index = getRandom().nextInt(this.pool.length);
        return this.pool[index];
    }
}
