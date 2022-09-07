/** Tree class from Mitchell Waite's 'Data Structures & Algorithms in Java'
 *  Today I exercised again with Binary Search Trees. Over a three-hour period, I spent time picking apart the
 *  methods of Waite's binary tree, while copying them to this file upon gaining understanding.
 *
 *  This is not work that I produced - although I did type every line. The purpose of this class is for
 *  my own understanding. I have provided comments for some methods thus far.
 *
 *  Sept 6, 2022
 *  Author: Andrew Pauls
 */
public class Tree{
    private Node root;

    public Node find(int key){
        Node current = root;

        while (current.iData != key){
            if ( key < current.iData ) current = current.leftChild;
            else current = current.rightChild;
            if (current == null) return null;
        }
        return current;
    }

    public void insert(int id, double dd) {
        Node newNode = new Node();                              // build the new node
        newNode.iData = id;                                     // fill in fields of new node
        newNode.dData = dd;
        if (root == null) root = newNode;                       // if the tree is empty, make new node the root
        else {                                                  // if tree is not empty...
            Node current = root;                                // construct a pointer
            Node parent;                                        // construct another pointer, which will ultimately point to new node
            while (true) {                                      // cool technique, built in endings later
                parent = current;                               // initially checks root, trails current ( parent always non-null )
                if (id < current.iData) {                       // if value is less than the current node
                    current = current.leftChild;                // go left, adjust current to left child
                    if (current == null) {                      // if current is now null, insert new node in its place
                        parent.leftChild = newNode;
                        return;                                 // break from the while loop
                    }
                } else {                                        // value is greater than or equal to current value
                    current = current.rightChild;               // assign current to be right child of current
                    if (current == null) {                      // if we have landed current on a null
                        parent.rightChild = newNode;            // insert the new node in place of current
                        return;                                 // break out of the while loop
                    }
                }
            }
        }
    }


    private void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    private void preOrder(Node localRoot){
        if(localRoot !=null){
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }


    private void postOrder(Node localRoot){
        if(localRoot !=null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

    public Node minimum() {
        Node current, last = null;
        current = root;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public Node maximum() {
        Node current, last = null;
        current = root;
        while (current != null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        // search for the node
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        } // end while, found node to delete

        // if no children (case1) - delete the node
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) root = null;
            else if (isLeftChild) parent.leftChild = null;
            else
                parent.rightChild = null;
        }

        // if one child (case2) - delete the node
        else if (current.rightChild==null){
            if(current==root) root = current.leftChild;
            else if(isLeftChild) parent.leftChild = current.leftChild;
            else parent.rightChild=current.leftChild;
        }

        else if (current.leftChild==null){
            if(current==root) root=current.rightChild;
            else if(isLeftChild) parent.leftChild = current.rightChild;
            else parent.rightChild = current.rightChild;
        }

        // if two children (case 3) - delete the node
        else {
            Node successor = getSuccessor(current);
            if (current == root) root = successor;
            else if (isLeftChild) parent.leftChild = successor;
            else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }// end of delete


    private Node getSuccessor(Node delNode){                        // finds next largest value after del node
        Node successorParent = delNode;                             // pointer, begins on found node to be deleted
        Node successor = delNode;                                   // pointer, begins on found node to be deleted
        Node current = delNode.rightChild;                          // pointer, right child of delNode
        while(current != null) {                                    // it will always start non null ( other two cases ensure this )
            successorParent = successor;                            // reassign successorParent to successor
            successor = current;                                    // shift down successor pointer
            current = current.leftChild;                            // attempt to assign current to left child (do this until it is null)
        }
        if (successor != delNode.rightChild){                       // if the successor is a left descendant of right child
            successorParent.leftChild = successor.rightChild;       // left child of successor parent is right child of successor
            successor.rightChild = delNode.rightChild;              // successor right child now points to node deleted node used to point right to
        }
        return successor;
    }
}// end Tree
