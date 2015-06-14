package ua.artcode.week8.ioc.annot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.artcode.week8.ioc.di.Service;

@Component
public class C {

    @Autowired
    @Qualifier("serviceBImpl")
    private Service service;


}
