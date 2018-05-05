package eshop;

import java.util.Iterator;

public interface IDataService<E> {
    Iterator<E> getAllObjects();
}
