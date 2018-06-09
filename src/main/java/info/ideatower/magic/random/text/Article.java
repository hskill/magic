package info.ideatower.magic.random.text;


import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Int;
import info.ideatower.magic.util.Repeater;

/**
 * 文章内容
 *
 * 来源 http://www.sogou.com/labs/resource/cs.php
 */
public class Article extends AbstractRandomValue<String> {

    private final Pragraph pragraph;
    private final Int integer;
    private String separator;

    public Article(String mark) {
        super(mark);
        this.separator = System.getProperty("line.separator");
        this.pragraph = new Pragraph(mark);
        this.integer = new Int(mark).between(6, 15);
    }

    public Article separator(String separator) {
        this.separator = separator;
        return this;
    }


    @Override
    public String next() {
        return Repeater.str(this.pragraph, this.integer.next(), this.separator);
    }
}
