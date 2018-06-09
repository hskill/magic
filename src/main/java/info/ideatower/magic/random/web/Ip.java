package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Int;

public class Ip extends AbstractRandomValue<String> {

    private final Int integer;

    public Ip(String mark) {
        super(mark);
        this.integer = new Int(mark).between( 0 , 255);
    }

    @Override
    public String next() {
        return String.format("%d.%d.%d.%d",
                this.integer.next(),
                this.integer.next(),
                this.integer.next(),
                this.integer.next());
    }
}
