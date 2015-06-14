package ua.artcode.week8.ioc.di;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ServiceAImpl implements Service {
    @Override
    public String format(Date date) {
        return date.toString();
    }
}
