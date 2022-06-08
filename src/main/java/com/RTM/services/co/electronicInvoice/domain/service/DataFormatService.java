package com.RTM.services.co.electronicInvoice.domain.service;

import java.text.DecimalFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DataFormatService {

    public static String setDateFormat(Date date){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateFormat.format(date.toInstant().atZone(ZoneId.systemDefault()));
    }
    public static Date setStringToDate(String date){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return (Date) dateFormat.parse(date);
    }
    public static String setTimeFormat(Date date){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("HH:mm:ss[XXX]");
        return dateFormat.format(date.toInstant().atZone(ZoneId.systemDefault()));
    }
    public static String setDateLocale(Date date){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss[XXX]");
        return dateFormat.format(date.toInstant().atZone(ZoneId.systemDefault()));
    }
    public static String getDateFromFormat(Date date,String format){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(format);
        return dateFormat.format(date.toInstant().atZone(ZoneId.systemDefault()));
    }
    public static String setDoubleFormat(double number){
        DecimalFormat doubleFormat = new DecimalFormat("0.00");
        return doubleFormat.format(number);
    }
    public static String setYearLastDigitFormat(Date date){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yy");
        return dateFormat.format(date.toInstant().atZone(ZoneId.systemDefault()));
    }
}
