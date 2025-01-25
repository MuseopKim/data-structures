package heap;

import java.util.Objects;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftSubTree;
    private BinaryTree<T> rightSubTree;
    private BinaryTree<T> parentTree = null;

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree getLeftSubTree() {
        return this.leftSubTree;
    }

    public BinaryTree getRightSubTree() {
        return this.rightSubTree;
    }

    public void setLeftSubTree(BinaryTree binaryTree) {
        this.leftSubTree = binaryTree;
    }

    public void setRightSubTree(BinaryTree binaryTree) {
        this.rightSubTree = binaryTree;
    }

    public BinaryTree removeLeftSubTree() {
        BinaryTree targetSubTree = getLeftSubTree();
        setLeftSubTree(null);

        return targetSubTree;
    }

    public BinaryTree removeRightSubTree() {
        BinaryTree targetSubTree = getRightSubTree();
        setRightSubTree(null);

        return targetSubTree;
    }

    public void preOrderTraversal(BinaryTree binaryTree) {
        if (Objects.isNull(binaryTree)) {
            return;
        }

        System.out.println(binaryTree.getData());
        preOrderTraversal(binaryTree.getLeftSubTree());
        preOrderTraversal(binaryTree.getRightSubTree());
    }

    public void inOrderTraversal(BinaryTree binaryTree) {
        if (Objects.isNull(binaryTree)) {
            return;
        }

        inOrderTraversal(binaryTree.getLeftSubTree());
        System.out.println(binaryTree.getData());
        inOrderTraversal(binaryTree.getRightSubTree());
    }

    public void postOrderTraversal(BinaryTree binaryTree) {
        if (Objects.isNull(binaryTree)) {
            return;
        }

        postOrderTraversal(binaryTree.getLeftSubTree());
        postOrderTraversal(binaryTree.getRightSubTree());
        System.out.println(binaryTree.getData());
    }

    public BinaryTree<T> getParent() {
        return this.parentTree;
    }

    public void setParent(BinaryTree<T> tree) {
        this.parentTree = tree;
    }
}
