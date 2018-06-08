package info.ideatower.magic.random;

import info.ideatower.magic.Randomable;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

@Data
public abstract class AbstractRandomValue<T> implements Randomable<T> {

    protected String mark;
    protected Random random;

    public AbstractRandomValue() {
        this(RandomStringUtils.random(5));
    }

    public AbstractRandomValue(String mark) {
        this.mark = mark;
        this.random = new Random();
    }

}
