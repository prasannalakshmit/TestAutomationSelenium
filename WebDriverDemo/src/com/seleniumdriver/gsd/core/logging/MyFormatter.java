package com.seleniumdriver.gsd.core.logging;
import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return  "Source Class Name : "+record.getSourceClassName()+"\n"
                +"Source Method Name : "+ record.getSourceMethodName()+"\n"
                +"Thread ID :"+record.getThreadID()+"\n"
                +"Current Date :"+new Date(record.getMillis())+"\n"
                +record.getMessage()+"\n";
        	 }

}