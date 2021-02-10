package BST;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        bst.insert(9);
        bst.insert(10);
        bst.insert(2);
        bst.insert(4);

        System.out.println(bst.search(7));
        System.out.println(bst.search(6));

        System.out.println(bst.remove(1));
        System.out.println(bst.remove(4));

    }
}
