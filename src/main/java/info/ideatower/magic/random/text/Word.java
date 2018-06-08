package info.ideatower.magic.random.text;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

public class Word extends Picker<String> {
    public Word(String mark) {
        super(mark, FileLoader.loadResource("text/words.txt"));
    }
}
