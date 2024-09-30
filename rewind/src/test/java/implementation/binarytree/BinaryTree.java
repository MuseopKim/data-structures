package implementation.binarytree;

/**
 * ADT - getData() - setData() - getLeftSubTree() - getRightSubTree() - setLeftSubTree() - setRightSubTree() - preOrderTraversal()
 * - inOrderTraversal() - postOrderTraversal()
 */
public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftTree;
    private BinaryTree<T> rightTree;

    public BinaryTree(T data) {
        this.data = data;
        this.leftTree = null;
        this.rightTree = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftSubTree() {
        return this.leftTree;
    }

    public BinaryTree<T> getRightSubTree() {
        return this.rightTree;
    }

    public void setLeftSubTree(BinaryTree<T> leftTree) {
        this.leftTree = leftTree;
    }

    public void setRightSubTree(BinaryTree<T> rightTree) {
        this.rightTree = rightTree;
    }

    public void preOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) {
            return;
        }

        System.out.println(tree.data);
        preOrderTraversal(tree.getLeftSubTree());
        preOrderTraversal(tree.getRightSubTree());
    }

    public void inOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) {
            return;
        }

        inOrderTraversal(tree.getLeftSubTree());
        System.out.println(tree.data);
        inOrderTraversal(tree.getRightSubTree());
    }

    public void postOrderTraversal(BinaryTree<T> tree) {
        if (tree == null) {
            return;
        }

        postOrderTraversal(tree.getLeftSubTree());
        postOrderTraversal(tree.getRightSubTree());
        System.out.println(tree.data);
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "data=" + data +
                '}';
    }
}
