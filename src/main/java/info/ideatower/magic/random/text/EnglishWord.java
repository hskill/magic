package info.ideatower.magic.random.text;

import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 英语单词
 */
public class EnglishWord extends Picker<String> {

    public EnglishWord(String mark) {
        super(mark);
        this.values(FileLoader.loadResource("text/englishwords.txt"));
    }
}
