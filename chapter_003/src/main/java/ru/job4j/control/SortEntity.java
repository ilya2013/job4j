package ru.job4j.control;

import java.util.*;


public class SortEntity {

    private Set<Entity> entitys = new TreeSet<>();

    /**
     * Сортировка отделов по убыванию.
     *
     * @return Отсортированный список.
     */
    public List<Entity> sortDepartmentsDesc() {
        List<Entity> departmentsArray = new ArrayList<>();
        departmentsArray.addAll(this.entitys);
        departmentsArray.sort(new Comparator<Entity>() {
            @Override
            public int compare(Entity o1, Entity o2) {
                int result;
                if (o1.getName().length() == o2.getName().length()) {
                    result = o2.getName().compareTo(o1.getName());
                } else {
                    int size = Math.min(o1.getName().length(), o2.getName().length());
                    String first = o1.getName().substring(0, size);
                    String second = o2.getName().substring(0, size);
                    if (first.compareTo(second) == 0 && o1.getName().length() > o2.getName().length()) {
                        result = 1;
                    } else if (first.compareTo(second) == 0 && o1.getName().length() < o2.getName().length()) {
                        result = -1;
                    } else {
                        result = o2.getName().compareTo(o1.getName());
                    }
                }
                return result;
            }
        });
        return departmentsArray;
    }

    /**
     * Вставка элементов  в список.
     *
     * @param entitys Список отделов.
     */
    public void addElements(List<Entity> entitys) {
        this.entitys.addAll(entitys);
        for (Entity entity : entitys) {
            for (String name : getHigherDepartments(entity)) {
                if (!name.isEmpty()) {
                    this.entitys.add(new Entity(name.toString()));
                }
            }
        }
    }

    public Set<Entity> getEntity() {
        return this.entitys;
    }

    /**
     * Получить наименования верхних отделов.
     *
     * @param department Отдел.
     * @return Наименования отдела.
     */
    private List<String> getHigherDepartments(Entity department) {
        StringBuilder path = new StringBuilder();
        String[] arr = department.getName().split("\\\\");
        List<String> result = new ArrayList<>();
        if (arr.length > 0) {
            path.append(arr[0]);
            result.add(path.toString());
        }
        for (int i = 1; i < arr.length - 1; i++) {
            path.append("\\");
            path.append(arr[i]);
            result.add(path.toString());
        }
        return result;
    }
}
