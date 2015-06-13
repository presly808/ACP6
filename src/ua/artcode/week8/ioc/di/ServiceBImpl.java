package ua.artcode.week8.ioc.di;

import java.util.Date;

/**
 * Created by serhii on 13.06.15.
 */
public class ServiceBImpl implements Service  {
    @Override
    public String format(Date date) {
        return String.format("%1$tH-%1$tM-%1$tS", date);
    }
}
