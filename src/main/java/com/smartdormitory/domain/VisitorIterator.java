package com.smartdormitory.domain;

import java.util.Iterator;
import java.util.List;

public class VisitorIterator implements Iterator<Visitor> {

    private final List<Visitor> visitors;
    private int position = 0;

    public VisitorIterator(List<Visitor> visitors) {
        this.visitors = visitors;
    }

    @Override
    public boolean hasNext() {
        return position < visitors.size();
    }

    @Override
    public Visitor next() {
        return visitors.get(position++);
    }
}