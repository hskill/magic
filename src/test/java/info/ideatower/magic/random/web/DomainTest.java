package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class DomainTest {

    @Test
    public void next() {

        Magic.schema("test", new Domain("d")).asText().size(10).template("${d}").toPrint();
    }
}