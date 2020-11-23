package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class QueueTest {

    public Object[] elements;
    public ImmutableLinkedList immutableLinkedList;
    public Queue queue;
    public Queue queueEmpty;


    @Before
    public void init(){
        elements = new Object[]{75.5, 30};
        immutableLinkedList = new ImmutableLinkedList(elements);
        queue = new Queue(immutableLinkedList);
        queueEmpty = new Queue();
    }
    
    @Test
    public void testPeek() {
        Object elem = queue.peek();
        assertEquals(elem, elements[elements.length - 1]);
    }

    @Test
    public void testDequeue() {
        Object elem = queue.dequeue();
        assertEquals(elem, 30);
        assertArrayEquals(new Object[]{75.5}, queue.queue.toArray());
    }

    @Test
    public void testEnqueue() {
        queue.enqueue(50);
        assertArrayEquals(new Object[]{50, 75.5, 30}, queue.queue.toArray());
    }
    
}
