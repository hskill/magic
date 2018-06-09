package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class Ipv6Test {

    @Test
    public void next() {
        Magic.schema("test", new Ipv6("ip")).asText().template("${ip}").toPrint();
    }
}