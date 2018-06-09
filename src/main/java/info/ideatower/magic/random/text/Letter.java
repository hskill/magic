package info.ideatower.magic.random.text;

/**
 * 生成单个字母字符，请注意与 Char 的区别
 */
public class Letter extends Char {

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    private boolean upper = false;

    public Letter(String mark) {
        super(mark);
        this.pool(LETTERS.toCharArray());
    }

    public Letter upper() {
        this.pool(LETTERS.toUpperCase().toCharArray());
        return this;
    }
}
