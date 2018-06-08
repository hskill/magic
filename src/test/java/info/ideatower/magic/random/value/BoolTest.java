package info.ideatower.magic.random.value;

import org.junit.Test;

public class BoolTest {

    @Test
    public void next() {

        Bool bool = new Bool("okay", 40);
        int x = 0;
        for (int i = 0; i < 1000; i++) {

            if (bool.next()) {
                x++;
            }
        }

        System.out.println(x);
    }
}