package set;

import org.junit.Test;

public class SimpleSetTest {

    @Test
    public void add() {
        SimpleSet<Integer> simpleSet = new SimpleSet<Integer>();
        simpleSet.add(1);
        simpleSet.add(1);
//        for (Object element : simpleSet) {
//            System.out.printf("Элемент: %s%s", element, System.lineSeparator());
//        }
    }
}