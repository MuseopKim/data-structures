package binarysearchtree;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.*;

import binarytree.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

    private BinarySearchTree binarySearchTree;

    @BeforeEach
    void initTree() {
        /**
         *                               19
         *                 16                             32
         *            11                           28           34
         *       7          13                 25                    36
         *   4      9    12               21                             38
         *
         *
         */
        binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(19);
        binarySearchTree.insert(16);
        binarySearchTree.insert(11);
        binarySearchTree.insert(7);
        binarySearchTree.insert(4);
        binarySearchTree.insert(9);
        binarySearchTree.insert(13);
        binarySearchTree.insert(12);
        binarySearchTree.insert(32);
        binarySearchTree.insert(28);
        binarySearchTree.insert(25);
        binarySearchTree.insert(21);
        binarySearchTree.insert(34);
        binarySearchTree.insert(36);
        binarySearchTree.insert(38);
    }

    @Test
    void inOrderTraversal() {
        BinaryTree rootNode = binarySearchTree.getRootNode();
        rootNode.inOrderTraversal(rootNode);
    }

    @Test
    void removeTest() {
        BinaryTree remove = binarySearchTree.remove(19);
        binarySearchTree.getRootNode().inOrderTraversal(binarySearchTree.getRootNode());
    }

    @Test
    void searchTest() {
        int searchTarget = 7;
        BinaryTree searchNode = binarySearchTree.search(searchTarget);

        then(searchNode.getData()).isEqualTo(searchTarget);
    }
}