package ru.job4j.generic;

/**
 * @author Ilya B.
 * @version $Id$
 * @since 0.1
 */
public interface Store<T extends Base> {

    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}