package info.ideatower.magic.random.identity;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

import static org.junit.Assert.*;

public class IncrementTest {

    @Test
    public void next() {

        Magic.schame(
                new Increment("increment", 2)
        ).as().str("${increment}\n", new OutputStreamWriter(System.out));
    }
}