package implementation.binarytree;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    void ADT() {
        BinaryTree<Integer> tree1 = new BinaryTree<>(1);
        BinaryTree<Integer> tree2 = new BinaryTree<>(2);
        BinaryTree<Integer> tree3 = new BinaryTree<>(3);
        BinaryTree<Integer> tree4 = new BinaryTree<>(4);
        BinaryTree<Integer> tree5 = new BinaryTree<>(5);
        BinaryTree<Integer> tree6 = new BinaryTree<>(6);
        BinaryTree<Integer> tree7 = new BinaryTree<>(7);

        tree1.setLeftSubTree(tree2);
        tree1.setRightSubTree(tree3);

        tree2.setLeftSubTree(tree4);
        tree2.setRightSubTree(tree5);

        tree3.setLeftSubTree(tree6);
        tree3.setRightSubTree(tree7);

        System.out.println("Root node's right sub tree : " + tree1.getRightSubTree());
        System.out.println("Root node's right sub tree's left sub tree : " + tree1.getRightSubTree().getLeftSubTree());

        System.out.println("preOrderTraversal");
        tree1.preOrderTraversal(tree1);

        System.out.println("inOrderTraversal");
        tree1.inOrderTraversal(tree1);

        System.out.println("postOrderTraversal");
        tree1.postOrderTraversal(tree1);
    }
}
