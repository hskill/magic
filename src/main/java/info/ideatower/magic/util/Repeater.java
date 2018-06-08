package info.ideatower.magic.util;

import info.ideatower.magic.Randomable;

public class Repeater {

    /**
     * 重复生成数据
     * @param able
     * @param repeat
     * @return
     */
    public static Object[] repeat(Randomable able, int repeat) {
        Object[] result = new Object[repeat];
        for (int i = 0; i < repeat; i++) {
            result[i] = able.next();
        }
        return result;
    }
}
