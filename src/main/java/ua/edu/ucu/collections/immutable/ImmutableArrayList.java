package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList {

    private final Object[] array;
    private final int array_length;

    public ImmutableArrayList() {
        this.array = new Object[0];
        this.array_length = 0;
    }

    public ImmutableArrayList(Object[] inputArray) {
        this.array = inputArray.clone();
        this.array_length = inputArray.length;
    }

    public void arrayListIndexOutOfBound(int index) {
        if(index < 0 || index >= array_length){
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    @Override
    public ImmutableArrayList add(Object e) {
        return add(array_length, e);
    }
    @Override
    public ImmutableArrayList add(int index, Object e) {
        if(index != array_length){arrayListIndexOutOfBound(index);}
        Object[] added_array = new Object[]{e};
        return addAll(index, added_array);

    }
    @Override
    public ImmutableArrayList addAll(Object[] c) {
        return addAll(array_length, c);

    }
    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if(index != array_length) {arrayListIndexOutOfBound(index);}
        Object[] new_array = new Object[array_length + c.length];
        System.arraycopy(array, 0, new_array, 0, index);
        System.arraycopy(c, 0, new_array, index, c.length);
        System.arraycopy(array, index, new_array, index + c.length,
                array_length - index);
        return new ImmutableArrayList(new_array);

    }
    @Override
    public Object get(int index) {
        arrayListIndexOutOfBound(index);
        return array[index];
    }

    @Override
    public ImmutableArrayList remove(int index) {
        arrayListIndexOutOfBound(index);
        Object[] new_array = new Object[array_length - 1];
        System.arraycopy(array, 0, new_array, 0, index);
        System.arraycopy(array, index + 1, new_array, index, array_length - index - 1);
        return new ImmutableArrayList(new_array);
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        arrayListIndexOutOfBound(index);
        Object[] new_array = array.clone();
        new_array[index] = e;
        return new ImmutableArrayList(new_array);
    }

    @Override
    public int indexOf(Object e) {
        int i = 0;
        while (i < array_length) {
            if (array[i] == e) {
                return i;
            } else {
                i++;
            }
        }
        return -1;
    }

    @Override
    public int size(){
        return array_length;
    }

    @Override
    public ImmutableArrayList clear() {
            return new ImmutableArrayList();
    }
    @Override
    public boolean isEmpty() {
        return array_length == 0;
    }

    @Override
    public Object[] toArray() {
        return array.clone();
    }
    
    @Override
    public String toString() {
        return Arrays.toString(array);
        }
}