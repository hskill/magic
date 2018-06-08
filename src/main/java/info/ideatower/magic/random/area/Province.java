package info.ideatower.magic.random.area;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

public class Province extends Picker<String> {

    public Province(String mark) {
        super(mark, FileLoader.loadResource("area/provinces.txt"));
    }
}
