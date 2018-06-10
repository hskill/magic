package info.ideatower.magic.random.person;

import info.ideatower.magic.Schema;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void next() {

        System.out.println(new Bank("b").next());
    }
}