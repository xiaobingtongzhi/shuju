package cn.itcast.ssm.utils;

import org.omg.CORBA.StringHolder;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
//    日期转换成字符串
    public static String date2String(Date date,String patt){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }
//    字符串转成日期
    public static Date string2date(String str,String patt) throws ParseException {
        SimpleDateFormat smp=new SimpleDateFormat(patt);
        Date parse = smp.parse(str);
        return parse;
    }
}
