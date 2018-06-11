package info.ideatower.magic.random.person;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.Str;
import info.ideatower.magic.random.value.Picker;

import java.text.MessageFormat;

/**
 * 移动电话
 */
public class Cellphone extends AbstractRandomValue<String> {
    
    private static final Integer[] PRE =  {139, 138, 137, 136, 135, 134, 150, 151, 152, 157, 158, 159, 182, 183, 187, 188, 147
            ,130, 131, 132, 136, 185, 186, 145
            ,133, 153, 180, 189 };

    private final Picker pre;
    private final Str no;

    public Cellphone(String mark) {
        super(mark);
        this.pre = new Picker<Integer>(mark).values(PRE);
        this.no = new Str(mark).count(8).pool("0123456789");
    }

    @Override
    public String next() {
        return MessageFormat.format("{0}{1}", this.pre.next(), this.no.next());
    }
}
