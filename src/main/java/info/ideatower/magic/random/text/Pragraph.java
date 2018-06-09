package info.ideatower.magic.random.text;


import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 段落文本
 *
 * 来源 古文观止（部分） 桃花源记等
 */
public class Pragraph extends Picker<String> {

    public Pragraph(String mark) {
        super(mark);
        this.values(FileLoader.loadResource("text/pragraphs.txt"));
    }
}
