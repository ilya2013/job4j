package ru.job4j.tree;

import java.util.*;

public class SimpleTree<E extends Comparable<E>> implements Tree<E> {
    private Node<E> root;
    transient private int modCount = 0;
    private int size = 0;

    public SimpleTree(E root) {
        this.root = new Node<E>(root);
        size++;
    }

    /**
     * Добавление дочернего элемента в дерево.
     *
     * @param parent parent.
     * @param child  child.
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = false;
        Optional<Node<E>> parentNode = findBy(parent);
        if (parentNode.isPresent() && !findBy(child).isPresent()) {
            parentNode.get().add(new Node<>(child));
            result = true;
            modCount++;
            size++;
        }
        return result;
    }

    /**
     * Поиск Node по значению.
     *
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
    public boolean isBinary() {
        Iterator<Node<E>> iterator = new NodeIterator();
        Node<E> node;
        boolean result = false;
       if (iterator.hasNext()) {
           result = iterator.next().leaves().size() >= 2;
       }
        return result;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {
            Queue<Node<E>> data = new LinkedList<>();
            int expectedModCount = modCount;
            boolean needInit = true;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (needInit) {
                    init();
                    needInit = false;
                }
                return data.size() > 0;
            }

            @Override
            public E next() {
                Node<E> node;
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                node = data.poll();
                addLeaves(node);
                return node.getValue();
            }

            /**
             * Инициализация итератора.
             */
            private void init() {
                if (root != null) {
                    data.add(root);
                }
            }

            /**
             * Добавление дочерних элементов узла в очередь.
             * @param node узел.
             */
            private void addLeaves(Node<E> node) {
                for (Node<E> leave : node.leaves()) {
                    data.add(leave);
                }
            }
        };
    }
    private class NodeIterator implements Iterator<Node<E>> {

        Queue<Node<E>> data = new LinkedList<>();
        int expectedModCount = modCount;
        boolean needInit = true;

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (needInit) {
                init();
                needInit = false;
            }
            return data.size() > 0;
        }

        @Override
        public Node<E> next() {
            Node<E> node;
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            node = data.poll();
            addLeaves(node);
            return node;
        }

        /**
         * Инициализация итератора.
         */
        private void init() {
            if (root != null) {
                data.add(root);
            }
        }

        /**
         * Добавление дочерних элементов узла в очередь.
         * @param node узел.
         */
        private void addLeaves(Node<E> node) {
            for (Node<E> leave : node.leaves()) {
                data.add(leave);
            }
        }
    }
}
