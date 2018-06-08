package info.ideatower.magic.random.web;

import info.ideatower.magic.random.value.Picker;

/**
 * 浏览器 User-Agent
 *
 * 来源：http://www.useragentstring.com/pages/useragentstring.php?name=All
 */
public class UserAgent extends Picker<String> {

    public UserAgent(String mark) {
        super(mark, "web/useragents.txt");
    }
}
