package info.ideatower.magic.random.person;

import com.google.common.collect.Lists;
import info.ideatower.magic.util.FileLoader;
import info.ideatower.magic.random.value.Picker;

/**
 * 姓名
 *
 * 主要来源于古龙小说人物名称
 */
public class Name extends Picker {

    public Name(String mark) {
        super(mark, Lists.newArrayList(FileLoader.loadResource("person/names.txt")));
    }
}
