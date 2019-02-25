package ru.job4j.control;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CompanyTest {


    @Test
    public void showAscHierarchy() {
        Company company = new Company();
        List<String> result = new ArrayList<>();
        Department department1 = new Department("K1");
        Department department11 = new Department("SK1");
        Department department111 = new Department("SSK1");
        department11.addChild(department111);
        company.addDivision(department1, department11);
        Department department2 = new Department("K2");
        Department department21 = new Department("SK2");
        Department department211 = new Department("SSK1");
        Department department22 = new Department("SK1");
        Department department221 = new Department("SSK1");
        department21.addChild(department211);
        company.addDivision(department2, department21);
        department22.addChild(department221);
        company.addDivision(department2, department22);
        result = company.getHierarchy();
        String[] expected = {"K1", "K1\\SK1", "K1\\SK1\\SSK1", "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK2", "K2\\SK2\\SSK1"};
        assertThat(result.toArray(), is(expected));
    }

    @Test
    public void showDescHierarchy() {
        List<String> result = new ArrayList<>();
        Company company = new Company();
        Department department1 = new Department("K1");
        Department department11 = new Department("SK1");
        Department department111 = new Department("SSK1");
        department11.addChild(department111);
//        department1.addChild(department11);
//        company.addDepartment(department1);
        company.addDivision(department1, department11);
        Department department2 = new Department("K2");
        Department department21 = new Department("SK2");
        Department department211 = new Department("SSK1");
        Department department22 = new Department("SK1");
        Department department221 = new Department("SSK1");
        department21.addChild(department211);
        company.addDivision(department2, department21);
        department22.addChild(department221);
        company.addDivision(department2, department22);
        result = company.getHierarchy(new Comparator<Department>() {
            @Override
            public int compare(Department o1, Department o2) {
                return -1 * o1.compareTo(o2);
            }
        });
        String[] expected = {"K2", "K2\\SK2", "K2\\SK2\\SSK1", "K2\\SK1", "K2\\SK1\\SSK1", "K1", "K1\\SK1", "K1\\SK1\\SSK1"};
        assertThat(result.toArray(), is(expected));
    }
}