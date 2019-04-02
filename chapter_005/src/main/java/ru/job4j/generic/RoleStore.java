package ru.job4j.generic;

public class RoleStore extends AbstractStore {
    public RoleStore(int size) {
        super(size);
    }

    public void add(Role model) {
        super.add(model);
    }

    public boolean replace(String id, Role model) {
        return super.baseSimpleArray.set(super.baseSimpleArray.get(getIndexById(id)), model);
    }
}
