package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.Str;

import java.text.MessageFormat;

/**
 * 电子邮件生成
 */
public class Email extends AbstractRandomValue<String> {

    private final Str name;
    private final Domain domain;

    public Email(String mark) {
        super(mark);
        this.name = new Str(mark, 6, 10);
        this.domain = new Domain(mark);
    }
    @Override
    public String next() {
        return MessageFormat.format("{0}@{1}", name.next().toLowerCase(), domain.next());
    }
}
