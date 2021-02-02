package com.epam.rd.autocode.iterator;

import java.util.Iterator;

class Iterators {
    private static final int TWO_TIMES_ITERATOR = 2;
    private static final int THREE_TIMES_ITERATOR = 3;
    private static final int FIVE_TIMES_ITERATOR = 5;

    public static Iterator<Integer> intArrayTwoTimesIterator(int[] array){
        return new IntArrayManyTimesIterator(array, TWO_TIMES_ITERATOR);
    }

    public static Iterator<Integer> intArrayThreeTimesIterator(int[] array) {
        return new IntArrayManyTimesIterator(array, THREE_TIMES_ITERATOR);
    }

    public static Iterator<Integer> intArrayFiveTimesIterator(int[] array) {
        return new IntArrayManyTimesIterator(array, FIVE_TIMES_ITERATOR);
    }

    public static Iterable<String> table(String[] columns, int[] rows){
        return new Table(columns, rows);
    }



}
