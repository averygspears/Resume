public class StackReferenceBased<E> implements StackADT<E> {
    private Node<E> top;

    StackReferenceBased() {
        this.top = null;
    }

    /**
     * Checks to see if the stack is empty. 
     * @return : Returns true if the stack is empty. 
     */
    @Override
    public boolean isEmpty() {
        return (this.top == null);
    }

    /**
     * Finds the size of a stack. 
     * @return : Returns and integer value representing the size of the stack. 
     */
    @Override
    public int size() {
        if (this.isEmpty()) {                           // If the stack is empty, 
            return 0;                                   // Return the stack size as 0. 
        }

        int size = 1;                                   // Size starts at 1
        Node<E> currentNode = this.top;                 // Node to loop through the list
        while(currentNode.getNext() != null) {          
            size++;                                     // Increment the size for every node. 
        }
        return size;                                    // Return the size. 
    }

    /**
     * Removes the top item off of the stack and returns it. 
     * @return : The popped item, or the previous top of the list. 
     */
    @Override
    public E pop() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("The stack is empty.");    // Throw an exception if the list is empty. 
        }
        E item = this.top.getItem();                                    // Duplicate the item to return. 
        this.top = this.top.getNext();                                  // Set new top to the next item in the stack.
        return item;                                                    // Return the duplicate item. 
    }

    /**
     * Retreives the top item off of the stack. 
     * @return : The top item in the stack. 
     */
    @Override
    public E peek() throws StackException {
        if (this.isEmpty()) {
            throw new StackException("The stack is empty.");    // Throws exception if the stack is empty. 
        }
        return this.top.getItem();                                      // Returns the item version of the top node. 
    }

    /**
     * Inserts a new item to the top of the stack. 
     * @param : The item to be pushed. 
     */
    @Override
    public void push(E item) {
        Node<E> newTop = new Node<E>(item);             // Creates a new node with the given item.
        newTop.setNext(this.top);                       // Sets the reference in the node to the old top.
        this.top = newTop;                              // Sets the new item to the new top. 
    }

    /**
     * Reverse the stack 
     * @return : The newly reversed stack
     */
    public StackReferenceBased<E> reverseStack() {
        Node<E> currentNode = this.top;                                         // Creates a node to loop through the stack
        StackReferenceBased<E> newStack = new StackReferenceBased<E>();         // The new stack
        while (currentNode != null) {   
            newStack.push(currentNode.getItem());                               // Adds the top item of the original list to the 
        }                                                                       // bottom of the new stack. 
        this.top = newStack.top;                                                // Sets the original top of the stack to the new one,
                                                                                // Serving as a pointer to the new stack.
        return newStack;                                                        // Return the stack.
    }

    /**
     * Converts the stack into a readable output
     * @return : Returns the string format of the stack.
     */
    @Override
    public String toString() {
        String s = "[";
        Node<E> current = this.top; // traversal node
        while (current != null) { // end of stack
            E item = current.getItem();
            s = s + item.toString();
            
            // move to the next node
            current = current.getNext(); 
            
            if (current != null) // don't add a ","
               s = s + ", ";
            
            
        }
        return s + "]";
    }
    
}
