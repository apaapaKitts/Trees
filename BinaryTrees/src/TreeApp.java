/** This is an incomplete class taken from Mitchell Waite's 'Data Structure and Algorithms in Java' textbook
 *
 * I have not authored it in any way.
 *
 * September 6, 2022
 */
public class TreeApp {
    public static void main (String []args) {
        Tree theTree = new Tree();

        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);

        Node found = theTree.find(25);
        if (found != null) System.out.println("Found the node with key 25");
        else
            System.out.println("Could not find node with key 25");

    }
}
