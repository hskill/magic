package info.ideatower.magic.random.value;

import info.ideatower.magic.random.AbstractRandomValue;

/**
 * 返回boolean
 *
 * likelihooo 表示返回true的概率
 */
public class Bool extends AbstractRandomValue<Boolean> {

    private int likelihood = 50;

    public Bool(String mark) {
        super(mark);
    }

    public Bool likelihood(int likelihood) {
        this.likelihood = likelihood % 100;
        return this;
    }

    @Override
    public Boolean next() {
        return random.nextInt(100) > 100 - this.likelihood;
    }
}
