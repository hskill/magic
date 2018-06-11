package info.ideatower.magic.random.person;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 中国56个民族，未包括其它未识别民族
 */
public class Nation extends AbstractRandomValue<String> {

    private final Picker<String> values;

    public Nation(String mark) {
        super(mark);
        this.values = new Picker<String>(mark).values(FileLoader.loadResource("person/nations.txt"));
    }

    @Override
    public String next() {
        return this.values.next();
    }
}
