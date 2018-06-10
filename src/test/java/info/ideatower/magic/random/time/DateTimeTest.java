package info.ideatower.magic.random.time;

import info.ideatower.magic.Schema;
import org.junit.Test;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Arrays;

public class DateTimeTest {

    @Test
    public void next() {
//        Schema.of("test",
//            new DateTime("dt").year(1990, 2000))
//        .count(9)
//        .asText()
//        .template("${dt?datetime}")
//        .toPrint();


        int[] wi = new int[17];
        for (int i = 1; i < 18; i++) {
            // 获取加权数字
            int winum = (int) (Math.pow(2, i) % 11);
            // 将加权数反向存入数组
            wi[wi.length - i] = winum;
        }

        System.out.println(Arrays.toString(wi));
    }
}