package info.ideatower.magic.random.text;


import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 段落文本
 */
public class Pragraph extends Picker<String> {

    public Pragraph(String mark) {
        super(mark, FileLoader.loadResource("text/pragraphs.txt"));
    }
}
