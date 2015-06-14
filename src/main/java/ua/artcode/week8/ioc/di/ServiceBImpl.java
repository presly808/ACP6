package ua.artcode.week8.ioc.di;

import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class ServiceBImpl implements Service  {
    @Override
    public String format(Date date) {
        return String.format("%1$tH-%1$tM-%1$tS", date);
    }
}
