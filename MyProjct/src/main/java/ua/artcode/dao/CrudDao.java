package ua.artcode.dao;

import ua.artcode.model.User;

import java.util.List;

/**
 * Created by serhii on 07.06.15.
 */
public interface CrudDao<T> {

    T create(T user);

    T findById(long id);

    void delete(long id);

    void update(T user);

    List<T> findAll();

}
