package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.EnglishWord;

import java.text.MessageFormat;

/**
 * 电子邮件生成
 */
public class Email extends AbstractRandomValue<String> {

    private final EnglishWord name;
    private final Domain domain;

    public Email(String mark) {
        super(mark);
        this.name = new EnglishWord(mark);
        this.domain = new Domain(mark);
    }
    @Override
    public String next() {
        return MessageFormat.format("{0}@{1}", name.next(), domain.next());
    }
}
