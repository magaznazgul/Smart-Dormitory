package com.smartdormitory.service;

import com.smartdormitory.domain.Visitor;
import com.smartdormitory.domain.VisitorCollection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IteratorTest {

    @Test
    void iteratorShouldReturnAllVisitors() {
        VisitorCollection collection = new VisitorCollection();

        collection.addVisitor(new Visitor(
                "Ерлан", "Айдана", "205"
        ));

        collection.addVisitor(new Visitor(
                "Али", "Данияр", "310"
        ));

        int count = 0;

        for (Visitor visitor : collection) {
            assertNotNull(visitor);
            count++;
        }

        assertEquals(2, count);
    }

    @Test
    void iteratorShouldBeEmptyWhenCollectionIsEmpty() {
        VisitorCollection collection = new VisitorCollection();

        assertFalse(collection.iterator().hasNext());
    }
}