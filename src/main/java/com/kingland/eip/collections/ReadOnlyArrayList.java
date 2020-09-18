/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.collections;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * This class could only be readed
 *
 * @param <E>
 */
public class ReadOnlyArrayList<E> extends ArrayList<E> implements Iterable<E> {
    private ArrayList<E> testStringList;
    private int currentSize;
    private final static String EXCEPTION_MESSAGE = "This is read only ArrayList";

    public ReadOnlyArrayList(ArrayList<E> testStringList) {
        super();
        this.testStringList = testStringList;
        this.currentSize = testStringList.size();
    }

    public ArrayList<E> getTestStringList() {
        return testStringList;
    }

    /**
     * testString list setter
     *
     * @param testStringList
     */
    public void setTestStringList(ArrayList<E> testStringList) {
        this.testStringList = testStringList;
    }

    /**
     * could not set
     *
     * @param var1
     * @param var2
     * @return
     */
    public E set(int var1, E var2) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not add
     *
     * @param var1
     * @param var2
     * @return
     */
    public void add(int var1, E var2) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not add
     *
     * @param var1
     * @return
     */
    public boolean add(E var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not remove
     *
     * @param var1
     * @return
     */
    public E remove(int var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not addAll
     *
     * @param var1
     * @param var2
     * @return
     */
    public boolean addAll(int var1, Collection<? extends E> var2) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not addAll
     *
     * @param var1
     * @return
     */
    public boolean addAll(Collection<? extends E> var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not replaceAll
     *
     * @param var1
     */
    public void replaceAll(UnaryOperator<E> var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not sort
     *
     * @param var1
     */
    public void sort(Comparator<? super E> var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * Rewrite iterator
     *
     * @return
     */
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && testStringList.get(currentIndex) != null;
            }

            @Override
            public E next() {
                return testStringList.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
            }
        };
    }
}