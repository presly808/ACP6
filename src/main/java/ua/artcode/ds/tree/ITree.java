package ua.artcode.ds.tree;

/**
 * Created by serhii on 25.04.15.
 */
public interface ITree <E> {

    boolean add(E el);
    E remove(E el);
    boolean contains(E el);
    void traverse();

}
