package BinaryTree;

public class Main {

    public static void main(String[] args) {
        BinaryTreeNode firstNode = new BinaryTreeNode(1);
        BinaryTreeNode secondNode = new BinaryTreeNode(2);
        BinaryTreeNode thirdNode = new BinaryTreeNode(3);
        BinaryTreeNode fourthNode = new BinaryTreeNode(4);
        BinaryTreeNode fifthNode = new BinaryTreeNode(5);

        firstNode.setLeftSubTree(secondNode);
        firstNode.setRightSubTree(thirdNode);
        secondNode.setLeftSubTree(fourthNode);
        thirdNode.setRightSubTree(fifthNode);

        BinaryTreeNode.inorderTraverse(firstNode);

        System.out.println("===================================");

        BinaryTreeNode.preorderTraverse(firstNode);

        System.out.println("===================================");

        BinaryTreeNode.postorderTraverse(firstNode);
    }
}
