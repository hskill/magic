package info.ideatower.magic.random.color;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

import static org.junit.Assert.*;

public class HexColorTest {

    @Test
    public void next() {

        HexColor color = new HexColor("color");

        Magic.schame(
            new HexColor("color")
        ).as().str("${color}\n", new OutputStreamWriter(System.out));
    }
}