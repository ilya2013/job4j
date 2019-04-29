package set;

import ru.job4j.list.DynamicArrayContainer;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<E> implements Iterable<E> {
    private final DynamicArrayContainer<E> simpleList = new DynamicArrayContainer<E>(10);

    void add(E e) {
        Iterator<E> iterator = simpleList.iterator();
        E element;
        if (!containsElement(e)) {
            simpleList.add(e);
        }
    }

    private boolean containsElement(E e) {
      boolean result = false;
        Iterator<E> iterator = simpleList.iterator();
        E element;
        while (iterator.hasNext()) {
            element = iterator.next();
            if (Objects.equals(e, element)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleList.iterator();
    }
}
