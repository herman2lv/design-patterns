package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IntArrayManyTimesIterator implements Iterator<Integer> {
    private static final String EXCEPTION_MESSAGE = "Expected greater than 0";
    private int cursor;
    private final int[] array;
    private final int timesToReturnEachElement;
    private int onElementCounter;

    public IntArrayManyTimesIterator(final int[] array, final int timesToReturnEachElement) {
        validateTimesToReturnParam(timesToReturnEachElement);
        this.timesToReturnEachElement = timesToReturnEachElement;
        this.array = array;
    }

    @Override
    public boolean hasNext() {
        return cursor < array.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int elementToReturn = array[cursor];
        if (++onElementCounter == timesToReturnEachElement) {
            cursor++;
            onElementCounter = 0;
        }
        return elementToReturn;
    }

    private void validateTimesToReturnParam(final int timesToReturnEachElement) {
        if (timesToReturnEachElement <= 0) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE);
        }
    }
}
