package binarytree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    private BinaryTree tree1 = new BinaryTree(1);
    private BinaryTree tree2 = new BinaryTree(2);
    private BinaryTree tree3 = new BinaryTree(3);
    private BinaryTree tree4 = new BinaryTree(4);
    private BinaryTree tree5 = new BinaryTree(5);
    private BinaryTree tree6 = new BinaryTree(6);
    private BinaryTree tree7 = new BinaryTree(7);

    @BeforeEach
    void initTree() {
        /**
         *
         *                  1
         *          2               3
         *      4       5       6       7
         *
         */
        tree1.setLeftSubTree(tree2);
        tree1.setRightSubTree(tree3);
        tree2.setLeftSubTree(tree4);
        tree2.setRightSubTree(tree5);
        tree3.setLeftSubTree(tree6);
        tree3.setRightSubTree(tree7);
    }

    @Test
    void preOrderTraversal() {
        tree1.preOrderTraversal(tree1);
    }

    @Test
    void inOrderTraversal() {
        tree1.inOrderTraversal(tree1);
    }

    @Test
    void postOrderTraversal() {
        tree1.postOrderTraversal(tree1);
    }
}