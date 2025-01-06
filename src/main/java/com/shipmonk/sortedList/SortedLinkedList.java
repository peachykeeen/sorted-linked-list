package com.shipmonk.sortedList;

public class SortedLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private int size;
    private Class<?> type;

    private static class Node<T> {
        final T value;
        Node<T> next;

        Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Adds a value to the list in sorted order.
     *
     * @param value The value to add. Cannot be null.
     * @throws IllegalArgumentException if the value is null.
     */
    public void add(T value) {
        validateNonNull(value);
        validateType(value);

        Node<T> newNode = new Node<>(value, null);
        if (head == null || value.compareTo(head.value) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && value.compareTo(current.next.value) > 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }

    /**
     * Checks if the list contains the value.
     *
     * @param value The value to check. Cannot be null.
     * @return True if the list contains the value, false otherwise.
     * @throws IllegalArgumentException if the value is null.
     */
    public boolean contains(T value) {
        validateNonNull(value);

        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Removes a value from the list.
     *
     * @param value The value to remove. Cannot be null.
     * @return True if the value was removed, false if not found.
     * @throws IllegalArgumentException if the value is null.
     */
    public boolean remove(T value) {
        validateNonNull(value);

        if (head == null) return false;

        if (head.value.equals(value)) {
            head = head.next;
            size--;
            return true;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.value.equals(value)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }

        return false;
    }

    /**
     * Returns the value at the specified index.
     *
     * @param index The zero-based index of the value to retrieve.
     * @return The value at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size).
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.value;
    }

    /**
     * Finds the index of the specified value in the list.
     *
     * @param value The value to find. Cannot be null.
     * @return The zero-based index of the value, or -1 if not found.
     * @throws IllegalArgumentException if the value is null.
     */
    public int indexOf(T value) {
        validateNonNull(value);

        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Returns the size of the list.
     *
     * @return The number of elements in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    private void validateNonNull(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Cannot add null value to the list");
        }
    }

    private void validateType(T value) {
        if (type == null) {
            type = value.getClass();
        } else if (!type.equals(value.getClass())) {
            throw new IllegalArgumentException("All elements in the list must be of the same type: " + type.getName());
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return A string in the format [element1, element2, ...].
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}

