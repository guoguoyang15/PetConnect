package com.example.myapplication.BTree;

import java.util.ArrayList;
import java.util.Collection;

/**
 * An ArrayList which has a limited holding capacity.
 * @param <T> the generic type this LimitedArray uses.
 */
public class LimitedArrayList<T> extends ArrayList<T> {
    private final int capacity;

    /**
     * @return the capacity of this limited array.
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Constructor which sets the capacity field.
     */
    public LimitedArrayList(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    @Override
    public boolean add(T t) {
        if (this.size() + 1 > capacity)
            throw new IndexOutOfBoundsException();
        return super.add(t);
    }

    @Override
    public void add(int index, T element) {
        //Ensure that the index is within the range of the LimitedArrayList
        //Ensure that the if we added another element, we wouldn't exceed the capacity
        if (index >= this.capacity || this.size() + 1 >  capacity)
            throw new IndexOutOfBoundsException();
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        if (this.size() + c.size() > capacity)
            throw new IndexOutOfBoundsException();
        return super.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        //Ensure that when we add the elements in c, they will not exceed the capacity
        //   for example c=[2,3], index = 2, this = [], capacity = 3
        //   however adding elements at index 2 would occupy indexes 2 and 3 which exceeds capacity

        // Ensure that the sizes of the two collections do not together exceed capacity
        //   for example c=[2,3], index = 0, this = [0, 1], capacity = 3
        //   This would attempt to create [2, 3, 0, 1]
        //   however adding these elements would exceed capacity

        // The parent class also checks for if the index is occupied or adjacent
        // For example it doesn't make sense to add data to index 1 if there is nothing
        // In index 0, but it would make sense to add data to index 1 if index 0 was occupied
        if (c.size()+index > capacity || this.size() + c.size() > capacity)
            throw new IndexOutOfBoundsException();
        return super.addAll(index, c);
    }

    /**
     * Returns a slice of the current array.
     *
     * @param i inclusive index to start the slice from.
     * @param j exclusive index to end the slice.
     * @return new LimitedArray containing the elements from the requested start and end index.
     */
    public LimitedArrayList<T> get(int i, int j) {
        // Ensure i <= j and both are positive.
        if (i > j || i < 0) // Notice j must be greater than 0 given these conditions.
            throw new IllegalArgumentException("i cannot be greater than j");

        // Ensure both are within the bounds.
        if (i > this.size() || j > this.size())
            throw new IndexOutOfBoundsException();

        // Add slice contents.
        LimitedArrayList<T> slice = new LimitedArrayList<>(capacity);
        while (i < j) {
            slice.add(this.get(i));
            i++;
        }

        return slice;
    }
}


