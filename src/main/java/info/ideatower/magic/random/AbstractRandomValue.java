package info.ideatower.magic.random;

import info.ideatower.magic.Randomable;
import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * 随机数据域抽象类
 * @param <T>
 */
@Data
public abstract class AbstractRandomValue<T> implements Randomable<T> {

    public static final Randomable EMPTY_RANDOMABLE = new Randomable() {
        @Override
        public String getMark() {
            return null;
        }

        @Override
        public Object next() {
            return StringUtils.EMPTY;
        }
    };

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
