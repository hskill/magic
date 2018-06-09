package info.ideatower.magic.random.color;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Int;
import info.ideatower.magic.util.Repeater;

import java.text.MessageFormat;

public class RgbColor extends AbstractRandomValue<String> {

    private Int integer;

    public RgbColor(String mark) {
        super(mark);
        // 因为Int使用的是java.lang.Random类对象的next(int bounds) 该方法会排除掉传入的max值，所以需要+1
        this.integer = new Int(mark).between(0, 255 + 1);
    }

    @Override
    public String next() {
        return MessageFormat.format("rgb({0}, {1}, {2})", Repeater.objs(this.integer, 3));
    }
}
