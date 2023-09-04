package ss10_list;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        size++;
        if (size >= elements.length) {
            ensureCapacity(elements.length);
        }
        elements[index] = element;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException
                    ("index " + index + "out of bounds");
        }
        E e = (E) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> newElements = new MyList<>(size);
        newElements.size = this.size;
        newElements.elements = Arrays.copyOf(elements, this.elements.length);
        return newElements;
    }

    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == o) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        add(size, e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        elements = Arrays.copyOf(elements, 2 * minCapacity);
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException
                    ("index " + i + "out of bounds");
        }
        return (E) elements[i];
    }

    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
    }
}

class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(4);
        list.add(0, 3);
        list.add(1, 7);
        list.add(2, 11);
        list.add(3, 13);

        if (list.add(17)) {
            System.out.println("17 added in array.");
        }

        MyList<Integer> list1 = list.clone();
        System.out.println("list1[0] is " + list1.get(0));
        System.out.println("list1[1] is " + list1.get(1));
        System.out.println("list1[2] is " + list1.get(2));
        System.out.println("list1[3] is " + list1.get(3));
    }
}