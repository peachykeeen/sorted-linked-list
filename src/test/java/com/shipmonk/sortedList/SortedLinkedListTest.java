package com.shipmonk.sortedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SortedLinkedListTest {

    static Stream<Object[]> addMethodTestData() {
        return Stream.of(
                new Object[]{new Integer[]{5}, "[5]"},
                new Object[]{new Integer[]{10, 5}, "[5, 10]"},
                new Object[]{new Integer[]{5, 10}, "[5, 10]"},
                new Object[]{new Integer[]{5, 10, 15}, "[5, 10, 15]"},
                new Object[]{new String[]{"banana"}, "[banana]"},
                new Object[]{new String[]{"apple", "banana"}, "[apple, banana]"},
                new Object[]{new String[]{"banana", "apple"}, "[apple, banana]"},
                new Object[]{new String[]{"banana", "apple", "cherry"}, "[apple, banana, cherry]"}
        );
    }

    @ParameterizedTest(name = "Add method: input={0}, expected={1}")
    @MethodSource("addMethodTestData")
    <T extends Comparable<T>> void testAddMethod(T[] input, String expectedOutput) {
        SortedLinkedList<T> list = new SortedLinkedList<>();
        for (T value : input) {
            list.add(value);
        }
        assertEquals(expectedOutput, list.toString());
    }

    @Test
    void testAddMethodWithNullValue() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    static Stream<Object[]> containsMethodTestData() {
        return Stream.of(
                new Object[]{new int[]{5, 10, 15}, 10, true},
                new Object[]{new int[]{5, 10, 15}, 20, false},
                new Object[]{new int[]{}, 5, false}
        );
    }

    @ParameterizedTest(name = "Contains method: input={0}, searchValue={1}, expected={2}")
    @MethodSource("containsMethodTestData")
    void testContainsMethod(int[] input, int searchValue, boolean expectedResult) {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        for (int value : input) {
            list.add(value);
        }
        assertEquals(expectedResult, list.contains(searchValue));
    }

    @Test
    void testContainsMethodWithNullValue() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.contains(null));
    }

    static Stream<Object[]> removeMethodTestData() {
        return Stream.of(
                new Object[]{new int[]{5, 10, 15}, 10, "[5, 15]"},
                new Object[]{new int[]{5, 10, 15}, 5, "[10, 15]"},
                new Object[]{new int[]{5, 10, 15}, 15, "[5, 10]"},
                new Object[]{new int[]{5, 10, 15}, 20, "[5, 10, 15]"}
        );
    }

    @ParameterizedTest(name = "Remove method: input={0}, remove={1}, expected={2}")
    @MethodSource("removeMethodTestData")
    void testRemoveMethod(int[] input, int valueToRemove, String expectedOutput) {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        for (int value : input) {
            list.add(value);
        }
        list.remove(valueToRemove);
        assertEquals(expectedOutput, list.toString());
    }

    @Test
    void testRemoveMethodWithNullValue() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.remove(null));
    }

    static Stream<Object[]> getMethodTestData() {
        return Stream.of(
                new Object[]{new int[]{5, 10, 15}, 0, 5},
                new Object[]{new int[]{5, 10, 15}, 1, 10},
                new Object[]{new int[]{5, 10, 15}, 2, 15}
        );
    }

    @ParameterizedTest(name = "Get method: input={0}, index={1}, expected={2}")
    @MethodSource("getMethodTestData")
    void testGetMethod(int[] input, int index, int expectedValue) {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        for (int value : input) {
            list.add(value);
        }
        assertEquals(expectedValue, list.get(index));
    }

    @Test
    void testGetMethodWithInvalidIndex() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        list.add(5);
        list.add(10);
        list.add(15);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
    }

    static Stream<Object[]> indexOfMethodTestData() {
        return Stream.of(
                new Object[]{new int[]{5, 10, 15}, 10, 1},
                new Object[]{new int[]{5, 10, 15}, 5, 0},
                new Object[]{new int[]{5, 10, 15}, 15, 2},
                new Object[]{new int[]{5, 10, 15}, 20, -1}
        );
    }

    @ParameterizedTest(name = "IndexOf method: input={0}, value={1}, expected={2}")
    @MethodSource("indexOfMethodTestData")
    void testIndexOfMethod(int[] input, int value, int expectedIndex) {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        for (int v : input) {
            list.add(v);
        }
        assertEquals(expectedIndex, list.indexOf(value));
    }

    @Test
    void testIndexOfMethodWithNullValue() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertThrows(IllegalArgumentException.class, () -> list.indexOf(null));
    }

    @Test
    void testSizeMethod() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertEquals(0, list.size());
        list.add(5);
        list.add(10);
        assertEquals(2, list.size());
    }

    @Test
    void testIsEmptyMethod() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertTrue(list.isEmpty());
        list.add(5);
        assertFalse(list.isEmpty());
    }

    @Test
    void testToStringMethod() {
        SortedLinkedList<Integer> list = new SortedLinkedList<>();
        assertEquals("[]", list.toString());
        list.add(10);
        list.add(5);
        list.add(20);
        assertEquals("[5, 10, 20]", list.toString());
    }
}
