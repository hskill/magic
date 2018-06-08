package info.ideatower.magic.random.person;

import org.junit.Test;

public class NameTest {

    @Test
    public void next() {

        Name name = new Name("name");
        for (int i = 0; i < 1000; i++) {
            if (i % 100 == 0) {
                System.out.println(name.next());
            }
        }
    }
}