package com.saadeh.send_book_email_sb.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class GenerateBookReturnDate {
    public static int numDaysToReturnBook = 7;
    private static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    //Gets the formated return date of the book
    public static String getDate(Date loanDate){
        Calendar calendar = dateToCalendar(loanDate);
        calendar.add(Calendar.DATE,numDaysToReturnBook);
        String result = dateFormat.format(calendarToDate(calendar));
        return result;
    }

    private static Date calendarToDate(Calendar calendar) {
        return calendar.getTime();
    }

    //Converts Date to calendar
    private static Calendar dateToCalendar(Date loanDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(loanDate);
        return calendar;
    }
}
