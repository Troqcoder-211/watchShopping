package util;

import java.util.Locale;
import java.text.NumberFormat;

public class ChangeFormat {
    public static String priceFormat(long price){
        Locale locale = new Locale("vi","VN");
        NumberFormat vi = NumberFormat.getInstance(locale);
        String strPrice = vi.format(price);
        return strPrice;
    }
}
