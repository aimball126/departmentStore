package utilities;

import java.util.Date;

public class Period implements Validator {

    private Date startDate;
    private Date endDate;

    public Period(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public boolean validate(Date today) {
        return today.after(startDate) && today.before(endDate);
    }

}
