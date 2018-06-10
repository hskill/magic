package info.ideatower.magic.random.time;

import info.ideatower.magic.Schema;
import org.junit.Test;

public class TimestampTest {

    @Test
    public void next() {
        Schema.of("test", new Timestamp("t")).asText().template("${t}").toPrint();
    }
}