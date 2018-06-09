package info.ideatower.magic.random.person;

import com.google.common.collect.Lists;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 姓名
 *
 * 主要来源于古龙小说人物名称
 */
public class Name extends Picker {

    public Name(String mark) {
        super(mark);
        this.values(Lists.newArrayList(FileLoader.loadResource("person/names.txt")));
    }
}
