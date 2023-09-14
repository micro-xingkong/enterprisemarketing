package com.seyzn.ruanererzu.util;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConvert implements Converter<String, Date> {
    private SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdfYMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Date convert(String s) {
        if(s == null || s.isEmpty()){
            return null;
        }
        try {
            if(s.length() == 10){
                return sdfYMD.parse(s);
            }else{
                return sdfYMDHMS.parse(s);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}
