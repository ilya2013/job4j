package ru.job4j.control;

import java.util.*;

public class Company {
    private Set<Department> deparments = new TreeSet<>();

    public void addDepartment(Department department) {
        deparments.add(department);
    }

    public void addDivision(Department department, Department division) {
        if (deparments.contains(department)) {
            department.addChild(division);
        } else {
            department.addChild(division);
            addDepartment(department);
        }
    }

    public List<String> getHierarchy() {
        List<String> result = new ArrayList<>();
        for (Department departmet : deparments) {
            result.add(departmet.getName());
            result.addAll(departmet.getHierarchy());
        }
        return  result;
    }

    public List<String> getHierarchy(Comparator<Department> comparator) {
        List<String> result = new ArrayList<>();
        List<Department> departmentList = new ArrayList<>(deparments);
        departmentList.sort(comparator);
        for (Department departmet : departmentList) {
            result.add(departmet.getName());
            result.addAll(departmet.getHierarchy(comparator));
        }
        return  result;
    }
}
