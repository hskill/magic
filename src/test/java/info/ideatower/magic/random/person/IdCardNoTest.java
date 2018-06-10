package info.ideatower.magic.random.person;

import info.ideatower.magic.Schema;
import org.junit.Test;

import static org.junit.Assert.*;

public class IdCardNoTest {

    @Test
    public void next() {

        Schema.of("test", new IdCard("idcard")).count(10).asText().template("${idcard}").toPrint();
    }
}