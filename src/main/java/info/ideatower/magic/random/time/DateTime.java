package info.ideatower.magic.random.time;


import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.value.Int;
import org.apache.commons.lang3.Validate;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 生成时间
 */
public class DateTime extends AbstractRandomValue<Date> {


    private final Calendar calendar;

    private Int year;
    private Int month;
    private Int day;
    private Int hour;
    private Int minute;
    private Int second;

    public DateTime(String mark) {
        super(mark);
        this.calendar = Calendar.getInstance(Locale.getDefault());
        this.year = new Int(mark).between(1949, 2049 + 1);
        this.month = new Int(mark).between(1, 12 + 1);
        this.day = new Int(mark).between(1, 30 + 1);
        this.hour = new Int(mark).between(0, 23 + 1);
        this.minute = new Int(mark).between(0, 59 + 1);
        this.second = new Int(mark).between(0, 59 + 1);

    }

    public DateTime year(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.year.between(start, end);
        return this;
    }

    public DateTime month(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.month.between(start, end);
        return this;
    }

    public DateTime day(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.day.between(start, end);
        return this;
    }

    public DateTime hour(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.hour.between(start, end);
        return this;
    }

    public DateTime minute(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.minute.between(start, end);
        return this;
    }

    public DateTime second(int start, int end) {
        Validate.isTrue(start < 0 || end < 0 || start < end);
        this.second.between(start, end);
        return this;
    }

    @Override
    public Date next() {
        calendar.set(this.year.next(), this.month.next(), this.day.next(), this.hour.next(), this.minute.next(), this.second.next());
        return calendar.getTime();
    }
}
