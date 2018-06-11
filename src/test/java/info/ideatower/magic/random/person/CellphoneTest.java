package info.ideatower.magic.random.person;

import org.junit.Test;

import static org.junit.Assert.*;

public class CellphoneTest {

    @Test
    public void next() {
        System.out.println(new Cellphone("test").next());
    }
}