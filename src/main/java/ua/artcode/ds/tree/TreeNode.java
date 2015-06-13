package ua.artcode.ds.tree;

/**
 * Created by serhii on 25.04.15.
 */
public class TreeNode<T> {

    private TreeNode<T> lChild;
    private TreeNode<T> rChild;
    private TreeNode<T> parent;
    private T value;


    public TreeNode(TreeNode<T> lChild, TreeNode<T> rChild,
                    TreeNode<T> parent, T value) {
        this.lChild = lChild;
        this.rChild = rChild;
        this.parent = parent;
        this.value = value;
    }

    public TreeNode() {
    }

    public TreeNode<T> getlChild() {
        return lChild;
    }

    public void setlChild(TreeNode<T> lChild) {
        this.lChild = lChild;
    }

    public TreeNode<T> getrChild() {
        return rChild;
    }

    public void setrChild(TreeNode<T> rChild) {
        this.rChild = rChild;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
