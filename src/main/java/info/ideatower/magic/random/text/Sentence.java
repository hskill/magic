package info.ideatower.magic.random.text;

import info.ideatower.magic.random.value.PickerFromFile;

/**
 * 句子生成
 */
public class Sentence extends PickerFromFile {

    public Sentence(String mark) {
        super(mark, "text/sentences.txt");
    }
}
