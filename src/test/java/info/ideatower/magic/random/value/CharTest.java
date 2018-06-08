package info.ideatower.magic.random.value;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

import static org.junit.Assert.*;

public class CharTest {

    @Test
    public void test() {
        Magic.schame(
            new Char("ch", "ABCDEFGHIJ")
        ).as().str("${ch}\n", new OutputStreamWriter(System.out));
    }
}