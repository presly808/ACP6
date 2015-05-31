package ua.artcode.converter;

import ua.artcode.model.User;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by serhii on 31.05.15.
 */
public interface ORConverter<T> {

    T convert(ResultSet rs);
    List<T> convertAll(ResultSet rs);


}
