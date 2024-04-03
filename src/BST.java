import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    private BSTNode root;

    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // TODO: Complete the search function
        return searchNode(root, val);
    }

    //Iterates through each Node returning true if it finds Val false otherwise
    public boolean searchNode(BSTNode n, int val){
        if(n == null){
            return false;
        }
        if(n.getVal() == val){
            return true;
        }
        if(val > n.getVal()){
            return searchNode(n.getRight(),val);
        }
        return searchNode(n.getLeft(), val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        //Left, Root, Right
        // TODO: Complete inorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        Inorder(list, root);
        return list;
    }

    //Iterates through the tree ads Left, Root, Right
    public void Inorder(ArrayList<BSTNode> list, BSTNode n){
        if(n == null){
            return;
        }
        Inorder(list, n.getLeft());
        list.add(n);
        Inorder(list, n.getRight());
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        //Root,Left,Right
        // TODO: Complete preorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        Preorder(list, root);
        return list;
    }
    //Iterates through the tree ads Root, Left, Right
    public void Preorder(ArrayList<BSTNode> list, BSTNode n){
        if(n == null){
            return;
        }
        list.add(n);
        Preorder(list, n.getLeft());
        Preorder(list, n.getRight());
    }


    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        //Left, Right Root
        // TODO: Complete postorder traversal
        ArrayList<BSTNode> list = new ArrayList<BSTNode>();
        Postorder(list, root);
        return list;
    }
    //Iterates through the tree ads Left, Right, Root
    public void Postorder(ArrayList<BSTNode> list, BSTNode n){
        if(n == null){
            return;
        }
        Postorder(list, n.getLeft());
        Postorder(list, n.getRight());
        list.add(n);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        // TODO: Complete insert
        Insert(root, val);
    }
    //Iterates through tree inserts in right spot
    public void Insert(BSTNode n, int val){
        if(n.getLeft() == null){
            n.setLeft(new BSTNode(val));
            return;
        }
        if(n.getRight() == null){
            n.setRight(new BSTNode(val));
            return;
        }
        if(n.getVal() == val){
            return;
        }
        if(val > n.getVal()){
            Insert(n.getRight(),val);
        }
        if(val < n.getVal()){
            Insert(n.getLeft(), val);
        }
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
