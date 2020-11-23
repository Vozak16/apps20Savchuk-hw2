package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {

    public ImmutableLinkedList queue;

    public Queue(ImmutableLinkedList linkedList){
        queue = linkedList;
    }

    public Queue(){
        queue = new ImmutableLinkedList();
    }

    public Object peek(){
        return queue.getLast();
    }

    public Object dequeue(){
        Object first_elem = queue.getLast();
        queue = queue.removeLast();
        return first_elem;
    }

    public void enqueue(Object e){
        queue = queue.addFirst(e);
    }
    
}
