package set;

import ru.job4j.list.SimpleArrayList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArrayList<E> simpleList = new SimpleArrayList<E>();

    void add(E e) {
        Iterator<E> iterator = simpleList.iterator();
        //E addelement = e;
        E element;
        boolean containsElement = false;
//        while (iterator.hasNext()) {
//            //element = (e.getClass()) iterator.next();//TODO задание на выполнение
//            //System.out.println(element.getClass());
//            System.out.println(e.getClass());
////            if(e.equals(element)) {
////                containsElement = true;
////                break;
////            };
//        }
        if (!containsElement) {
            simpleList.add(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return simpleList.iterator();
    }
}
