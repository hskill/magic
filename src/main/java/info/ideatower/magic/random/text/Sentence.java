package info.ideatower.magic.random.text;


import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 句子生成
 */
public class Sentence extends Picker<String> {

    public Sentence(String mark) {
        super(mark);
        this.values(FileLoader.loadResource("text/sentences.txt"));
    }
}
