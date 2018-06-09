package info.ideatower.magic.random.text;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class WordTest {

    @Test
    public void test() {

        Magic.schema("test", new Word("w")).asText().size(10).template("${w}").toPrint();
    }

}