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
        someTree.insert(155, 34.1); /// THIS CURRENTLY BREAKS THE PROGRAM.... PROGRAM NEVER ENDS

        System.out.println("The root of this tree is: " + someTree.root.iData);
        System.out.println("The minimum of this tree is: " + someTree.minimum(someTree.root).iData);
        //System.out.println("The maximum of this tree is: " + someTree.maximum(someTree.root).iData);
    }



    public static void main (String [] args) { TreeApp2 t2 = new TreeApp2();}
}
