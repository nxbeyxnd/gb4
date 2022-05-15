package ru.alexey.task2.linkedListImpl;
/* 
29.04.2022: Alexey created this file inside the package: ru.alexey.task2 
*/

import java.util.*;


 /*
 Not realized:
    public Iterator<E> iterator()
    public ListIterator<E> listIterator(int index)
    public <T> T[] toArray(T[] a)
    public boolean containsAll(Collection<?> c)
    public boolean addAll(int index, Collection<? extends E> c)
  */
public class LinkedListImpl<E> extends AbstractSequentialList<E> implements List<E> {
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    private static class Node<E> {
        private Node<E> prev;
        private E value;
        private Node<E> next;

        public Node(Node<E> prev, E value, Node<E> next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return getByElement(o) == null;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] temp = new Object[size];
        int i = 0;
        for (Node<E> c = first; c != null; c = c.next) {
            temp[i++] = c.value;
        }
        return temp;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    private void addLast(E e) {
        Node<E> lastNode = last;
        Node<E> newNode = new Node<>(lastNode, e, null);
        last = newNode;
        if (lastNode == null) first = newNode;
        else lastNode.next = newNode;
        size++;
    }

    private void addBefore(E e, Node<E> current) {
        Node<E> before = current.prev;
        Node<E> newNode = new Node<>(before, e, current);
        if (before == null) {
            first = newNode;
        } else {
            before.next = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> temp = getByElement(o);
        if (temp == null) return false;
        else return unlinkNode(temp);
    }

    private boolean unlinkNode(Node<E> node) {
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if (prev == null) {
            first = next;
            first.prev = null;
            node.next = null;
        } else if (next == null) {
            last = prev;
            last.next = null;
            node.prev = null;
        } else {
            prev.next = next;
            next.prev = prev;
        }
        size--;
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        c.iterator().forEachRemaining(this::addLast);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] arr = c.toArray();
        for (Object o : arr) {
            remove((E) o);
        }
        return true;
    }

    @Override
    public void clear() {
        for (Node<E> d = first; d != null; ) {
            Node<E> temp = d.next;
            d.prev = null;
            d.value = null;
            d.next = null;
            d = temp;
        }
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkValidIndex(index);
        return getByIndex(index).value;
    }

    private void checkValidIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException(String.format("Index %d out of range of list size %d", index, size));
    }

    private Node<E> getByElement(Object o) {
        for (Node<E> c = first; c != null; c = c.next) {
            if (o.equals(c.value)) return c;
        }
        return null;
    }

    private Node<E> getByIndex(int index) {
        Node<E> currentNode;
        if (index < size / 2) {
            currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
        } else {
            currentNode = last;
            for (int i = size - 1; i > index; i--) {
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    @Override
    public E set(int index, E element) {
        checkValidIndex(index);
        getByIndex(index).value = element;
        return element;
    }

    @Override
    public void add(int index, E element) {
        checkValidIndex(index);
        Node<E> node = getByIndex(index);
        if (index == size) addLast(element);
        else addBefore(element, node);
    }

    @Override
    public E remove(int index) {
        checkValidIndex(index);
        Node<E> nodeToDelete = getByIndex(index);
        unlinkNode(nodeToDelete);
        return nodeToDelete.value;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> toFind = first;
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (toFind.value == null) return i;
                toFind = toFind.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(toFind.value)) return i;
                toFind = toFind.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> toFind = last;
        if (o == null) {
            for (int i = size - 1; i > 0; i--) {
                if (toFind.value == null) return i;
                toFind = toFind.prev;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(toFind.value)) return i;
                toFind = toFind.prev;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node<E> current = first;
        while (current != null) {
            res.append(current.value);
            if (current.next != null) res.append(", ");
            current = current.next;
        }
        return "[" + res + "]";
    }
}
