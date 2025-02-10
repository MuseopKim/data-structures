package binarysearchtree;

import binarytree.BinaryTree;

public class BinarySearchTree {

    private BinaryTree root;

    public void insert(int data) {
        if (this.root == null) {
            this.root = new BinaryTree(data);
            return;
        }

        BinaryTree currentNode = this.root;
        BinaryTree parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;

            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftSubTree();
            } else if (currentNode.getData() < data) {
                currentNode = currentNode.getRightSubTree();
            } else {
                return;
            }
        }

        BinaryTree newNode = new BinaryTree(data);

        if (parentNode.getData() > newNode.getData()) {
            parentNode.setLeftSubTree(newNode);
        } else {
            parentNode.setRightSubTree(newNode);
        }
    }

    public BinaryTree search(int targetData) {
        BinaryTree currentNode = this.root;

        while (currentNode != null) {
            if (currentNode.getData() == targetData) {
                return currentNode;
            } else if (currentNode.getData() > targetData) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        return null;
    }

    public BinaryTree remove(int targetData) {
        BinaryTree fakeParentRootNode = new BinaryTree(0);
        BinaryTree parentNode = fakeParentRootNode;
        BinaryTree currentNode = this.root;
        BinaryTree deletingNode = null;

        fakeParentRootNode.setRightSubTree(this.root);

        while (currentNode != null && currentNode.getData() != targetData) {
            parentNode = currentNode;
            if (currentNode.getData() > targetData) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        if (currentNode == null) {
            return null;
        }

        deletingNode = currentNode;

        /**
         * 터미널 노드 제거
         */
        if (deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.removeLeftSubTree();
            } else {
                parentNode.removeRightSubTree();
            }

            return deletingNode;
        }

        /**
         * 자식 노드를 1개 가지는 경우
         */
        if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {
            BinaryTree deletingChildNode = null;

            if (deletingNode.getLeftSubTree() != null) {
                deletingChildNode = deletingNode.getLeftSubTree();
            } else {
                deletingChildNode = deletingNode.getRightSubTree();
            }

            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.setLeftSubTree(deletingChildNode);
            } else {
                parentNode.setRightSubTree(deletingChildNode);
            }

            return deletingNode;
        }

        /**
         * 자식 노드가 2개 있는 경우
         */
        if (deletingNode.getRightSubTree() != null && deletingNode.getRightSubTree() != null) {
            BinaryTree replacingNode = deletingNode.getLeftSubTree();
            BinaryTree replacingNodeParent = deletingNode;

            while (replacingNode.getRightSubTree() != null) {
                replacingNodeParent = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            int deletingNodeData = deletingNode.getData();
            deletingNode.setData(replacingNode.getData());

            if (replacingNodeParent.getLeftSubTree() == replacingNode) {
                replacingNodeParent.setLeftSubTree(replacingNode.getLeftSubTree());
            } else {
                replacingNodeParent.setRightSubTree(replacingNode.getLeftSubTree());
            }

            deletingNode = replacingNode;
            deletingNode.setData(deletingNodeData);
        }

        /**
         * 루트노드가 변경 된 경우
         */
        if (fakeParentRootNode.getRightSubTree() != this.root) {
            this.root = fakeParentRootNode.getRightSubTree();
        }

        return deletingNode;
    }

    public BinaryTree getRoot() {
        return root;
    }
}
