package info.ideatower.magic.random.area;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 国家或地区
 */
public class Country extends Picker<String> {
    public Country(String mark) {
        super(mark, FileLoader.loadResource("area/countries.txt"));
    }
}
