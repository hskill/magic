package info.ideatower.magic.random.text;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class EnglishWordTest {

    @Test
    public void test() {
        Magic.schema("test", new EnglishWord("w")).asText().size(10).template("${w}").toPrint();
    }

}