package info.ideatower.magic.util;

import info.ideatower.magic.Randomable;


public class Repeater {

    /**
     * 重复生成数据
     * @param able
     * @param repeat
     * @return
     */
    public static Object[] objs(Randomable able, int repeat) {
        Object[] result = new Object[repeat];
        for (int i = 0; i < repeat; i++) {
            result[i] = able.next();
        }
        return result;
    }

    public static String str(Randomable able, int repeat) {
        return str(able, repeat, "");
    }

    public static String str(Randomable able, int repeat, String join) {
        StringBuilder result = new StringBuilder();
        Object[] objs = objs(able, repeat);
        int i = 0;
        for (; i < objs.length - 1; i++) {
            Object item = objs[i];
            result.append(String.valueOf(item));
            result.append(join);
        }
        result.append(String.valueOf(objs[i]));
        return result.toString();
    }
}
