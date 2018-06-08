package info.ideatower.magic.random.web;

import info.ideatower.magic.Magic;
import org.junit.Test;

import java.io.OutputStreamWriter;

public class EmailTest {

    @Test
    public void next() {

        Email email = new Email("email");
        Magic.schame(email).as().str("EMAIL: ${email}\n", new OutputStreamWriter(System.out));
    }
}