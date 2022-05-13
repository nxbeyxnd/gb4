package ru.alexey.task2;
/* 
13.05.2022: Alexey created this file inside the package: ru.alexey.task2 
*/
import java.util.*;

/*
Not realized:
    public Iterator<E> iterator()
    public <T> T[] toArray(T[] a)
    public boolean containsAll(Collection<?> c)
    public boolean retainAll(Collection<?> c)
 */
public class ArrayListImpl<E> extends AbstractList<E> implements List<E> {
    private int size = 0;
    private int DEFAULT_CAPACITY = 10;
    private final Object[] emptyArray = {};
    private final Object[] defaultCapacityArray = {};

    private Object[] arrayData;

    public ArrayListImpl(int capacity) {
        if (capacity > 0) this.arrayData = new Object[capacity];
        else if (capacity == 0) this.arrayData = emptyArray;
        else throw new IllegalArgumentException(String.format("This capacity (%d) is not allowed ", capacity));
    }

    public ArrayListImpl() {
        this.arrayData = defaultCapacityArray;
    }

    public int getLength() {
        return arrayData.length;
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
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (arrayData[i] == null) return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (arrayData[i] == null) break;
                if (arrayData[i].equals(o)) return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(arrayData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    private void changeSize(int newSize) {
        if (size >= arrayData.length) {
            this.arrayData = Arrays.copyOf(arrayData, arrayData.length + (arrayData.length >> 1) + newSize);
        } else
            this.arrayData = Arrays.copyOf(this.arrayData, DEFAULT_CAPACITY + newSize);
    }

    private void add(E e, Object[] localArray, int index) {
        localArray[index] = e;
    }

    @Override
    public boolean add(E e) {
        if (this.size >= this.arrayData.length) {
            changeSize(++size);
            add(e, this.arrayData, size - 1);
        } else {
            size++;
            add(e, this.arrayData, size - 1);
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            remove(indexOf(o));
            return true;
        }
        for (int i = 0; i < arrayData.length; i++) {
            if (o.equals(arrayData[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Object[] temp = c.toArray();
        for (Object o : temp) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] temp = c.toArray();
        size += temp.length;
        changeSize(size);
        Object[] localArray = this.arrayData;
        System.arraycopy(temp, 0, localArray, size - temp.length, temp.length);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkValidIndex(index);
        Object[] temp = c.toArray();
        size += temp.length;
        changeSize(size);
        Object[] localArray = arrayData;
        System.arraycopy(localArray, index, localArray, index + temp.length, size);
        System.arraycopy(temp, 0, localArray, index, temp.length);
        return false;
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException(
                    String.format("Index (%d) are not valid, Size = %d", index, size));
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] temp = c.toArray();
        for (int i = 0; i < temp.length; i++) {
            if (contains(temp[i])) {
                remove(temp[i]);
                size--;
            }
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Arrays.sort((E[]) arrayData, 0, size, c);
    }

    @Override
    public void clear() {
        arrayData = emptyArray;
        size = 0;
    }

    private E getLocalArrayGeneric(int index) {
        return (E) arrayData[index];
    }

    @Override
    public E get(int index) {
        checkValidIndex(index);
        return getLocalArrayGeneric(index);
    }

    @Override
    public E set(int index, E element) {
        checkValidIndex(index);
        E oldObject = getLocalArrayGeneric(index);
        this.arrayData[index] = element;
        return oldObject;
    }

    @Override
    public void add(int index, E element) {
        Object[] temp = this.arrayData;
        changeSize(++size);
        System.arraycopy(temp, index, this.arrayData, index + 1, size - index);
        arrayData[index] = element;
    }

    @Override
    public E remove(int index) {
        checkValidIndex(index);
        E oldObject = getLocalArrayGeneric(index);
        Object[] temp = arrayData;
        System.arraycopy(temp, 0, arrayData, 0, size);
        System.arraycopy(temp, index + 1, arrayData, index, size - index);
        size--;
        return oldObject;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (arrayData[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (arrayData[i].equals(o)) return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (arrayData[i] == null) return i;
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (arrayData[i].equals(o)) return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public String toString() {
        Object[] arr = Arrays.copyOf(arrayData, size);
        return Arrays.toString(arr);
    }
}