package ru.job4j.generic;

import java.util.Iterator;
import java.util.stream.Stream;

public class AbstractStore implements Store {
    protected final SimpleArray<Base> baseSimpleArray;

    public AbstractStore(int size) {
        this.baseSimpleArray = new SimpleArray<>(size);
    }

    @Override
    public void add(Base model) {
        this.baseSimpleArray.add(model);
    }

    @Override
    public boolean replace(String id, Base model) {
        return baseSimpleArray.set(baseSimpleArray.get(getIndexById(id)), model);
    }

    @Override
    public boolean delete(String id) {
        return baseSimpleArray.remove(getIndexById(id));
    }

    @Override
    public Base findById(String id) {
        return baseSimpleArray.get(getIndexById(id));
    }

    protected int getIndexById(String id) {
        int result = -1;
        Iterator<Base> baseIterator = baseSimpleArray.iterator();
        for (int i = 0; baseIterator.hasNext(); i++) {
            if (baseIterator.next().getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
