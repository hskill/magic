package info.ideatower.magic.random.area;

import com.google.common.collect.Lists;
import info.ideatower.magic.util.FileLoader;
import info.ideatower.magic.random.value.Picker;

/**
 * 城市
 */
public class City extends Picker {

    public City(String mark) {
        super(mark, Lists.newArrayList(FileLoader.loadResource("area/cities.txt")));
    }
}