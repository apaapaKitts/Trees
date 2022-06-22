package TreeTop;

public class BinaryTreeNode {

    public int val;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(BinaryTreeNode L, BinaryTreeNode R) {
        left = L;
        right = R;
    }

    public BinaryTreeNode(int theVal, BinaryTreeNode L, BinaryTreeNode R) {

        val = theVal;
        left = L;
        right = R;
    }

}

