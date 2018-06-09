package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

import static org.junit.Assert.*;

public class ImageTest {

    @Test
    public void next() {

        Magic.schame("image",
                new Image("image").width(64).format(Image.PNG))
                .as()
                .str("${image}\n", new OutputStreamWriter(System.out));
    }
}