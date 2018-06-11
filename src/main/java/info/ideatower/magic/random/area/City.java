package info.ideatower.magic.random.area;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 城市
 *
 * 数据来源 县及县以上行政区划代码（截止2010年12月31日）
 */
public class City extends AbstractRandomValue<String> {

    private final Picker<String> values;

    public City(String mark) {
        super(mark);
        this.values = new Picker<String>(mark).values(FileLoader.loadResource("area/countries.txt"));
    }

    @Override
    public String next() {
        return this.values.next();
    }
}