package ru.job4j.control;

import java.util.*;

public class Department implements Comparable {
    private String name;
    private Department parent;
    private Set<Department> childs = new TreeSet<>();

    public Department(String name) {
        this.name = name;
    }

    public void addChild(Department department) {
        department.setParent(this);
        childs.add(department);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        Department right = (Department) o;
        return this.name.compareTo(right.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Department that = (Department) o;
        return Objects.equals(name, that.name)
                && Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    private String pathUpByTheHierarchy() {
        String result = "";
        Department department = this;
        while (true) {
            result = department.getName() + "\\" + result;
            department = department.getParent();
            if (department  == null) {
                break;
            }

        }
        return result.substring(0, result.length() - 1);
    }
    public List<String> getHierarchy() {
        List<String> result = new ArrayList<>();
        for (Department department : childs) {
            result.add(department.pathUpByTheHierarchy());
            result.addAll(department.getHierarchy());
        }
        return result;
    }

    public List<String> getHierarchy(Comparator<Department> comparator) {
        List<String> result = new ArrayList<>();
        List<Department> childList = new ArrayList<>(childs);
        childList.sort(comparator);
        for (Department department : childList) {
            result.add(department.pathUpByTheHierarchy());
            result.addAll(department.getHierarchy(comparator));
        }
        return result;
    }

    public Department getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

//    public String getHierarchy (Comparator<Department> comparator) {
//        String result;
//        childs.so
//        if
//        return
//    }
}
