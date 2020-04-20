package com.cyberark;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UnitTests {

    public static Bst<Integer> target;
    public static int expectedTreeSize;
    public static int initialValue1, initialValue2, initialValue3;
    public static int initialTreeSize;

    @BeforeEach
    public void setup() {
        target = new Bst<Integer>();
        initialValue1 = 42;
        initialValue2 = 33;
        initialValue3 = 68;
        target.add(initialValue1);
        target.add(initialValue2);
        target.add(initialValue3);

        initialTreeSize = 3;
    }

    @Test
    public void addShouldIncreaseTreeSize() {
        target.add(7);
        assertEquals(initialTreeSize+1, target.nodes().size(), "After ading a value the tree size must be increased by 1");
    }

    @Test
    public void addDuplicatesShouldKeepTreeSize() {
        target.add(initialValue1);
        assertEquals(initialTreeSize, target.nodes().size(), "After ading a duplicate value the tree size must remain unchanged");
    }

    @Test
    public void deleteLeafShouldDecreseTreeSize() {
        target.delete(initialValue3);
        assertEquals(initialTreeSize-1, target.nodes().size(), "After deleting a leaf the tree size must be decreased by 1");
    }

    @Test
    public void deleteNotLeafShouldKeepTreeSize() {
        target.delete(initialValue1);
        assertEquals(initialTreeSize, target.nodes().size(), "After trying to delete a non-leaf value, the tree size must remain unchanged");
    }

    @Test
    public void insertedValueMustBeFound() {
        assertTrue(target.find(initialValue2), "inserted value must be found");
    }

    @Test
    public void notInsertedValueMustNotBeFound() {
        assertFalse(target.find(7), "Not inserted value must not be found");
    }

    @Test
    public void isEmptyMustReturnTrueForEmptyTree() {
        Bst<Integer> empty = new Bst<Integer>();
        assertTrue(empty.isEmpty(), "isEmpty() must return true for an empty tree");
    }

    @Test
    public void isEmptyMustReturnFalseForNonEmptyTree() {
        assertFalse(target.isEmpty(), "isEmpty() must return false for a non-empty tree");
    }

}