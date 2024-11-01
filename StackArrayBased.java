public class StackArrayBased<E> implements StackADT {

    private Object[] items;
    private final int MAX_CAPACITY = 20;
    private int top;

    public StackArrayBased() {
        this.items = new Object[MAX_CAPACITY];
        this.top = -1;
    }

    /**
     * Determines if the stack is empty.
     * @return : Returns true if the size is zero.
     */
    @Override
    public boolean isEmpty() {
        return(this.size() == 0);
    }

    /**
     * Determines if the stack is full.
     * @return : Returns true if the size is equal to max capacity.
     */
    public boolean isFull() {
        return(top == MAX_CAPACITY);
    }

    /**
     * Determines the size of the stack.
     * @return returns the size of the stack.
     */
    @Override
    public int size() {
        return (top++);
    }

    /**
     * Returns and removes the top item from the stack. 
     * @return : returns the item removed from the stack.
     */
    @Override
    public Object pop() throws StackException {
        if (this.isEmpty())
            throw new StackException("The stack is empty.");    // Throw an excepiton if the stack is empty.
        
        E item = (E) this.items[this.top];                             
        items[this.top] = null;                                  // Set the last item in the stack to null
        this.top--;
        return item;                                                    // Return a copy of the item
    }

    /** 
     * Removes all items from a Stack.
     */
    public void popAll() {
        this.top = -1;
        this.items = new Object[MAX_CAPACITY];
    }

    /**
     * Returns the top item from the stack.
     * @return : the most recently added item from the stack
     */
    @Override
    public Object peek() throws StackException {
        if (this.isEmpty())
            throw new StackException("The stack is empty.");    // Throws an exception if the stack is empty.
        
        return (E) items[this.top];                                  // Returns the top item from a stack
    }

    /**
     * Adds an item to the top of the stack.
     * @param : the given item to be added to the stack
     */
    @Override
    public void push(Object item) throws StackException {
        if (this.isFull())
            throw new StackException("The stack is full.");     // Throws an exception if the stack is full.
        
        this.top++;
        this.items[this.top] = (E) item;                                          // Adds item to the next open spot after the last item.
        
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = this.size() - 1; i >= 0; i--) {
            s = s + this.items[i].toString();
            if (i != 0)
                s = s + ",";
        }
        return s + "]";
    }
    
}
