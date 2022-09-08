/** This is an implementation of 'Tree2'. I have authored all of TreeApp2 as well as Tree2.
 *
 * September 6, 2022
 * Author: Andrew Pauls
 */
public class TreeApp2 {

    public Tree2 someTree = new Tree2();

    public TreeApp2 () {
        System.out.println("Testing our tree methods");
        someTree.insert(50,3.2);
        someTree.insert(25, 2.33);
        someTree.insert(2,3.3);
        //someTree.insert(50,3.22);
        //someTree.insert(155, 34.1); /// THIS CURRENTLY BREAKS THE PROGRAM.... PROGRAM NEVER ENDS

        System.out.println("The root of this tree is: " + someTree.root.iData);
        System.out.println("The minimum of this tree is: " + someTree.minimum(someTree.root).iData);
        System.out.println("The maximum of this tree is: " + someTree.maximum(someTree.root).iData);

        // adding bigger and retesting max
        someTree.insert(1000,2.333);
        System.out.println("The maximum of this tree is: " + someTree.maximum(someTree.root).iData);

        // now working with the find() method
        System.out.println("searching for: 25. Here it is: " + someTree.find(25).iData);
        System.out.println("searching for: 2. Here it is: " + someTree.find(2).iData);
        System.out.println("searching for: 1000. Here it is: " + someTree.find(1000).iData);
        System.out.println("searching for: 50. Here it is: " + someTree.find(50).iData);


        // now looking at our traversals
        someTree.inOrder(someTree.root);
        someTree.preOrder(someTree.root);
        someTree.postOrder(someTree.root);


        // now lets test the first portion of our delete method
        System.out.println();
        System.out.println();
        System.out.println("Deleting a leaf");
        someTree.delete(2);
        someTree.inOrder(someTree.root);
        someTree.delete(25);
        someTree.inOrder(someTree.root);
        someTree.delete(1000);
        someTree.inOrder(someTree.root);
        boolean isDeletable = someTree.delete(1000);
        System.out.println("It is : " + isDeletable + " that we can delete 1000");
        someTree.delete(50);
        someTree.inOrder(someTree.root);
        // tree is now empty. ( fully deleted )
        // deletion method is rock solid so far!

        // now lets test case 2
        System.out.println();
        System.out.println();
        System.out.println("Testing if delete method works for when delNode has a single child.");
        someTree.insert(5,3.2);
        someTree.insert(8,3.1);
        someTree.insert(19,5.5);
        someTree.insert(2,2.9);
        someTree.inOrder(someTree.root);
        someTree.delete(8);
        someTree.inOrder(someTree.root);
        someTree.delete(19);
        someTree.inOrder(someTree.root);
        someTree.delete(5);
        someTree.inOrder(someTree.root);
        System.out.println("Root of this tree is: " + someTree.root.iData);
    }



    public static void main (String [] args) { TreeApp2 t2 = new TreeApp2();}
}
