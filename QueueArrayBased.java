import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;

public class QueueArrayBased<E> implements QueueADT {

    private final int MAX_CAPACITY = 50;
    private Object[] queueArray;
    private int size;

    public QueueArrayBased() {
        this.size = 0;
        this.queueArray = new Object[MAX_CAPACITY];
    }

    /**
     * Checks the queue to see if it is empty. 
     * @return : Returns true if the size is empty. 
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    /**
     * Removes all items from the queue.
     */
    @Override
    public void dequeueAll() {
        this.size = 0;                                              // Sets the size back to zero
        this.queueArray = new Object[MAX_CAPACITY];                 // Replaces the old queue with a new, empty queue.
    }

    /**
     * Retrieves the first item from the queue. 
     * @return : Returns the data from the first item in the queue.
     */
    @Override
    public Object peek() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("The queue is empty.");
        }
        return this.queueArray[0];
    }

    /**
     * Removes and returns the first item from the queue.
     * @return : returns the previous first item from the queue.
     */
    @Override
    public Object dequeue() throws QueueException {
        if (this.isEmpty()) {
            throw new QueueException("The queue is empty.");    // If the queue is empty, throw an exception. 
        }

        E item = (E) this.queueArray[0];                                // Get the first item of the queue to return.
        this.queueArray[0] = null;                                      // Set the first item to null.

        for (int i = 1; i < size; i++) {                                // Shift all of the elements to the left
            this.queueArray[i - 1] = queueArray[i];                     
        }
        this.size--;                                                    // Decrease the size

        return item;                                                    // Return the previous first item.
    }

    /**
     * Inserts an item at the end of the queue.
     * @param : The item to be inserted.
     */
    @Override
    public void enqueue(Object item) {
        if (this.size == MAX_CAPACITY) {
            throw new QueueException("The queue is full.");     // If the queue is full, throw an exception.
        }

        this.queueArray[size] = item;                                   // Add new item at the end of the array.
        size++;                                                         // Increment the size. 
    }

    /**
     * Converts the queue into a readable format.
     * @return : A string format of the queue.
     */
    @Override
    public String toString() {
        String s = "[";
        for (int i =0; i < this.size; i++) {
            s = s + this.queueArray[i].toString();
            if (i != size-1) 
                s = s + ", ";
        }
        return s + "]";
    }

}
