package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class EmailTest {

    @Test
    public void next() {

        Magic.schema("test", new Email("email")).asText().size(10).template("${email}").toPrint();
    }
}