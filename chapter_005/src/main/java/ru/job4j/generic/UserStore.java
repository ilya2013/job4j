package ru.job4j.generic;

public class UserStore extends AbstractStore {

    public UserStore(int size) {
        super(size);
    }

    public void add(User model) {
        super.add(model);
    }

    public boolean replace(String id, User model) {
        return super.baseSimpleArray.set(super.baseSimpleArray.get(getIndexById(id)), model);
    }
}


