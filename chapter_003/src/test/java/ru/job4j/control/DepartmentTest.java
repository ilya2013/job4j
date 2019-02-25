package ru.job4j.control;

import org.junit.Test;

public class DepartmentTest {

    @Test
    public void addChild() {
        Department firstLevel1 = new Department("K1");
        firstLevel1.addChild(new Department("SK1"));
        firstLevel1.addChild(new Department("SK3"));

        Department firstLevel2 = new Department("K2");
        firstLevel2.addChild(new Department("SK1"));
        firstLevel2.addChild(new Department("SK2"));
    }
}