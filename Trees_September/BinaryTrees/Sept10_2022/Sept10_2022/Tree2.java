import com.sun.net.httpserver.Authenticator;

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

    public boolean delete(int val) {                            // here is the big challenger!

        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.iData != val) {
            parent = current;
            if (val < current.iData) {
                current = current.leftChild;
                isLeftChild = true;
                if (current == null) return false;
            } else {
                current = current.rightChild;
                isLeftChild = false;
                if (current == null) return false;
            }
        }

        // situation 1. The node to be deleted is a leaf.
        if (current.leftChild == null & current.rightChild == null) {
            if (current == root) {
                root = null;
                return true;
            } else {
                if (isLeftChild) {
                    parent.leftChild = null;
                    return true;
                } else {
                    parent.rightChild = null;
                    return true;
                }
            }
        }

        // situation 2. The node to be deleted has a single child.
        else if (current.leftChild == null) {      // has left but no right
            if (current == root) {
                root = current.rightChild;
                return true;
            } else if (isLeftChild) {
                // insert root statement here?
                parent.leftChild = current.rightChild;
                return true;
            } else {
                parent.rightChild = current.rightChild;
                return true;
            }
        } else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
                return true;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
                return true;
            } else {
                parent.rightChild = current.leftChild;
                return true;
            }
        }


        //______________________
        //situation 3. DelNode has two children.
        else {
            //situation 3. DelNode has two children.
            Node SuccessorParent = getSuccessorParent(current);
            Node Successor;
            boolean SuccessorHasRightChild;
            if (SuccessorParent == current) {
                Successor = SuccessorParent.rightChild;
            } else {
                Successor = SuccessorParent.leftChild;
            }
            if (Successor.rightChild == null) {
                SuccessorHasRightChild = false;
            } else {
                SuccessorHasRightChild = true;
            }


            // condition 1 -- successor is right child of delnode
            if (Successor == current.rightChild) {

                // condition 1 - if delnode is root
                if (current == root) {
                    Successor.leftChild = current.leftChild;
                    root = Successor;
                    return true;
                } else {// condition 2 - if delnode is NOT ROOT
                    // is left child
                    if (isLeftChild) {
                        Successor.leftChild = current.leftChild;
                        parent.leftChild = Successor;
                        return true;
                    // is right child
                    } else {
                        Successor.leftChild = current.leftChild;
                        parent.rightChild = Successor;
                        return true;
                    }
                }
            }

            // condition2 -- successor is not right child of delnode
            else {
                // condition1 - if delnode is root
                if (current == root) {
                    // if successor has right children
                    if (SuccessorHasRightChild) {
                        Successor.leftChild = root.leftChild;
                        SuccessorParent.leftChild = Successor.rightChild;
                        Successor.rightChild = root.rightChild;
                        root = Successor;
                        return true;
                    } else {
                        // if successor has no right children
                        Successor.leftChild = root.leftChild;
                        Successor.rightChild = root.rightChild;
                        SuccessorParent.leftChild = null;
                        root = Successor;
                        return true;
                    }
                }

                // condition2 - if delnode is not root
                else {
                    // if successor has right children
                    if (SuccessorHasRightChild) {
                        Successor.leftChild = current.leftChild;
                        SuccessorParent.leftChild = Successor.rightChild;
                        Successor.rightChild = current.rightChild;
                        if (isLeftChild) {
                            parent.leftChild = Successor;
                        } else {
                            parent.rightChild = Successor;
                        }
                        return true;
                    } else {
                        // if successor has no right children
                        Successor.leftChild = current.leftChild;
                        if (isLeftChild) {
                            parent.leftChild = Successor;
                        } else {
                            parent.rightChild = Successor;
                        }
                        return true;
                    }
                }
            }
        }
    }


    // START HERE
    private Node getSuccessorParent(Node delNode){
        Node Successor = delNode.rightChild;
        Node SuccessorParent = delNode;
        if (Successor.leftChild == null) return SuccessorParent;
        else {
            SuccessorParent = Successor;
            Successor = SuccessorParent.leftChild;
            while(Successor.leftChild != null){
                Successor = Successor.leftChild;
                SuccessorParent = SuccessorParent.leftChild;
            }
            return SuccessorParent;
        }
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
