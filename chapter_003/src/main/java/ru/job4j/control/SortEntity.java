package ru.job4j.control;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;


public class SortEntity {
    /**
     * Сортировка отделов по возрастанию.
     *
     * @param departments Список отделов.
     * @return Отсортированный список.
     */
    public List<Department> sortDepartmentsAsc(List<Department> departments) {
        departments = new ArrayList(addElements(departments));
        departments.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return departments;
    }

    /**
     * Сортировка отделов по убыванию.
     *
     * @param departments Список отделов.
     * @return Отсортированный список.
     */
    public List<Department> sortDepartmentsDesc(List<Department> departments) {
        departments = new ArrayList(addElements(departments));
        departments.sort(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                int result;
                if (o1.getName().length() == o2.getName().length()) {
                    result = o2.getName().compareTo(o1.getName());
                } else {
                    int size = Math.min(o1.getName().length(), o2.getName().length());
                    char[] firstArr = o1.getName().toCharArray();
                    char[] secondArr = o2.getName().toCharArray();
                    StringBuilder outFirst = new StringBuilder();
                    StringBuilder outSecond = new StringBuilder();
                    for (int i = 0; i < size; i++) {
                        outFirst.append(firstArr[i]);
                        outSecond.append(secondArr[i]);
                    }
                    String first = outFirst.toString();
                    String second = outSecond.toString();
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
        return departments;
    }

    /**
     * Вставка элементов  в список.
     *
     * @param departments Список отделов.
     * @return Обновленный список.
     */
    public List<Department> addElements(List<Department> departments) {
        List<Department> list = new ArrayList<>(departments);
        ListIterator<Department> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Department department = iterator.next();
            if (!department.getName().contains("\\")) {
                continue;
            }
            String prevStr = getPrevDepartmentString(department);
            if (!isPrevDepartmentExists(list, prevStr)) {
                iterator.add(new Department(prevStr));
            }
        }
        return list;
    }

    /**
     * Поиск верхнего отдела.
     *
     * @param list    Список отделов.
     * @param prevStr Наимнеования отдела.
     * @return Найден ли отдел с таким именем.
     */
    private boolean isPrevDepartmentExists(List<Department> list, String prevStr) {
        for (Department tmp : list) {
            if (tmp.getName().equals(prevStr)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Получить наименование верхнего отдела.
     *
     * @param department Отдел.
     * @return Наименования отдела.
     */
    private String getPrevDepartmentString(Department department) {
        String[] arr = department.getName().split("\\\\");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 2) {
                sb.append("\\");
            }
        }
        return sb.toString();
    }
}
