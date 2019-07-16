package ru.job4j.tree;

import java.util.*;

public class SimpleTree<E extends Comparable<E>> implements Tree<E> {
    private Node<E> root;
    transient private int modCount = 0;

    public SimpleTree(E root) {
        this.root = new Node<E>(root);
    }

    /**
     * Добавление дочернего элемента в дерево.
     * @param parent parent.
     * @param child child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent()) {
            parentNode.get().add(new Node<>(child));
            result = true;
            modCount++;
        }
        return result;
    }

    /**
     * Поиск Node по значению.
     * @param value
     * @return
     */

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            List<Node<E>> data = new ArrayList<>();
            int position = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (data.size() == 0) {
                    init();
                }
                return position < data.size();
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data.get(position++).getValue();
            }

            /**
             * Инициализация итератора.
             */
            private void init() {
                int position = -1;
                if (root != null) {
                    data.add(root);
                    ++position;
                    while (position < data.size()) {
                        for (Node<E> node : data.get(position).leaves()) {
                            data.add(node);
                        }
                        ++position;
                    }
                }
            }
        };
    }
}
