package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;

import java.text.MessageFormat;

/**
 * 图片地址
 *
 * https://dummyimage.com
 */
public class Image extends AbstractRandomValue<String> {

    public Image(String mark) {

    }

    @Override
    public String next() {
        return MessageFormat.format("https://dummyimage.com/{0}x{1}/{2}/009922.{3}&text={4}", "");
    }
}
