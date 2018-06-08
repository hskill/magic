package info.ideatower.magic.random.text;

import info.ideatower.magic.random.value.PickerFromDir;

/**
 * 文章内容
 *
 * 来源 http://www.sogou.com/labs/resource/cs.php
 */
public class Article extends PickerFromDir {

    public Article(String mark) {
        super(mark, "text/content/");
    }

}
