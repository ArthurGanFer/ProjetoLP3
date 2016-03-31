package com.lp3.model.dao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author 31338283
 */
@Local
public interface GenericDAO<E> {

    public boolean create(E e);

    public List<E> readAll();

    public E readById(long id);

    public boolean update(E e);

    public boolean delete(E e);

}
