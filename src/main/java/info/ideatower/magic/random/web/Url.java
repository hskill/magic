package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.EnglishWord;
import info.ideatower.magic.random.value.Int;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.Repeater;

import java.text.MessageFormat;

/**
 * url
 */
public class Url extends AbstractRandomValue<String> {

    private final Int pathInt;
    private final Int hostInt;
    private final Picker protocol;
    private final Domain domain;
    private final EnglishWord part;
    private final Picker extension;

    public Url(String mark) {
        super(mark);
        this.protocol = new Picker(mark).values("http", "https");
        this.domain = new Domain(mark);
        this.hostInt = new Int(mark).between(1, 3);
        this.pathInt = new Int(mark).between(3, 6);
        this.part = new EnglishWord(mark);
        this.extension = new Picker(mark).values("html", "htm", "do", "aspx", "jsp", "php");
    }

    @Override
    public String next() {
        return MessageFormat.format("{0}://{1}.{2}/{3}.{4}",
                this.protocol.next(),
                Repeater.str(this.part, this.hostInt.next(), "."),
                this.domain.next(),
                Repeater.str(this.part, this.pathInt.next(), "/"),
                this.extension.next());
    }
}
