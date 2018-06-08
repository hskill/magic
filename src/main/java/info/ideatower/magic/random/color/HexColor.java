package info.ideatower.magic.random.color;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.Letter;
import info.ideatower.magic.random.text.Str;
import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.Repeater;

import java.text.MessageFormat;

public class HexColor extends AbstractRandomValue<String> {


    private Letter letter;

    public HexColor(String mark) {
        super(mark);
        this.letter = new Letter(mark, "0123456789ABCDEF");
    }

    @Override
    public String next() {
        return MessageFormat.format("#{0}{1}{2}{3}{4}{5}", Repeater.repeat(letter, 6));
    }
}
