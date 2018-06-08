package info.ideatower.magic.random.person;

import com.google.common.collect.Lists;
import info.ideatower.magic.random.value.Picker;

public class Gender extends Picker<String> {
    public Gender(String mark) {
        super(mark, Lists.newArrayList("FEMALE", "MALE"));
    }
}
