package info.ideatower.magic.random.area;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 国家或地区
 *
 * 来源 GB/T 2659-2000
 */
public class Country extends Picker<String> {
    public Country(String mark) {
        super(mark);
        this.values(FileLoader.loadResource("area/countries.txt"));
    }
}
