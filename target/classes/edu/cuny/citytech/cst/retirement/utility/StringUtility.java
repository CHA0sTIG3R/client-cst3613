package edu.cuny.citytech.cst.retirement.utility;

import java.text.DecimalFormat;

public class StringUtility {
    public static String getMoneyFormat(Number number){
        DecimalFormat dFormatMoney = new DecimalFormat("####,###,#00.00");
        String format =  dFormatMoney.format(number.doubleValue() / 1_000_000) + "M";
        return format;
    }

    public static String getPercentageFormat(Number number){
        DecimalFormat dFormatMoney = new DecimalFormat("#00.00");
        String format =  dFormatMoney.format(number.doubleValue() * 100) + "%";
        return format;
    }
}
