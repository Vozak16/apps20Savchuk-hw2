package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ImmutableLinkedListTest {

    public Object[] elements;
    public ImmutableLinkedList ImmutableLinkedList;
    public int index;
    public int indexError1;
    public int indexError2;

    @Before
    public void init(){
        elements = new Object[]{75.5, 30};
        ImmutableLinkedList = new ImmutableLinkedList(elements);
        index = 1;
        indexError1 = 10;
        indexError2 = -1;
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.add(51);
        ImmutableLinkedList arrayList2 = ImmutableLinkedList.add(index, 51);
        ImmutableLinkedList arrayList3 = ImmutableLinkedList.addAll(new Object[]{60.3, 75.2});
        ImmutableLinkedList arrayList4 = ImmutableLinkedList.addAll(index, new Object[]{60.3, 75.2});
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5, 30, 51});
        assertArrayEquals(arrayList2.toArray(), new Object[]{75.5, 51, 30});
        assertArrayEquals(arrayList3.toArray(), new Object[]{75.5, 30, 60.3, 75.2});
        assertArrayEquals(arrayList4.toArray(), new Object[]{75.5, 60.3, 75.2, 30});
    }

    @Test
    public void testAddFirst() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.addFirst(51);
        assertArrayEquals(arrayList1.toArray(), new Object[]{51, 75.5, 30});
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.addLast(51);
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5, 30, 51});
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddIndexError2() {
        ImmutableLinkedList arrayList2 = ImmutableLinkedList.add(indexError2, 51);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllIndexError2() {
        ImmutableLinkedList arrayList2 = ImmutableLinkedList.add(indexError2, new Object[]{60.3, 75.2});
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddIndexError1() {
        ImmutableLinkedList arrayList2 = ImmutableLinkedList.add(indexError1, 51);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testAddAllIndexError1() {
        ImmutableLinkedList arrayList2 = ImmutableLinkedList.add(indexError1, new Object[]{60.3, 75.2});
    }

    @Test
    public void testSet() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.set(index, 51);
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5, 51});

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetException1() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.set(indexError1, 51);

    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testSetException2() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.set(indexError2, 51);

    }

    @Test
    public void testGet() {
        Object elem = ImmutableLinkedList.get(index);
        assertEquals(elem, elements[index]);
    }

    @Test
    public void testGetLast() {
        Object elem = ImmutableLinkedList.getLast();
        assertEquals(elem, elements[elements.length - 1]);
    }

    @Test
    public void testGetFirst() {
        Object elem = ImmutableLinkedList.getFirst();
        assertEquals(elem, elements[0]);
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.removeFirst();
        assertArrayEquals(arrayList1.toArray(), new Object[]{30});
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.removeLast();
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5});
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.remove(index);
        assertArrayEquals(arrayList1.toArray(), new Object[]{75.5});
    }

    @Test
    public void testIndexOf() {
        Object index1 = ImmutableLinkedList.indexOf(elements[index]);
        assertEquals(index1, index);
        Object index2 = ImmutableLinkedList.indexOf(100);
        assertEquals(index2, -1);
    }

    @Test
    public void testSize() {
        Object size1 = ImmutableLinkedList.size();
        assertEquals(size1, elements.length);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList arrayList1 = ImmutableLinkedList.clear();
        assertArrayEquals(arrayList1.toArray(), new Object[]{});
    }

    @Test
    public void testIsEmpty() {
        assertFalse(ImmutableLinkedList.isEmpty());

        ImmutableLinkedList emptyArrayList = new ImmutableLinkedList();
        assertTrue(emptyArrayList.isEmpty());
    }

    @Test
    public void testToString() {

        assertEquals(ImmutableLinkedList.toString(), "[75.5, 30]");
    }

}
