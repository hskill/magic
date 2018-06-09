package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

public class UrlTest {

    @Test
    public void next() {

        Magic.schema("test", new Url("url")).asText().template("${url}").toPrint();
    }
}