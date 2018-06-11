package info.ideatower.magic.random.area;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 省份
 */
public class Province extends AbstractRandomValue<String> {

    private final Picker<String> values;

    public Province(String mark) {
        super(mark);
        this.values = new Picker<String>(mark).values(FileLoader.loadResource("area/provinces.txt"));
    }

    @Override
    public String next() {
        return this.values.next();
    }
}
