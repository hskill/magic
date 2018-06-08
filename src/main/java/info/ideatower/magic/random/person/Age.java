package info.ideatower.magic.random.person;

import info.ideatower.magic.random.value.Int;

/**
 * 年龄
 */
public class Age extends Int {

    public Age(String mark) {
        super(mark, 16, 60);
    }

    public Age(String mark, int min) {
        super(mark, min, 60);
    }

    public Age(String mark, int min, int max) {
        super(mark, min, max);
    }
}
