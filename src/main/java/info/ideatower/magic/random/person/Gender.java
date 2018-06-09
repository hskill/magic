package info.ideatower.magic.random.person;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Bool;

/**
 * 性别
 */
public class Gender extends AbstractRandomValue<String> {

    private final Bool bool;

    private String male;
    private String female;

    public Gender(String mark) {
        super(mark);
        this.bool = new Bool(mark);
    }

    public Gender female(String female) {
        this.female = female;
        return this;
    }

    public Gender male(String male) {
        this.male = male;
        return this;
    }

    @Override
    public String next() {
        return bool.next() ? this.female : this.male;
    }

}
