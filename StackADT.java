public interface StackADT<E> {

    // Determines if a Stack is empty
    public boolean isEmpty();

    // Determines the size of a Stack
    public int size();

    // Deletes the top, or most recently added item of a stack
    public E pop() throws StackException;

    // Returns the top, or most recently added item of a stack
    public E peek() throws StackException;

    // Adds an item of type E to the stack. 
    public void push(E item);
    
}