package info.ideatower.magic.random.person;

import info.ideatower.magic.random.AbstractRandomValue;
import info.ideatower.magic.random.time.DateTime;
import info.ideatower.magic.random.value.Int;
import info.ideatower.magic.random.value.Picker;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * 身份证号码生成
 *
 * 可以参考身份证的规则与校验位生成
 */
public class IdCard extends AbstractRandomValue<String> {

    // 随机生成省、自治区、直辖市代码 1-2
    private static final String[] PROVINCES = { "11", "12", "13", "14", "15", "21", "22", "23",
            "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
            "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
            "63", "64", "65", "71", "81", "82" };

    private static final int[] CHK_WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final String CHK_CHECKS = "10X987654342";

    private static final SimpleDateFormat BIRTHDAY_SDF = new SimpleDateFormat("yyyyMMdd");

    private final Picker province;
    private final DateTime birthday;
    private final Int city;
    private final Int county;
    private final Int serial;
    private final NumberFormat formatter;

    public IdCard(String mark) {
        super(mark);
        this.province = new Picker<String>(mark).values(PROVINCES);
        this.city = new Int(mark).between(1, 18 + 1);
        this.county = new Int(mark).between(1, 28 + 1);
        this.birthday = new DateTime(mark).year(1978, Calendar.getInstance(Locale.getDefault()).get(Calendar.YEAR) - 10);
        this.serial = new Int(mark).between(100, 899);

        this.formatter = NumberFormat.getIntegerInstance();
        this.formatter.setMinimumIntegerDigits(2);
    }

    @Override
    public String next() {
        String number16 = MessageFormat.format("{0}{1}{2}{3}{4}",
                this.province.next(),
                this.formatter.format(this.city.next()),
                this.formatter.format(this.county.next()),
                BIRTHDAY_SDF.format(this.birthday.next()),
                this.serial.next());

        int sum = 0;
        for (int i = 0; i < number16.length(); i++) {
            int current = Integer.parseInt(number16.substring(i, i + 1));
            sum = sum + (CHK_WEIGHT[i] * current);
        }

        return number16 + CHK_CHECKS.toCharArray()[sum % 11];
    }
}
