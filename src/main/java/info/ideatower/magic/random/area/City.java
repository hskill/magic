package info.ideatower.magic.random.area;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 城市
 *
 * 数据来源 县及县以上行政区划代码（截止2010年12月31日）
 */
public class City extends Picker<String> {

    public City(String mark) {
        super(mark);
        this.values(FileLoader.loadResource("area/counties.txt"));
    }
}