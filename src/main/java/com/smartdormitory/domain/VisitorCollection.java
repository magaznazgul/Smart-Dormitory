package com.smartdormitory.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorCollection implements Iterable<Visitor> {

    private final List<Visitor> visitors = new ArrayList<>();

    public void addVisitor(Visitor visitor) {
        visitors.add(visitor);
    }

    public int getSize() {
        return visitors.size();
    }

    @Override
    public Iterator<Visitor> iterator() {
        return new VisitorIterator(visitors);
    }
}