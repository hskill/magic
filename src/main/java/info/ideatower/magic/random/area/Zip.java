package info.ideatower.magic.random.area;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 中国大陆境内邮编
 *
 * https://zh.wikipedia.org/wiki/中华人民共和国境内地区邮政编码列表
 */
public class Zip extends Picker<String> {

    public Zip(String mark) {
        // TODO
        super(mark, FileLoader.loadResource("area/zips.txt"));
    }
}
