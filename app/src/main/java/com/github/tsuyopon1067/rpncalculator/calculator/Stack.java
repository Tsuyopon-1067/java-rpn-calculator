package com.github.tsuyopon1067.rpncalculator.calculator;

import java.util.EmptyStackException;

public class Stack<T> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] array;

    public Stack() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    private void expandCapacity() {
        if (size < array.length) {
            return;
        }
        int newCapacity = array.length * 2;
        Object[] newArray = new Object[newCapacity];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T item) {
        expandCapacity();
        array[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T res = (T)array[--size];
        array[size] = null;
        return res;
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (T)array[size-1];
    }

    public void clear() {
        array = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}