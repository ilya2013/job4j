package ru.job4j.generic;

import java.util.Iterator;
import java.util.stream.Stream;

public class AbstractStore<T extends Base> implements Store<T> {
    protected final SimpleArray<T> baseSimpleArray;

    public AbstractStore(int size) {
        this.baseSimpleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(T model) {
        this.baseSimpleArray.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        return baseSimpleArray.set(baseSimpleArray.get(getIndexById(id)), model);
    }

    @Override
    public boolean delete(String id) {
        return baseSimpleArray.remove(getIndexById(id));
    }

    @Override
    public T findById(String id) {
        return baseSimpleArray.get(getIndexById(id));
    }

    protected int getIndexById(String id) {
        int result = -1;
        Iterator<T> baseIterator = baseSimpleArray.iterator();
        for (int i = 0; baseIterator.hasNext(); i++) {
            T baseElement = baseIterator.next();
            if (baseElement != null && baseElement.getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
