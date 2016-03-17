package com.sudheer.calendar;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: Sudheer
 * Date: 8/19/15
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */

public class CalendarUtility {

    private static CalendarUtility instance = new CalendarUtility();

    private CalendarUtility() {
    }

    public static CalendarUtility getInstance() {
        return instance;
    }

    public static final String FORMAT1 = "dd-MMM-yy";
    public static final String FORMAT2 = "dd-MMM-yy";
    public static final String FORMAT3 = "dd-MMM-yy";
    public static final String FORMAT4 = "dd-MMM-yy";

    public static enum Format {
        FORMAT1("dd-MMM-yy"), FORMAT2("dd-MMM-yyyy"), FORMAT3("dd-Month-yyyy");

        private String formatStr;

        Format(String formatStr) {
            this.formatStr = formatStr;
        }

        public String getFormatStr() {
            return formatStr;
        }

        public void setFormatStr(String formatStr) {
            this.formatStr = formatStr;
        }
    }

    public static Date convertToDate(final String dateStr) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-YY");
        final Date convertedDate = dateFormat.parse(dateStr);
        return convertedDate;
    }

    public static Calendar strFormatddMMMyyToCalendarDate(final String dateStrddMMMyy) throws ParseException {
        SimpleDateFormat dateFormat = null;
        final Pattern pattern1 = Pattern.compile("^[0-9]{1,2}-[a-zA-Z]{3}-[0-9]{2}$");
        final Matcher matcher1 = pattern1.matcher(dateStrddMMMyy);
        if (matcher1.matches()) {
            dateFormat = new SimpleDateFormat("dd-MMM-yy");
        } else {
            throw new ParseException("Improper Format or invalid date String. Pls make sure the date string is of " +
                    "the Format dd-MMM-yy Eg. 30-Dec-96", 1);
        }
        final Date convertedDate = dateFormat.parse(dateStrddMMMyy);
        final Calendar convertedCal = Calendar.getInstance();
        convertedCal.setTime(convertedDate);
        return convertedCal;
    }


    public static Calendar strFormatddMMMyyyyToCalendarDate(final String dateStrddMMMyyyy) throws ParseException {
        SimpleDateFormat dateFormat = null;
        final Pattern pattern2 = Pattern.compile("^[0-9]{1,2}-[a-zA-Z]{3}-[0-9]{4}$");
        final Matcher matcher2 = pattern2.matcher(dateStrddMMMyyyy);
        if (matcher2.matches()) {
            dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        } else {
            throw new ParseException("Improper Format or invalid date String. Pls make sure the date string is " +
                    "of the Format dd-MMM-yyyy Eg. 30-Dec-1996", 2);
        }
        final Date convertedDate = dateFormat.parse(dateStrddMMMyyyy);
        final Calendar convertedCal = Calendar.getInstance();
        convertedCal.setTime(convertedDate);
        return convertedCal;
    }

    public static Calendar strFormatddMonthyyyyToCalendarDate(final String dateStrddMonthyyyy) throws ParseException {
        SimpleDateFormat dateFormat = null;
        final Pattern pattern3 = Pattern.compile("^[0-9]{1,2}-[a-zA-Z]{1,15}-[0-9]{4}$");
        final Pattern pattern4 = Pattern.compile("^[0-9]{1,2}-[0-12]{2}-[0-9]{4}$");
        final Matcher matcher3 = pattern3.matcher(dateStrddMonthyyyy);
        if (matcher3.matches()) {
            dateFormat = new SimpleDateFormat("dd-MMMMMM-yyyy");
        } else {
            throw new ParseException("Improper Format or invalid date String. Pls make sure the date string is of" +
                    " the Format dd-Month-yyyy Eg. 30-December-1996", 3);
        }
        final Date convertedDate = dateFormat.parse(dateStrddMonthyyyy);
        final Calendar convertedCal = Calendar.getInstance();
        convertedCal.setTime(convertedDate);
        return convertedCal;
    }


    public static Calendar strFormatHHmmToCalendarTime(final String timeStr) throws ParseException {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        final Date convertedDate = dateFormat.parse(timeStr);
        final Calendar convertedCal = Calendar.getInstance();
        convertedCal.setTime(convertedDate);
        return convertedCal;
    }

    public static String calendarDateToStrFormatddMMMyyyy(final Calendar cal) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        return dateFormat.format(cal.getTime());
    }

    public static String calendarDateToStrFormatddMMyyyy(final Calendar cal) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return dateFormat.format(cal.getTime());
    }

    public static String calendarDateToStrFormatddMMMyyyyHHMM(final Calendar cal) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(cal.getTime());
    }

    public static String calendarDateToStringFormatddMMyyyyHHMMSS(final Calendar cal) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        return dateFormat.format(cal.getTime());
    }

    public static String calendarDateToStringFormatyyyyMMddHHMMSS(final Calendar cal) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(cal.getTime());
    }

    public static String calendarDateToStrFormatdd_MMM_yyyy(Calendar cal) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MMM_yyyy");
        return dateFormat.format(cal.getTime());
    }

    public static String calendarDateToStrFormatddMMMyy(final Calendar cal) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yy");
        return dateFormat.format(cal.getTime());
    }


    public static boolean validateConvertedDate(final String dateStr, final Calendar dateCal) {
        boolean result = true;
        final Pattern pattern1 = Pattern.compile("^[0-9]{1,2}-[a-zA-Z]{3}-[0-9]{2}$");
        final Pattern pattern2 = Pattern.compile("^[0-9]{1,2}-[a-zA-Z]{3}-[0-9]{4}$");
        final Pattern pattern3 = Pattern.compile("^[0-9]{1,2}-[a-zA-Z]{15}-[0-9]{4}$");
        final Matcher matcher1 = pattern1.matcher(dateStr);
        final Matcher matcher2 = pattern2.matcher(dateStr);
        final Matcher matcher3 = pattern3.matcher(dateStr);
        final StringTokenizer strTokenizer = new StringTokenizer(dateStr, "-");
        strTokenizer.nextToken();
        final String strMonth = strTokenizer.nextToken();
        final String strYear = strTokenizer.nextToken();
        String calMonth = null;
        String calYear = null;
        if (matcher1.matches()) {
            calMonth = dateCal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
            calYear = Integer.toString(dateCal.get(Calendar.YEAR)).substring(2);
        } else if (matcher2.matches()) {
            calMonth = dateCal.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.getDefault());
            calYear = Integer.toString(dateCal.get(Calendar.YEAR));
        } else if (matcher3.matches()) {
            calYear = Integer.toString(dateCal.get(Calendar.YEAR));
        }

        if (!(strMonth.equalsIgnoreCase(calMonth)))
            result = false;
        if (!(strYear.equalsIgnoreCase(calYear)))
            result = false;
        return result;
    }

    public static Calendar stringToCalenderConversion(final String inputDate) {
        final DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date = null;
        try {
            date = formatter.parse(inputDate);
        } catch (ParseException e) {
            System.out.println(e.getLocalizedMessage());
        }
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static long daysBetweenCalendarDates(final Calendar firstDate, final Calendar secondDate) {
        return ((secondDate.getTimeInMillis() - firstDate.getTimeInMillis()) / (1000 * 60 * 60 * 24));
    }

    public static Calendar addDaysToCalendarDate(final Calendar calDate, final int days) {
        calDate.add(Calendar.DAY_OF_YEAR, days);
        return calDate;
    }

    public static int compareDates(final Calendar firstCal, final Calendar secondCal) {
        int result = 0;
        if (firstCal.get(Calendar.YEAR) > secondCal.get(Calendar.YEAR))
            result = 1;
        else if (firstCal.get(Calendar.YEAR) < secondCal.get(Calendar.YEAR))
            result = -1;
        else {
            if (firstCal.get(Calendar.MONTH) > secondCal.get(Calendar.MONTH))
                result = 1;
            else if (firstCal.get(Calendar.MONTH) < secondCal.get(Calendar.MONTH))
                result = -1;
            else {
                if (firstCal.get(Calendar.DATE) > secondCal.get(Calendar.DATE))
                    result = 1;
                else if (firstCal.get(Calendar.DATE) < secondCal.get(Calendar.DATE))
                    result = -1;
            }
        }
        return result;
    }

    public static int compareDateTime(final Calendar firstCal, final Calendar secondCal) {
        int result = 0;
        result = compareDates(firstCal, secondCal);
        if (result == 0) {
            result = compareTime(firstCal, secondCal);
        }
        if (result == 1)
            System.out.println("first date is greater than the second");
        else if (result == -1)
            System.out.println("second date is greater than the first");
        else if (result == 0)
            System.out.println("both the first & second dates are equal");
        return result;
    }

    public static int compareTime(final Calendar firstCal, final Calendar secondCal) {
        int result = 0;
        {
            {
                System.out.println("Calendar.AM_PM = 0, so comparing HOUR_OF_DAY");
                System.out.println("firstCal HOUR_OF_DAY " + firstCal.get(Calendar.HOUR_OF_DAY));
                System.out.println("secondCal HOUR_OF_DAY " + secondCal.get(Calendar.HOUR_OF_DAY));
                if (firstCal.get(Calendar.HOUR_OF_DAY) > secondCal.get(Calendar.HOUR_OF_DAY))
                    result = 1;
                else if (firstCal.get(Calendar.HOUR_OF_DAY) < secondCal.get(Calendar.HOUR_OF_DAY))
                    result = -1;
            }
            if (result == 0) {
                System.out.println("Calendar HOURS are equal so , comparing MINUTES");
                System.out.println("firstCal MINUTE " + firstCal.get(Calendar.MINUTE));
                System.out.println("secondCal MINUTE" + secondCal.get(Calendar.MINUTE));
                if (firstCal.get(Calendar.MINUTE) > secondCal.get(Calendar.MINUTE))
                    result = 1;
                else if (firstCal.get(Calendar.MINUTE) < secondCal.get(Calendar.MINUTE))
                    result = -1;
                if (result == 0) {
                    System.out.println("Calendar MINUTES are equal so , comparing SECOND");
                    System.out.println("firstCal SECOND " + firstCal.get(Calendar.SECOND));
                    System.out.println("secondCal SECOND" + secondCal.get(Calendar.SECOND));
                    if (firstCal.get(Calendar.SECOND) > secondCal.get(Calendar.SECOND))
                        result = 1;
                    else if (firstCal.get(Calendar.SECOND) < secondCal.get(Calendar.SECOND))
                        result = -1;
                    if (result == 0) {
                        System.out.println("Calendar SECONDS are equal so , comparing MILLI SECOND");
                        if (firstCal.get(Calendar.MILLISECOND) > secondCal.get(Calendar.MILLISECOND))
                            result = 1;
                        else if (firstCal.get(Calendar.MILLISECOND) < secondCal.get(Calendar.MILLISECOND))
                            result = -1;
                    }
                }
            }
        }
        if (result == 1)
            System.out.println("first date is greater than the second");
        else if (result == -1)
            System.out.println("second date is greater than the first");
        else if (result == 0)
            System.out.println("both the first & second dates are equal");
        return result;
    }

    public static Calendar mergeDateAndTime(final Calendar date, final Calendar time) {
        time.set(Calendar.YEAR, date.get(Calendar.YEAR));
        time.set(Calendar.DAY_OF_MONTH, date.get(Calendar.DAY_OF_MONTH));
        time.set(Calendar.MONTH, date.get(Calendar.MONTH));
        return time;
    }

    public static int calculateDaysBetween(final Calendar start, final Calendar end) {
        final Date startDate = start.getTime();
        final Date endDate = end.getTime();
        long milliseconds = (endDate.getTime() - startDate.getTime()) % (1000l * 60l * 60l * 24l);
        return (int) TimeUnit.MILLISECONDS.toMinutes(milliseconds);
    }
}
