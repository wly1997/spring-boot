package com.wuly.untils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    //日期转换成字符串
    public static String datetostring(Date date,String patt){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;

    }
    //字符串转换成1日期
    public static Date stringtoDate(String patt,String str) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date date = simpleDateFormat.parse(str);
        return date;
    }


}
