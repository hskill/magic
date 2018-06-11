package info.ideatower.magic.random.person;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.Str;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

import java.text.MessageFormat;

/**
 * 固定电话
 */
public class Telphone extends AbstractRandomValue<String> {

    private final Picker<String> code;
    private final Str no;

    public Telphone(String mark) {
        super(mark);
        this.code = new Picker<String>(mark).values(FileLoader.loadResource("person/telphones.txt"));
        this.no = new Str(mark).count(8).pool("0123456789");
    }

    @Override
    public String next() {
        return MessageFormat.format("{0}-{1}", this.code.next(), this.no.next());
    }
}
