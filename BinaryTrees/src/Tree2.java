/** Tree2 is my own replication of Mitchell Waite's 'Tree'. Tree2 is a learning exercise.
 *
 * Sept 6, 2022
 * Written by Andrew Pauls
 */

public class Tree2 {
    Node root;

    // methods needed for the tree are: insert(x), find(x), delete, minimum, maximum, inOrder, preOrder, postOrder
    public Node find(int val){
        Node current = root;
        if (current.iData == val) return current;
        while ( current.iData != val ){
            if( val < current.iData ) {     // move current left, follow with parent
                current = current.leftChild;
                if (current.iData == val) return current;
            }
            else {
                current = current.rightChild;
                if(current.iData == val) return current;
            }
        }
        if (current == null){
            System.out.println("cannot find the value " + val + " in tree.");
        }
        return null;
    }

    public void insert( int val, double valD ) {
        Node newNode = new Node();                      // the node we need to insert
        newNode.iData=val;                              // providing the new node with values
        newNode.dData=valD;
        if ( root == null ) root = newNode;             // if there are no nodes, make the root the new node

        else{
            Node current = root;
            Node parent;

             while (true) {                        // we need to get current to equal null
                 parent = current;
                 if (val < current.iData) {
                     current = current.leftChild;
                     if (current == null) {   // place to insert
                         parent.leftChild = newNode;
                         return;
                     }
                 } else {
                     current = current.rightChild;
                     if (current == null) {
                         parent.rightChild = newNode;
                         return;
                     }
                 }
             }
        }
    }

    public boolean delete(int val){                            // here is the big challenger!

        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while(current.iData != val){
            parent = current;
            if(val < current.iData){
                current = current.leftChild;
                isLeftChild = true;
                if(current == null) return false;
            }
            else {
                current = current.rightChild;
                isLeftChild = false;
                if(current == null)return false;
            }
        }

        // situation 1. The node to be deleted is a leaf.
        if(current.leftChild == null & current.rightChild==null) {
            if(current == root){
                root = null;
                return true;
            }
            else {
                if (isLeftChild) {
                    parent.leftChild = null;
                    return true;
                }
                else {
                    parent.rightChild = null;
                    return true;
                }
            }
        }

        // situation 2. The node to be deleted has a single child.
        else if(current.leftChild == null) {      // has left but no right
            if(current == root){
                root = current.rightChild;
            }
            else if (isLeftChild) {
                // insert root statement here?
                parent.leftChild = current.rightChild;
                return true;
            } else {
                parent.rightChild = current.rightChild;
                return true;
            }
        }
        else if(current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }
            else if(isLeftChild){
                parent.leftChild=current.leftChild;
                return true;
            }
            else{
                parent.rightChild=current.leftChild;
                return true;
            }
        }

        //situation 3. DelNode has two children.
        else {
            return false;
        }

        return false;
    }

    // START HERE
    private Node getSuccessor(Node delNode){
        return null;
    }

    public Node minimum(Node Root){
        Node current = root;
        Node parent = root;
        while(current != null){
            parent = current;
            current = current.leftChild;
        }
        return parent;
    }

    public Node maximum(Node localRoot){
        Node current = root;
        Node parent = root;
        while(current != null){
            parent = current;
            current = current.rightChild;
        }
        return parent;
    }

    public void inOrder(Node localRoot){
        if (localRoot == null) return;
        inOrder(localRoot.leftChild);
        localRoot.displayNode();
        inOrder(localRoot.rightChild);
    }

    public void preOrder(Node localRoot){
        if (localRoot == null) return;
        localRoot.displayNode();
        preOrder(localRoot.leftChild);
        preOrder(localRoot.rightChild);
    }

    public void postOrder(Node localRoot){
        if (localRoot == null) return;
        postOrder(localRoot.leftChild);
        postOrder(localRoot.rightChild);
        localRoot.displayNode();
    }

}
