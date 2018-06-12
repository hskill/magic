package info.ideatower.magic.random.text;

/**
 * 生成单个字母字符，请注意与 Char 的区别
 */
public class Letter extends Char {

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public Letter(String mark) {
        super(mark);
        this.pool(LETTERS.toCharArray());
    }

    /**
     * 设定大写
     * @return
     */
    public Letter upper() {
        this.pool(LETTERS.toUpperCase().toCharArray());
        return this;
    }
}
