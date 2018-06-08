package info.ideatower.magic.random.color;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Char;
import info.ideatower.magic.util.Repeater;

import java.text.MessageFormat;

/**
 * hex 颜色
 */
public class HexColor extends AbstractRandomValue<String> {

    private Char ch;

    public HexColor(String mark) {
        super(mark);
        this.ch = new Char(mark, "0123456789ABCDEF");
    }

    @Override
    public String next() {
        return MessageFormat.format("#{0}{1}{2}{3}{4}{5}", Repeater.repeat(ch, 6));
    }
}
