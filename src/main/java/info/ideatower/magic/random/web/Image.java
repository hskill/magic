package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Int;

import java.text.MessageFormat;

/**
 * 图片
 *
 * 来源 https://placeimg.com/
 */
public class Image extends AbstractRandomValue<String> {

    private Int integer;
    private int width = Integer.MIN_VALUE;
    private int height = Integer.MIN_VALUE;

    public Image(String mark) {
        super(mark);
        this.integer = new Int(mark).between(200, 600);
    }

    public Image width(int width) {
        this.width = width;
        return this;
    }

    public Image height(int height) {
        this.height = height;
        return this;
    }

    public Image between(int min, int max) {
        this.integer = new Int(this.mark).between(min, max);
        return this;
    }

    @Override
    public String next() {
        return MessageFormat.format("https://placeimg.com/{0}/any", getSize());
    }

    private String getSize() {
        int h = 0;
        int w = 0;
        h = this.height == Integer.MIN_VALUE ?  this.integer.next() : this.height;
        w = this.width == Integer.MIN_VALUE ? this.integer.next() : this.width;
        return w + "/" + h;
    }
}
