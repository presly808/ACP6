package ua.artcode.ds.tree;

import java.util.Comparator;

/**
 * Created by serhii on 25.04.15.
 */
public class BinarySearchTree<E> implements ITree<E>{

    private TreeNode<E> root;
    private int size;
    private Comparator<E> comparator;

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    @Override
    public boolean add(E el) {

        if(!(el instanceof Comparable) && comparator == null){
            throw new UnsupportedOperationException("Element must implement Comparable");
        }

        Comparable<E> forComapare = (Comparable<E>) el;

        if(root == null) {
            root = new TreeNode<>(null, null, null, el);
            size++;
            return true;
        } else {
            TreeNode<E> iter = root;
            while(iter != null){
                int compareResult = forComapare.compareTo(iter.getValue());
                if(compareResult < 0){
                    if(iter.getlChild() == null){
                        iter.setlChild(new TreeNode<E>(null,null,iter,el));
                        size++;
                        return true;
                    } else {
                        iter = iter.getlChild(); // way condition
                    }
                } else if(compareResult > 0){
                    if(iter.getrChild() == null){
                        iter.setrChild(new TreeNode<E>(null,null,iter,el));
                        size++;
                        return true;
                    } else {
                        iter = iter.getrChild(); // way condition
                    }
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    @Override
    public E remove(E el) {
        return null;
    }

    @Override
    public boolean contains(E el) {
        return false;
    }

    @Override
    public void traverse() {
        traverse(root);
    }

    @Override
    public String toString() {
        return traverseStr(root);
    }

    private void traverse(TreeNode node){
        if(node == null) return;

        traverse(node.getlChild());
        System.out.println(node.getValue());
        traverse(node.getrChild());

    }

    private String traverseStr(TreeNode curr){
        String res = "";

        if(curr == null) {
            return res;
        }


        res += traverseStr(curr.getlChild());
        res += curr.getValue().toString() +"\n";
        res += traverseStr(curr.getrChild());

        return res;
    }
}
