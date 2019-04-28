package set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArrayList<E> simpleList = new SimpleArrayList<E>();

    void add(E e) {
        Iterator<E> iterator = simpleList.iterator();
        //E addelement = e;
        E element;
        boolean containsElement = false;
        while (iterator.hasNext()) {
            element = iterator.next();
            if (Objects.equals(e, element)) {
                containsElement = true;
                break;
            }
        }
        if (!containsElement) {
            simpleList.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return simpleList.iterator();
    }
}
