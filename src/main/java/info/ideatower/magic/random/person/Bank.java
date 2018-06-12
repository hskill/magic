package info.ideatower.magic.random.person;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Int;
import info.ideatower.magic.util.Repeater;

import java.text.MessageFormat;

/**
 * 银行卡号
 *
 * 可以参考 https://zhuanlan.zhihu.com/p/21399490
 *
 * 目前实现暂时随机生成数字
 */
public class Bank extends AbstractRandomValue<String> {

    /** 发卡行标识代码Bank Identification Number（BIN），又叫发卡机构标识代码Issuer Identification Numbers（IIN）。一般由6位数字组成 */
    private final Int integer;

    public Bank(String mark) {
        super(mark);
        this.integer = new Int(mark).between(0, 9 + 1);
    }

    @Override
    public String next() {
        return MessageFormat.format("62{0}{1}", Repeater.str(this.integer, 4) , Repeater.str(this.integer, 12));
    }
}
