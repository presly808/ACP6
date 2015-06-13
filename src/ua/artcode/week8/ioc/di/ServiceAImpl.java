package ua.artcode.week8.ioc.di;

import java.util.Date;

/**
 * Created by serhii on 13.06.15.
 */
public class ServiceAImpl implements Service {
    @Override
    public String format(Date date) {
        return date.toString();
    }
}
