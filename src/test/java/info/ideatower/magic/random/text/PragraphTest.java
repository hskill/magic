package info.ideatower.magic.random.text;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class PragraphTest {

    @Test
    public void test() {

        Magic.schema("test", new Pragraph("p")).asText().size(10).template("${p}").toPrint();
    }

}