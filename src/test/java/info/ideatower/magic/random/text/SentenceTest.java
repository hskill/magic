package info.ideatower.magic.random.text;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

import static org.junit.Assert.*;

public class SentenceTest {

    @Test
    public void test() {
        Magic.schame(new Sentence("sentence")).as().str("${sentence}\n", new OutputStreamWriter(System.out));
    }

}