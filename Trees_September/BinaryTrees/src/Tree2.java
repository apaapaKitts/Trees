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
        Node current = root;
        Node parent = root;
        while (current != null){                        // we need to get current to equal null
            if ( val < current.iData ) {
                parent = current;
                current = current.leftChild;
            }
            else {
                parent = current;
                current = current.rightChild;
            }
        }
        if ( val < parent.iData ) parent.leftChild= newNode;
        else parent.rightChild = newNode;
    }

    private boolean delete(int val){
        return false;
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

    private void inOrder(Node localRoot){
        if (localRoot == null) return;
        inOrder(localRoot.leftChild);
        localRoot.displayNode();
        inOrder(localRoot.rightChild);
    }

    private void preOrder(Node localRoot){
        if (localRoot == null) return;
        localRoot.displayNode();
        preOrder(localRoot.leftChild);
        preOrder(localRoot.rightChild);
    }

    private void postOrder(Node localRoot){
        if (localRoot == null) return;
        postOrder(localRoot.leftChild);
        postOrder(localRoot.rightChild);
        localRoot.displayNode();
    }

}
