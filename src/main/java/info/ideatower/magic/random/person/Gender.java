package info.ideatower.magic.random.person;

import com.google.common.collect.Lists;
import info.ideatower.magic.random.value.Picker;

/**
 * 性别
 */
public class Gender extends Picker<String> {

    public Gender(String mark) {
        super(mark, Lists.newArrayList("女", "男"));
    }

    public Gender(String mark, String female, String male) {
        super(mark, Lists.newArrayList(female, male));
    }
}
