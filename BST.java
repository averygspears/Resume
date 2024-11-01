/* 
 * This class creates a Binary Search Tree object with several operations 
 * including: adding & removing items, checking if the tree is empty, finding 
 * the maximum and minimum value, and printing out the tree as well as 
 * different traversals.
 * 
 * 10/31/2024
 */

public class BST<T extends Comparable<T>> {
    private T root;                                 // Item to hold the value of the root
    private BST<T> left;                            // Left subtree
    private BST<T> right;                           // Right subtree

    // Empty constructor
    public BST() {
        this.root = null;
        this.left = null;
        this.right = null;
    }

    // Constructor with a root item
    public BST(T rootItem) {
        this.root = rootItem;
        this.left = new BST<T>();
        this.right = new BST<T>();
    }

    /**
     * Checks to see if the tree is empty.
     * @return : returns true if the tree is empty.
     */
    public boolean isEmpty() {
        return (this.root == null);                         // Returns true if the root is null (contains no elements)
    }

    /**
     * Removes all of the items from a tree
     */
    public void removeAll() {
        this.root = null;                                   // Sets the root to null
        this.left = null;                                   // Sets the left subtree to null
        this.right = null;                                  // Sets the right subtree to null
    }

    /**
     * Checks to see the size of the tree
     * @return : The integer number for the size of the tree
     */
    public int size() {
        if (this.isEmpty())                                 // If the tree is empty, return 0.
            return 0;
        else                                                // If the tree is not empty, 
            return 1 + left.size() + right.size();          // Recursively call size to increment by one as subtrees are found
    }

    /**
     * Finds the height of the tree
     * @return : Returns an int of the height of the tree
     */
    public int height() {
        if (this.isEmpty())                                 // If the tree is empty, return 0.
            return 0;
        else {
            int leftHeight = this.left.height();            // Recursively call to find the longest path
            int rightHeight = this.right.height();          // Recursively call to find the longest path
            return 1 + Math.max(leftHeight, rightHeight);   // Find and return the height, i.e. the longest path
        }
    }

    /**
     * Add an item to the tree
     * @param item : the item to be added to the tree
     */
    public void add(T item) {
        if (this.isEmpty()) {                               // If the tree is empty, create a new tree
            this.root = item;                               // and set the root to the item
            this.left = new BST<T>();
            this.right = new BST<T>();
        }

        else {
            if (item.compareTo(this.root) > 0) {            // If the item is larger than the root,
                right.add(item);                            // Recursively call add to the right subtree.
            }
            else if (item.compareTo(this.root) < 0) {       // If the item is smaller than the root,
                left.add(item);                             // Recursivelt call add to the left subtree.
            }
        }
    }

    /**
     * 
     */
    private void removeRoot() {
        // case 1: leaf
        if (this.left.isEmpty() && this.right.isEmpty()) {
            //this.removeAll();
            this.root = null;
            this.left = null;
            this.right =null;
             // case 2: one child
        } else if (this.left.isEmpty()) {  // promote the right child
            this.root = this.right.root;
            this.left = this.right.left;
            this.right = this.right.right;

        } else if (this.right.isEmpty()) { // promote the left child
            this.root = this.left.root;
            this.left = this.left.left;
            this.right = this.left.right;
        } else { // Case 3: two children
            T replacement = this.right.min();
            this.root = replacement;
            this.right.remove(replacement);
        }

    }
    public void remove(T item) {
        if (this.isEmpty())
            throw new TreeException("Element is not in tree.");

        // Step 1: find the item
        int outcome = item.compareTo(this.root);
        if (outcome < 0)  // item < root
            this.left.remove(item);
        else if (outcome > 0) // item > root
            this.right.remove(item);
        else       // item == root
            this.removeRoot(); // Step 2)

        
    }

    public T min() throws TreeException {
        if (this.isEmpty()) 
            throw new TreeException("The tree is empty.");

        if (this.left.isEmpty())
            return this.root;
        else
            return this.left.min();
    }

    public T max() throws TreeException {
        if (this.isEmpty()) 
            throw new TreeException("The tree is empty.");

        if (this.right.isEmpty())
            return this.root;
        else
            return this.right.max();
    }

    public String preOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += " " + this.root.toString() + " ";
            s += this.left.preOrder();
            s += this.right.preOrder();
        }
        return s;
    }

    public String postOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.postOrder();
            s += this.right.postOrder();
            s += " " + this.root.toString() + " ";
        }
        return s;
    }

    public String inOrder() {
        String s = "";
        if (!this.isEmpty()) {
            s += this.left.inOrder();
            s += " " + this.root.toString() + " ";
            s += this.right.inOrder();
        }
        return s;
    }

    // Code used from elsewhere to build visual representation of the tree
    public String toString() {
        StringBuilder buffer = new StringBuilder(50);
        if (!this.isEmpty())
            buildTreeString(buffer, "", "");
        return buffer.toString();
    }
    
    // Code used from elsewhere to build visual representation of the tree
    private void buildTreeString(StringBuilder buffer, String prefix, String childrenPrefix) {
        buffer.append(prefix);
        buffer.append(this.root.toString());
        buffer.append('\n');
        if (!this.left.isEmpty()) 
            if (!this.right.isEmpty())
                left.buildTreeString(buffer, childrenPrefix + "├── ", childrenPrefix + "│   ");
            else
                left.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
        
        if (!this.right.isEmpty())
            right.buildTreeString(buffer, childrenPrefix + "└── ", childrenPrefix + "    ");
    }
}
