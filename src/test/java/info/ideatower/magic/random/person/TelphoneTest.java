package info.ideatower.magic.random.person;

import org.junit.Test;

import static org.junit.Assert.*;

public class TelphoneTest {

    @Test
    public void next() {

        System.out.println(new Telphone("test").next());
    }
}