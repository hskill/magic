package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.Str;

import java.text.MessageFormat;

/**
 * 生成域名列表
 */
public class Domain extends AbstractRandomValue<String> {

    private final Str host;
    private final Tld tld;

    public Domain(String mark) {
        super(mark);
        this.host = new Str(mark, 6, 10);
        this.tld = new Tld(mark);
    }
    @Override
    public String next() {
        return MessageFormat.format("{0}.{1}", this.host.next().toLowerCase(), this.tld.next());
    }
}
