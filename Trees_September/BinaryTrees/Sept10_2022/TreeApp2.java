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
        someTree.delete(2);
        someTree.inOrder(someTree.root);

        // ok. we have finished writing the third case of the delete method. lets test it out.
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Testing to see if the 3rd case of delete method works");
        someTree.insert(50, 4.2);
        someTree.insert(25, 2.1);
        someTree.insert(10, 1.1);
        someTree.insert(5, 4.22);
        someTree.insert(6, 5.6);
        someTree.insert(66,66.5);
        someTree.insert(59, 54.2);
        someTree.insert(80, 2.2);
        someTree.insert(30, 3.8);
        someTree.insert(12, 123.9);
        System.out.println("Displaying trees contents in order");
        someTree.inOrder(someTree.root);
        System.out.println("There are four nodes currently that have two children. They are: 50, 25, 10, 66");
        System.out.println("Lets try the furthest one from the root, 10");
        someTree.delete(10);
        System.out.println("Displaying tree in order");
        someTree.inOrder(someTree.root);
        System.out.println("Now lets delete node 66");
        someTree.delete(66);
        System.out.println("Displaying tree in order");
        someTree.inOrder(someTree.root);
        System.out.println("That also works. Lets check if deleting the root works");


        System.out.println();
        System.out.println();
        System.out.println("Deleting root");
        System.out.println("root is: " + someTree.root.iData);
        someTree.delete(50);
        System.out.println("root is: " + someTree.root.iData);
        //someTree.inOrder(someTree.root);
        System.out.println("Deleting 59 as root");
        //someTree.delete(59);
        System.out.println("Root is: " + someTree.root.iData);
        //someTree.inOrder(someTree.root);


//        System.out.println("Displaying tree in order.");
//        someTree.inOrder(someTree.root);
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("Aha. We have not written in the root case. Doing that now...");
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        System.out.println("Root is: " + someTree.root.iData);
//        someTree.delete(50);
//        System.out.println();
//        someTree.inOrder(someTree.root);
//        System.out.println();
//        System.out.println("Root is: " + someTree.root.iData);
//
//
//        // lets clear out this tree and do it real simple again
//        someTree.delete(30);
//        someTree.delete(25);
//        someTree.delete(12);
//        someTree.delete(5);
//        someTree.delete(6);
//        someTree.delete(59);
//        someTree.inOrder(someTree.root);
//        // damn. i am having some issues here.
//        someTree.preOrder(someTree.root);
//        System.out.println();
//        someTree.postOrder(someTree.root);
//        someTree.delete(5);
//        someTree.postOrder(someTree.root);
//        System.out.println();
//        System.out.println(someTree.root.iData);
//        someTree.insert(100, 1.1);
//        someTree.inOrder(someTree.root);
//        // rats. now its all busted up.
//        someTree.delete(50);
//        someTree.inOrder(someTree.root);
//        someTree.delete(80);
//        System.out.println("Root:" + someTree.root.iData);
//        someTree.inOrder(someTree.root);
//
//        System.out.println();
//        System.out.println();
//        System.out.println();
//        someTree.inOrder(someTree.root);
//        System.out.println("Root of the tree: " + someTree.root.iData);

    }



    public static void main (String [] args) { TreeApp2 t2 = new TreeApp2();}
}
