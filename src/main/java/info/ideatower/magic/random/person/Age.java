package info.ideatower.magic.random.person;

import info.ideatower.magic.random.value.Int;

/**
 * 年龄
 */
public class Age extends Int {

    public Age(String mark) {
        super(mark);
        this.between(16, 68);
    }
}
