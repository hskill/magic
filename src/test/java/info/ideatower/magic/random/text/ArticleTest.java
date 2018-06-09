package info.ideatower.magic.random.text;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class ArticleTest {

    @Test
    public void next() {

        Magic.schema("test", new Article("a")).asText().size(1).template("${a}").toPrint();
    }
}