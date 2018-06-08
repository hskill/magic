package info.ideatower.magic.random.area;

import info.ideatower.magic.util.FileLoader;
import info.ideatower.magic.random.value.Picker;

/**
 * 城市
 */
public class City extends Picker<String> {

    public City(String mark) {
        super(mark, FileLoader.loadResource("area/cities.txt"));
    }
}