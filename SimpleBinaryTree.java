package TreeTop;


public class SimpleBinaryTree {

    BinaryTreeNode binTree = new BinaryTreeNode( 0, null, null);
    BinaryTreeNode binTree2 = new BinaryTreeNode(null, null);
    public int value1 = 5;
    int value2 = 6;
    int value3 = 1;
    int value4 = 4;
    int value5 = 10;
    int value6 = 2;
    int value7 = 38;
    int value8 = 3;
    int value9 = 15;
    int value10 = 20;
    int value11 = 100;
    int value12 = 5;
    int value13 = 32;
    int value14 = 13;
    int[] values;




    public SimpleBinaryTree ( ) {
        //buildTreeManually();
        //displayTreeManually();
        buildArrayofValues();
        buildTreeRecursively(0, binTree2);
        System.out.println("Now lets display the tree recursively");
        System.out.println();
        System.out.println();
        System.out.println();
        displayTreeRecursively(binTree2);
    }
    // put these values into the binary tree


    private void buildArrayofValues () {
        // build values array
        values = new int[10];
        values[0] = value1;
        values[1] = value2;
        values[2] = value3;
        values[3] = value4;
        values[4] = value5;
        values[5] = value6;
        values[6] = value7;
        values[7] = value8;
        values[8] = value9;
        values[9] = value10;
    }


    // in this method we recursively build a binary tree, simply putting the elements from a pre-defined array of ints
    // into a pre defined binary tree
    // base case 1 : empty tree
    // base case 2 : no more elements in the array
    private void buildTreeRecursively ( int val, BinaryTreeNode theTree ) {
        if (values.length == val) {
            return;
        } else {
            theTree.val = val;      // we have elements to insert. insert at this node, the current val

            // check if we can go one more
            if (values.length > val + 1) {
                theTree.left = new BinaryTreeNode(values[val + 1], null, null);           // build new node if we have more ellys
            }

            if (values.length > val + 2) {
                theTree.right = new BinaryTreeNode(values[val + 2], null, null);
            }
            if (values.length > val + 3) {
                buildTreeRecursively(val + 3, theTree.left);
            }
        }
    }



    /** private method, displayTreeRecursively
     * displays a tree in proper order ( top first... then bottom left, then bottom right, etc )
     *
     */
    private void displayTreeRecursively( BinaryTreeNode theTree) {

        // if the tree is empty
        if (theTree == null) {
            return;
        }

        // if the tree is not empty
        // depending on where you put the print statement, order of printing will be adjusted.
        else {
            System.out.println("Value: " + theTree.val);    // current element, left subtree, right subtree order of printing
            displayTreeRecursively(theTree.left);
            // System.out.println("Value: " + theTree.val); // left, above, right order of printing
            displayTreeRecursively(theTree.right);
            // System.out.println("Value: " + theTree.val); // left, right, above order of printing

        }
    }
    private void displayTreeManually() {
        System.out.println("root val: " + binTree.val);
        System.out.println("Left child: " + binTree.left.val);
        System.out.println("Right child: " + binTree.right.val);
        // grandchildren
        System.out.println("Left left Grandchild: " + binTree.left.left.val);
        System.out.println("Left right Grandchild: " + binTree.left.right.val);
        System.out.println("Right left Grandchild: " + binTree.right.left.val);
        System.out.println("Right right Grandchild: " + binTree.right.right.val);
        // message... we havent printed them all
        System.out.println("here are the first 7 elements of the binTree");
    }
    private void buildTreeManually() {
        // children
        binTree.left = new BinaryTreeNode(value1, null, null);
        binTree.right = new BinaryTreeNode(value2, null, null);

        // grandchildren
        binTree.left.left = new BinaryTreeNode(value3, null, null);
        binTree.left.right = new BinaryTreeNode(value4, null, null);
        binTree.right.left = new BinaryTreeNode(value5, null, null);
        binTree.right.right = new BinaryTreeNode(value6, null, null);
        binTree.left.left.left = new BinaryTreeNode(value7, null, null);
        binTree.left.left.right = new BinaryTreeNode(value8, null, null);
        binTree.left.right.left = new BinaryTreeNode(value9, null, null);
        binTree.left.right.right = new BinaryTreeNode(value10, null, null);
        binTree.right.left.left = new BinaryTreeNode(value11, null, null);
        binTree.right.left.right = new BinaryTreeNode(value12, null, null);
        binTree.right.right.left = new BinaryTreeNode(value13, null, null);
        binTree.right.right.right = new BinaryTreeNode(value14, null, null);
    }



    public static void main ( String [] args ) { SimpleBinaryTree S = new SimpleBinaryTree();}
}

