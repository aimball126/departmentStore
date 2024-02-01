package utilities;

import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

public class DayOfWeek implements Validator {

    private String[] daysOfWeek;

    public DayOfWeek(String[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    @Override
    public boolean validate(Date today) {
        String todayName = today.toString().substring(0, 3).toUpperCase(Locale.ROOT); // Get day name in uppercase
        return Arrays.asList(daysOfWeek).contains(todayName);
    }

}
