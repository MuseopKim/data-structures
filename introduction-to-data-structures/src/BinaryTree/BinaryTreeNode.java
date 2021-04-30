package BinaryTree;

public class BinaryTreeNode {

    private int data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BinaryTreeNode getLeftSubTree() {
        return left;
    }

    public void setLeftSubTree(BinaryTreeNode node) {
        this.left = node;
    }

    public BinaryTreeNode getRightSubTree() {
        return right;
    }

    public void setRightSubTree(BinaryTreeNode node) {
        this.right = node;
    }

    // 중위 순회
    public static void inorderTraverse(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraverse(node.left);
        System.out.println(node.data);
        inorderTraverse(node.right);
    }

    public static void preorderTraverse(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preorderTraverse(node.left);
        preorderTraverse(node.right);
    }

    public static void postorderTraverse(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        postorderTraverse(node.left);
        postorderTraverse(node.right);
        System.out.println(node.data);
    }
}
