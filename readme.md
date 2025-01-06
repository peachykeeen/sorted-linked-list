
# SortedLinkedList Library

A simple, generic sorted linked list implementation in Java that maintains elements in sorted order and supports various list operations.

## Features
- **Type-Safe**: Works with any type implementing Comparable (including strings, integers etc).
- **Automatic ordering**: Elements are always added in natural order based on the compareTo method provided by the Comparable<T> interface
- **Core Methods**: Add, remove, get, and more.

## TODO improvements
- allow custom comparator

## Usage Example
```java
import com.shipmonk.sortedList.SortedLinkedList;

SortedLinkedList<Integer> list = new SortedLinkedList<>();
list.add(10);
list.add(5);
list.add(15);
System.out.println(list); // [5, 10, 15]
list.remove(10);
System.out.println(list); // [5, 15]
```

## Core Methods and Complexities
| Method     | Description                       | Time Complexity |
| ---------- | --------------------------------- | --------------- |
| `add`      | Inserts an element in sorted order| O(n)            |
| `remove`   | Removes the first occurrence      | O(n)            |
| `contains` | Checks if an element exists       | O(n)            |
| `size`     | Returns the number of elements    | O(1)            |

## Public Methods

### `add(T value)`
Adds a value to the list in sorted order.

- **Parameters**:
    - `value` (T): The value to add. Cannot be `null`.
- **Exceptions**:
    - `IllegalArgumentException`: Thrown if the value is `null`.

### `remove(T value)`
Removes the specified value from the list.

- **Parameters**:
    - `value` (T): The value to remove. Cannot be `null`.
- **Returns**:
    - `true` if the value was removed.
    - `false` if the value was not found.
- **Exceptions**:
    - `IllegalArgumentException`: Thrown if the value is `null`.

### `contains(T value)`
Checks if the list contains the specified value.

- **Parameters**:
    - `value` (T): The value to check. Cannot be `null`.
- **Returns**:
    - `true` if the list contains the value.
    - `false` otherwise.
- **Exceptions**:
    - `IllegalArgumentException`: Thrown if the value is `null`.

### `get(int index)`
Returns the value at the specified index.

- **Parameters**:
    - `index` (int): The zero-based index of the value to retrieve.
- **Returns**:
    - The value at the specified index.
- **Exceptions**:
    - `IndexOutOfBoundsException`: Thrown if the index is out of range.

### `indexOf(T value)`
Finds the index of the specified value in the list.

- **Parameters**:
    - `value` (T): The value to find. Cannot be `null`.
- **Returns**:
    - The zero-based index of the value, or `-1` if not found.
- **Exceptions**:
    - `IllegalArgumentException`: Thrown if the value is `null`.

## License
MIT License
