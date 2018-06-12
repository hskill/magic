package info.ideatower.magic.random.web;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.color.HexColor;
import info.ideatower.magic.random.text.Letter;

import java.text.MessageFormat;

/**
 * 图片地址
 *
 * https://dummyimage.com
 */
public class ColorImage extends AbstractRandomValue<String> {

    public static final int JPG = 1;
    public static final int PNG = 2;
    public static final int GIF = 3;

    private final HexColor color;
    private final Letter letter;

    private int width = Integer.MIN_VALUE;
    private int height = Integer.MIN_VALUE;
    private int format = 1; // 1. jpg 2. png 3. gif
    private String ratio;

    public ColorImage(String mark) {
        super(mark);
        this.color = new HexColor(mark);
        this.letter = new Letter(mark).upper();
    }

    public ColorImage width(int width) {
        this.width = width;
        return this;
    }

    public ColorImage height(int height) {
        this.height = height;
        return this;
    }

    public ColorImage format(int format) {
        this.format = format;
        return this;
    }

    public ColorImage ratio(int widthRatio, int heightRatio) {
        this.ratio = widthRatio + ":" + heightRatio;
        return this;
    }

    @Override
    public String next() {
        return MessageFormat.format("https://dummyimage.com/{0}/{1}/{2}.{3}&text={4}",
                getSize(),
                this.color.next().substring(1),
                this.color.next().substring(1),
                getFormatStr(),
                this.letter.next());
    }

    private String getFormatStr() {
        if (this.format == PNG) {
            return "png";
        }
        else if (this.format == GIF) {
            return "gif";
        }
        else {
            return "jpg";
        }
    }

    private String getSize() {
        if (this.height == Integer.MIN_VALUE && this.width != Integer.MIN_VALUE) {

            if (this.ratio != null) {
                return this.width + "x" + this.ratio;
            }

            return String.valueOf(this.width);
        }
        else if (this.height != Integer.MIN_VALUE && this.width == Integer.MIN_VALUE) {

            if (this.ratio != null) {
                return this.ratio + "x" + this.height;
            }
            return String.valueOf(this.height);
        }
        else if (this.width == Integer.MIN_VALUE && this.height == Integer.MIN_VALUE) {
            // default value
            return "200";
        }
        else {
            return this.width + "x" + this.height;
        }
    }
}
