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

    private static class MyComparatorWrapper<E> implements Comparator<E>{

        private boolean isComparable;
        private Comparator<E> treeComparator;

        public MyComparatorWrapper(Comparator<E> treeComparator, boolean isComparable) {
            this.isComparable = isComparable;
            this.treeComparator = treeComparator;
        }



        @Override
        public int compare(E o1, E o2) {
            if(treeComparator != null){
                return treeComparator.compare(o1,o2);
            } else if(isComparable) {
                return ((Comparable)o1).compareTo(o2);
            }

            return 0;
        }
    }

    @Override
    public boolean add(E el) {

        Comparator<E> wrapperComparator = prepareComparator(el);


        if(root == null) {
            root = new TreeNode<>(null, null, null, el);
            size++;
            return true;
        } else {
            TreeNode<E> iter = root;
            while(iter != null){
                int compareResult = wrapperComparator.compare(el, iter.getValue());
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
        Comparator<E> wrapperComparator = prepareComparator(el);
        return find(wrapperComparator,root,el) != null;
    }

    private Comparator<E> prepareComparator(E el){
        boolean isComparable = el instanceof Comparable;
        if(comparator == null && !isComparable){
            throw new UnsupportedOperationException("Element must implement Comparable");
        }

        Comparator<E> wrapperComparator =
                new MyComparatorWrapper<>(comparator, isComparable);
        return wrapperComparator;
    }

    private TreeNode find(Comparator<E> comparator, TreeNode<E> curr, E el){
        if(curr == null){
            return null;
        }

        int compareRes = comparator.compare(el,curr.getValue());
        if(compareRes < 0){
            return find(comparator,curr.getlChild(),el);
        } else if(compareRes > 0){
            return find(comparator,curr.getrChild(),el);
        } else {
            return curr;
        }

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
