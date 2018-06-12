package info.ideatower.magic.random.text;

import org.junit.Test;

public class StrTest {

    @Test
    public void next() {
        System.out.println(new Str("").pool('a', 'b', 'c').count(10).next());
    }
}