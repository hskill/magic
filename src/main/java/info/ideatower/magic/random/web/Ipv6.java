package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.text.Str;
import info.ideatower.magic.util.Repeater;

/**
 * ipv6
 */
public class Ipv6 extends AbstractRandomValue<String> {

    private final Str value;

    public Ipv6(String mark) {
        super(mark);
        this.value = new Str(mark).pool("0123456789ABCDEF").count(4);
    }
    @Override
    public String next() {
        return Repeater.str(this.value, 8, ":");
    }
}
