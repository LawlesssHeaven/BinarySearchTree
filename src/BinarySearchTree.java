import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



/* Class BSTNode */

class BSTNode {

    BSTNode left, right;

    int data;



    /* Constructor */

    public BSTNode() {

        left = null;

        right = null;

        data = 0;

    }

    /* Constructor */

    public BSTNode(int n) {

        left = null;

        right = null;

        data = n;

    }

    /* Function to set left node */

    public void setLeft(BSTNode n) {

        left = n;

    }

    /* Function to set right node */

    public void setRight(BSTNode n) {

        right = n;

    }

    /* Function to get left node */

    public BSTNode getLeft() {

        return left;

    }

    /* Function to get right node */

    public BSTNode getRight() {

        return right;

    }

    /* Function to set data to node */

    public void setData(int d) {

        data = d;

    }

    /* Function to get data from node */

    public int getData() {

        return data;

    }


}



/* Class BST */

class BST {

    private BSTNode root;



    /* Constructor */

    public BST() {

        root = null;

    }
    int minvalue() {

        /* loop down to find the leftmost leaf */
        while (root.left != null) {
            root = root.left;
        }
        return (root.data);
    }


    int GethalfCount() {
        // If tree is empty
        if (root == null)
            return 0;

        Queue<BSTNode> queue = new LinkedList<BSTNode>();
        queue.add(root);

        int count = 0;
        while (!queue.isEmpty()) {

            BSTNode temp = queue.poll();
            if (temp.left != null && temp.right == null ||
                    temp.left == null && temp.right != null)
                count++;

            if (temp.left != null)
                queue.add(temp.left);

        }
        return count;
    }

        /* Function to check if tree is empty */

    public boolean isEmpty() {

        return root == null;

    }

    /* Functions to insert data */

    public void insert(int data) {

        root = insert(root, data);

    }
    /* Function to insert data recursively */

    private BSTNode insert(BSTNode node, int data) {

        if (node == null)

            node = new BSTNode(data);

        else {

            if (data <= node.getData())

                node.left = insert(node.left, data);

            else

                node.right = insert(node.right, data);

        }

        return node;

    }


    /* Functions to delete data */

    public void delete(int k) {

        if (isEmpty())

            System.out.println("Tree Empty");

        else if (search(k) == false)

            System.out.println("Sorry " + k + " is not present");

        else {

            root = delete(root, k);

            System.out.println(k + " deleted from the tree");

        }

    }

    private BSTNode delete(BSTNode root, int k) {

        BSTNode p, p2, n;

        if (root.getData() == k) {

            BSTNode lt, rt;

            lt = root.getLeft();

            rt = root.getRight();

            if (lt == null && rt == null)

                return null;

            else if (lt == null) {

                p = rt;

                return p;

            } else if (rt == null) {

                p = lt;

                return p;

            } else {

                p2 = rt;

                p = rt;

                while (p.getLeft() != null)

                    p = p.getLeft();

                p.setLeft(lt);

                return p2;

            }

        }

        if (k < root.getData()) {

            n = delete(root.getLeft(), k);

            root.setLeft(n);

        } else {

            n = delete(root.getRight(), k);

            root.setRight(n);

        }

        return root;

    }


    public int countNodes() {

        return countNodes(root);

    }

    /* Function to count number of nodes recursively */

    private int countNodes(BSTNode r) {

        if (r == null)

            return 0;

        else {

            int l = 1;

            l += countNodes(r.getLeft());

            l += countNodes(r.getRight());

            return l;

        }

    }

    /* Functions to search for an element */

    public boolean search(int val) {

        return search(root, val);

    }

    /* Function to search for an element recursively */

    private boolean search(BSTNode r, int val) {

        boolean found = false;

        while ((r != null) && !found) {

            int rval = r.getData();

            if (val < rval)

                r = r.getLeft();

            else if (val > rval)

                r = r.getRight();

            else {

                found = true;

                break;

            }

            found = search(r, val);

        }

        return found;

    }

    /* Function for inorder traversal */

    public void inorder() {

        inorder(root);

    }

    private void inorder(BSTNode r) {

        if (r != null) {

            inorder(r.getLeft());

            System.out.print(r.getData() + " ");

            inorder(r.getRight());

        }

    }

    /* Function for preorder traversal */

    public void preorder() {

        preorder(root);

    }




    private void preorder(BSTNode r) {

        if (r != null) {

            System.out.print(r.getData() + " ");

            preorder(r.getLeft());

            preorder(r.getRight());

        }

    }

    /* Function for postorder traversal */

    public void postorder() {

        postorder(root);

    }

    private void postorder(BSTNode r) {

        if (r != null) {

            postorder(r.getLeft());

            postorder(r.getRight());

            System.out.print(r.getData() + " ");

        }

    }

}



/* Class BinarySearchTree */

public class BinarySearchTree {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        /* Creating object of BST */

        BST bst =  null;

        System.out.println("Binary Search Tree Test\n");

        char ch;

        /*  Perform tree operations  */

        do {
            System.out.println("\nBinārais meklēšanas koks");
            System.out.println("Roberts Grants 10.grupa 191RDB368\n");

            System.out.println("\nBinary Search Tree Operations\n");
            System.out.println("1. Create new binary tree with some valus ");
            System.out.println("2. insert ");
            System.out.println("3. delete");
            System.out.println("4. search");
            System.out.println("5. count nodes");
            System.out.println("6. Check is binary tree empty");
            System.out.println("7. Print binary tree nodes");
            System.out.println("8. How many nodes in tree with 1 child ");
            System.out.println("9. Min element in tree");



            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    if (bst != null) {
                        System.out.println("Binary search tree is already created");
                    } else  {
                        bst = new BST();
                        BSTNode root = null;
                        bst.insert(40);
                        bst.insert(50);
                        bst.insert(60);
                        bst.insert(70);
                        bst.insert(43);
                        bst.insert(41);

                        System.out.println("Binary search tree created: ");
                        /*  Display tree  */
                        System.out.print("\nPost order : ");
                        bst.postorder();
                        System.out.print("\nPre order : ");
                        bst.preorder();
                        System.out.print("\nIn order : ");
                        bst.inorder();
                    }
                    break;
                case 2:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        System.out.println("Enter nuymber you want to add");
                        bst.insert(scan.nextInt());
                        /*  Display tree  */
                        System.out.print("\nPost order : ");
                        bst.postorder();
                        System.out.print("\nPre order : ");
                        bst.preorder();
                        System.out.print("\nIn order : ");
                        bst.inorder();
                    }
                    break;

                case 3:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        if(bst.isEmpty()) {
                            System.out.println("There are no numbers you could delete");
                            break;
                        }else {
                            System.out.println("Enter number you want to delete ");
                            /*  Display tree  */
                            System.out.print("\nPost order : ");
                            bst.postorder();
                            System.out.print("\nPre order : ");
                            bst.preorder();
                            System.out.print("\nIn order : ");
                            bst.inorder();
                            bst.delete(scan.nextInt());
                            break;
                        }
                    }
                    break;

                case 4:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        if (bst.isEmpty()) {
                            System.out.println("No elements in  binary tree first add some");
                        }else {
                            System.out.println("Enter  number you would like to find ");
                            System.out.println("Search result : " + bst.search(scan.nextInt()));
                            /*  Display tree  */
                            System.out.print("\nPost order : ");
                            bst.postorder();
                            System.out.print("\nPre order : ");
                            bst.preorder();
                            System.out.print("\nIn order : ");
                            bst.inorder();
                        }
                    }
                    break;

                case 5:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        if (bst.isEmpty()) {
                            System.out.println("Binary tree is empty please add numbers");
                        }else {
                            System.out.println("Nodes = " + bst.countNodes());
                            /*  Display tree  */
                            System.out.print("\nPost order : ");
                            bst.postorder();
                            System.out.print("\nPre order : ");
                            bst.preorder();
                            System.out.print("\nIn order : ");
                            bst.inorder();
                        }
                    }
                    break;

                case 6:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        System.out.println("Empty status = " + bst.isEmpty());
                        /*  Display tree  */
                        System.out.print("\nPost order : ");
                        bst.postorder();
                        System.out.print("\nPre order : ");
                        bst.preorder();
                        System.out.print("\nIn order : ");
                        bst.inorder();
                    }
                    break;
                case 7:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        if (bst.isEmpty()) {
                            System.out.println("Binary search tree is empty first enter some numbers ");
                        } else {
                            bst.preorder();
                        }
                    }
                    break;
                case 8:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        if (bst.isEmpty()) {
                            System.out.println("Binary search tree is empty first enter numbers");
                        } else {
                           System.out.println("Number of nodes with one left child: " + bst.GethalfCount() );
                        }
                    }
                    break;
                case 9:
                    if(bst == null) {
                        System.out.println("Please create new binary search tree");
                    }else {
                        if (bst.isEmpty()) {
                            System.out.println("Binary search trtee is empty first enter some numbers");
                        } else {
                            System.out.println("Min element in right subtree : " + bst.minvalue() );
                        }
                    }
                    break;

                default:

                    System.out.println("Wrong Entry \n ");

                    break;

            }




            System.out.println("\nVai jūs vēlaties turpināt (Type y or n) \n");

            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');

    }


}