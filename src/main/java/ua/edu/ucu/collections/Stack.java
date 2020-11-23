package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {

    public ImmutableLinkedList stack;

    public Stack(){
        stack = new ImmutableLinkedList();
    }

    public Stack(ImmutableLinkedList linkedList){
        stack = linkedList;
    }

    public Object peek(){
        return stack.getFirst();
    }

    public Object pop(){
        Object first_elem = stack.getFirst();
        stack = stack.removeFirst();
        return first_elem;
    }

    public void push(Object e){
        stack = stack.addFirst(e);
    }
    
}
