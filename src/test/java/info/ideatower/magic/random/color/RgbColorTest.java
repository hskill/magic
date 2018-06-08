package info.ideatower.magic.random.color;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

import static org.junit.Assert.*;

public class RgbColorTest {

    @Test
    public void next() {
        Magic.schame(new RgbColor("color"))
                .as().str("${color}", new OutputStreamWriter(System.out));
    }
}