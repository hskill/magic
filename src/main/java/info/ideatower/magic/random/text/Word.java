package info.ideatower.magic.random.text;

import info.ideatower.magic.random.value.PickerFromFile;

public class Word extends PickerFromFile {
    public Word(String mark) {
        super(mark, "text/words.txt");
    }
}
