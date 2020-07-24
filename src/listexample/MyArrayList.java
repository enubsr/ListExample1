/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listexample;

/**
 *
 * @author Enubs
 */
public class MyArrayList<E> implements List<E> {

    public static final int CAP = 10;
    private E[] data;
    private int size;

    public MyArrayList() {
        this(CAP);
    }

    public MyArrayList(int capacity) {
        data = (E[]) new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        if (size == data.length) // not enough capacity
        {
            throw new IllegalStateException("Array is full.");
        }

        for (int k = size - 1; k >= index; k--) { // start by shifting rightmost
            data[k + 1] = data[k];
            data[index] = element; // ready to place the new element
        }
        size++;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) // shift elements to fill hole
        {
            data[k] = data[k + 1];
        }
        data[size - 1] = null; // help garbage collection
        size--;
        return temp;
    }
}
