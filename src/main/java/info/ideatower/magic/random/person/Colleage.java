package info.ideatower.magic.random.person;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.area.Country;
import info.ideatower.magic.random.area.Province;
import info.ideatower.magic.random.text.Word;
import info.ideatower.magic.random.value.Picker;

import java.text.MessageFormat;

/**
 * 学校名称
 */
public class Colleage extends AbstractRandomValue<String> {

    private final Picker<Object> pre;
    private final Word word;
    private final Picker<String> name;

    public Colleage(String mark) {
        super(mark);
        this.pre = new Picker<Object>(mark).values(new Country(mark), new Province(mark));
        this.word = new Word(mark);
        this.name = new Picker<String>(mark).values("学院", "大学");
    }

    @Override
    public String next() {
        return MessageFormat.format("{0}{1}{2}", this.pre.next(), this.word.next(), this.name.next());
    }
}
