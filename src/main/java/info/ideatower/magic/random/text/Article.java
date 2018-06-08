package info.ideatower.magic.random.text;


import info.ideatower.magic.random.value.Picker;
import info.ideatower.magic.util.FileLoader;

/**
 * 文章内容
 *
 * 来源 http://www.sogou.com/labs/resource/cs.php
 */
public class Article extends Picker<String> {

    public Article(String mark) {
        super(mark, FileLoader.loadResource("text/content/"));
    }

}
