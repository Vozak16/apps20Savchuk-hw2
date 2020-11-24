package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class StackTest {

    public Object[] elements;
    public ImmutableLinkedList immutableLinkedList;
    public Stack stack;
    public Stack stackEmpty;


    @Before
    public void init() {
        elements = new Object[]{75.5, 30};
        immutableLinkedList = new ImmutableLinkedList(elements);
        stack = new Stack(immutableLinkedList);
        stackEmpty = new Stack();
    }

    @Test
    public void testPeek() {
        Object elem = stack.peek();
        assertEquals(elem, 75.5);
    }

    @Test
    public void testPop() {
        Object elem = stack.pop();
        assertEquals(elem, 75.5);
    }

    @Test
    public void testPush() {
        stack.push(50);
        assertEquals(stack.peek(), 50);
    }

}
