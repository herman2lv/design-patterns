package com.epam.rd.autocode.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Table implements Iterable<String> {
    private final String[] columns;
    private final int[] rows;

    public Table(final String[] columns, final int[] rows) {
        this.columns = columns;
        this.rows = rows;
    }

    @Override
    public Iterator<String> iterator() {
        return new TableIterator();
    }

    private class TableIterator implements Iterator<String> {
        private int columnCursor;
        private int rowCursor;

        @Override
        public boolean hasNext() {
            return columnCursor < columns.length;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            String element = columns[columnCursor] + rows[rowCursor++];
            if (rowCursor == rows.length) {
                rowCursor = 0;
                columnCursor++;
            }
            return element;
        }
    }
}
