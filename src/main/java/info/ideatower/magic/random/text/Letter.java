package info.ideatower.magic.random.text;

import com.google.common.primitives.Chars;
import info.ideatower.magic.random.value.Picker;


public class Letter extends Picker<Character> {

    public static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";

    public Letter(String mark) {
        this(mark, false);
    }

    public Letter(String mark, boolean isUpper) {

        super(mark,
            isUpper ?
                Chars.asList(LETTERS.toUpperCase().toCharArray()) :
                Chars.asList(LETTERS.toCharArray()));

    }
}
