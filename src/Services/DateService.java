package src.Services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateService {
    // Predefined date formats as an enum
    public enum DateFormat {
        DATE_ONLY("yyyy-MM-dd"),
        DATE_TIME("yyyy-MM-dd HH:mm:ss"),
        CUSTOM_FORMAT("your_custom_format_here");

        private final String format;

        DateFormat(String format) {
            this.format = format;
        }

        public String getFormat() {
            return format;
        }
    }

    // Get current date in a specific format
    public static String getCurrentDate(DateFormat dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getFormat());
        return sdf.format(new Date());
    }

    // Convert date string to Date object based on a specific format
    public static Date parseDate(String dateString, DateFormat dateFormat) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getFormat());
        return sdf.parse(dateString);
    }

    // Add days to a date
    public static Date addDaysToDate(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, days);
        return calendar.getTime();
    }

    // Format a Date object using a specific format
    public static String formatDate(Date date, DateFormat dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat.getFormat());
        return sdf.format(date);
    }


    // Example of usage
    public static void main(String[] args) throws ParseException {
        String currentDate = getCurrentDate(DateFormat.DATE_ONLY);
        System.out.println("Current date in yyyy-MM-dd format: " + currentDate);

        String customDate = "2023-12-31";
        Date parsedDate = parseDate(customDate, DateFormat.DATE_ONLY);
        System.out.println("Parsed date: " + parsedDate);

        Date futureDate = addDaysToDate(new Date(), 7);
        System.out.println("Date 7 days from now: " + futureDate);
    }
}
