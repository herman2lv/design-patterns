package com.epam.rd.autocode.decorator;

import java.util.Iterator;
import java.util.List;

public interface ListDecorator<T> extends List<T> {
    @Override
    int size();
    @Override
    Iterator<T> iterator();
    @Override
    T get(int index);
}
