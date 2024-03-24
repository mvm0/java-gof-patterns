package org.example.BehavioralPatterns.Iterator;

import java.util.Arrays;

interface Iterator {
    boolean hasNext();

    Object next();
}

interface Container {
    Iterator iterator();
}

class ArrayClass implements Container {
    private final String[] arr;

    ArrayClass(String... names) {
        int count = (int) Arrays.stream(names).count();
        arr = new String[count];
        System.arraycopy(names, 0, arr, 0, count);
    }

    @Override
    public Iterator iterator() {
        return new ArrayClassIterator(arr);
    }
}

class ArrayClassIterator implements Iterator {
    private int index;
    private String[] arr;

    ArrayClassIterator(String[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        return index < arr.length;
    }

    @Override
    public Object next() {
        if (hasNext())
            return arr[index++];
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayClass array = new ArrayClass("1", "2", "3", "4", "5");
        Iterator iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
