package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class ImageTest {

    @Test
    public void next() {

        Magic.schema("test",
                new Image("image").width(100))
        .asText().size(5).template("${image}").toPrint();
    }
}