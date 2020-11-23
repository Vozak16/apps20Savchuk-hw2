package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {

    public Object[] elements;
    public ImmutableArrayList immutableArrayList;
    public int index;
    public int indexError1;
    public int indexError2;

    @Before
    public void init(){
        elements = new Object[]{75.5, 30};
        immutableArrayList = new ImmutableArrayList(elements);
        index = 1;
        indexError1 = 10;
        indexError2 = -1;
    }
    
    @Test
    public void testAdd() {
        ImmutableArrayList arrayList1 = immutableArrayList.add(51);
        ImmutableArrayList arrayList2 = immutableArrayList.add(index, 51);
        ImmutableArrayList arrayList3 = immutableArrayList.addAll(new Object[]{60.3, 75.2});
        ImmutableArrayList arrayList4 = immutableArrayList.addAll(index, new Object[]{60.3, 75.2});
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5, 30, 51});
        assertArrayEquals(arrayList2.toArray(), new Object[]{75.5, 51, 30});
        assertArrayEquals(arrayList3.toArray(), new Object[]{75.5, 30, 60.3, 75.2});
        assertArrayEquals(arrayList4.toArray(), new Object[]{75.5, 60.3, 75.2, 30});
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddIndexError2() {
        ImmutableArrayList arrayList2 = immutableArrayList.add(indexError2, 51);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllIndexError2() {
        ImmutableArrayList arrayList2 = immutableArrayList.add(indexError2, new Object[]{60.3, 75.2});
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddIndexError1() {
        ImmutableArrayList arrayList2 = immutableArrayList.add(indexError1, 51);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllIndexError1() {
        ImmutableArrayList arrayList2 = immutableArrayList.add(indexError1, new Object[]{60.3, 75.2});
    }

    @Test
    public void testSet() {
        ImmutableArrayList arrayList1 = immutableArrayList.set(index, 51);
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5, 51});

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetException1() {
        ImmutableArrayList arrayList1 = immutableArrayList.set(indexError1, 51);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetException2() {
        ImmutableArrayList arrayList1 = immutableArrayList.set(indexError2, 51);

    }

    @Test
    public void testGet() {
        Object elem = immutableArrayList.get(index);
        assertEquals(elem, elements[index]);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList arrayList1 = immutableArrayList.remove(index);
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5});
    }

    @Test
    public void testIndexOf() {
        Object index1 = immutableArrayList.indexOf(elements[index]);
        assertEquals(index1, index);
        Object index2 = immutableArrayList.indexOf(100);
        assertEquals(index2, -1);
    }

    @Test
    public void testSize() {
        Object size1 = immutableArrayList.size();
        assertEquals(size1, elements.length);
    }

    @Test
    public void testClear() {
        ImmutableArrayList arrayList1 = immutableArrayList.clear();
        assertArrayEquals(arrayList1.toArray(), new Object[]{});
    }

    @Test
    public void testIsEmpty() {
        assertFalse(immutableArrayList.isEmpty());

        ImmutableArrayList emptyArrayList = new ImmutableArrayList();
        assertTrue(emptyArrayList.isEmpty());
    }

    @Test
    public void testToString() {

        assertEquals(immutableArrayList.toString(), "[75.5, 30]");
    }

}
