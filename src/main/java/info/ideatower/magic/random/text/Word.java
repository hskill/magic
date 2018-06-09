package info.ideatower.magic.random.text;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 中文词语
 */
public class Word extends Picker<String> {

    public Word(String mark) {
        super(mark);
        this.values(FileLoader.loadResource("text/words.txt"));
    }
}
