package ua.artcode.ds.tree;

/**
 * Created by serhii on 25.04.15.
 */
public class TestBinarySearchTree {
    public static void main(String[] args) {
        ITree<String> tree = new BinarySearchTree<>();

        tree.add("Ivan");               //     ivan
        tree.add("Olexiy");         // Anton         Olexiy
        tree.add("Anton");         //     Bogdan         Petro
        tree.add("Bogdan");
        tree.add("Petro");

        tree.traverse();
        System.out.println();
        System.out.println(tree);

    }
}
