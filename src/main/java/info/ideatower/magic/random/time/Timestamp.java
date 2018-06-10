package info.ideatower.magic.random.time;

import info.ideatower.magic.random.AbstractRandomValue;
import org.apache.commons.lang3.Validate;

/**
 * Unix Timestamp
 */
public class Timestamp extends AbstractRandomValue<String> {

    private DateTime datetime;

    public Timestamp(String mark) {
        super(mark);
        this.datetime = new DateTime(mark);
    }


    public Timestamp year(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.datetime.year(start, end);
        return this;
    }

    public Timestamp month(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.datetime.month(start, end);
        return this;
    }

    public Timestamp day(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.datetime.day(start, end);
        return this;
    }

    public Timestamp hour(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.datetime.hour(start, end);
        return this;
    }

    public Timestamp minute(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.datetime.minute(start, end);
        return this;
    }

    public Timestamp second(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.datetime.second(start, end);
        return this;
    }

    @Override
    public String next() {
        return String.valueOf(this.datetime.next().getTime() / 1000);
    }
}
