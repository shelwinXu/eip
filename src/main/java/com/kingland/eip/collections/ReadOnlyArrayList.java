/**
 * Copyright 2020 Kingland Systems Corporation. All Rights Reserved.
 */
package com.kingland.eip.collections;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * This class could only be readed
 * @param <E>
 */
public class ReadOnlyArrayList<E> extends ArrayList<E>  {
    private List<? extends E> list;
    private ArrayList<E> testStringList;
    private final static String EXCEPTION_MESSAGE = "This is read only ArrayList";

    public ReadOnlyArrayList(ArrayList<E> testStringList) {
        super();
        this.testStringList = testStringList;
    }

    public ReadOnlyArrayList(List<? extends E> var1) {
        super(var1);
        this.list = var1;
    }

    public ArrayList<E> getTestStringList() {
        return testStringList;
    }

    /**
     * testString list setter
     * @param testStringList
     */
    public void setTestStringList(ArrayList<E> testStringList) {
        this.testStringList = testStringList;
    }

    /**
     * could not set
     * @param var1
     * @param var2
     * @return
     */
    public E set(int var1, E var2) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }
    /**
     * could not add
     * @param var1
     * @param var2
     * @return
     */
    public void add(int var1, E var2) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not remove
     * @param var1
     * @return
     */
    public E remove(int var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not addAll
     * @param var1
     * @param var2
     * @return
     */
    public boolean addAll(int var1, Collection<? extends E> var2) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not replaceAll
     * @param var1
     */
    public void replaceAll(UnaryOperator<E> var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * could not sort
     * @param var1
     */
    public void sort(Comparator<? super E> var1) {
        throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
    }

    /**
     * overwite ListIterator method
     * @return
     */
    public ListIterator<E> listIterator() {
        return this.listIterator(0);
    }

    /**
     * overwite ListIterator method
     * could not set、add、remove
     * @param var1
     * @return
     */
    public ListIterator<E> listIterator(final int var1) {
        return new ListIterator<E>() {
            private final ListIterator<? extends E> i;

            {
                this.i = ReadOnlyArrayList.this.list.listIterator(var1);
            }

            public boolean hasNext() {
                return this.i.hasNext();
            }

            public E next() {
                return this.i.next();
            }

            public boolean hasPrevious() {
                return this.i.hasPrevious();
            }

            public E previous() {
                return this.i.previous();
            }

            public int nextIndex() {
                return this.i.nextIndex();
            }

            public int previousIndex() {
                return this.i.previousIndex();
            }

            public void remove() {
                throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
            }

            public void set(E var1x) {
                throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
            }

            public void add(E var1x) {
                throw new UnsupportedOperationException(EXCEPTION_MESSAGE);
            }

            public void forEachRemaining(Consumer<? super E> var1x) {
                this.i.forEachRemaining(var1x);
            }
        };
    }
}