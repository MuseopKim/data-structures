package binarysearchtree;

import binarytree.BinaryTree;

public class BinarySearchTree {

    private BinaryTree rootNode;

    public void insert(int data) {
        if (rootNode == null) {
            this.rootNode = new BinaryTree(data);
            return;
        }

        BinaryTree currentNode = rootNode;
        BinaryTree parentNode = currentNode;
        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.getData() == data) {
                return;
            }

            if (currentNode.getData() < data) {
                currentNode = currentNode.getRightSubTree();
                continue;
            }

            if (currentNode.getData() > data) {
                currentNode = currentNode.getLeftSubTree();
            }
        }

        BinaryTree newNode = new BinaryTree(data);
        if (parentNode.getData() > data) {
            parentNode.setLeftSubTree(newNode);
        }

        if (parentNode.getData() < data) {
            parentNode.setRightSubTree(newNode);
        }
    }

    public BinaryTree remove(int target) {
        // 부모노드를 갖지 않는 루트노드를 제거할 때 사용
        BinaryTree fakeParentRootNode = new BinaryTree(-1);
        fakeParentRootNode.setRightSubTree(rootNode);
        BinaryTree parentNode = fakeParentRootNode;

        BinaryTree currentNode = rootNode;
        BinaryTree targetNode = null;
        while (currentNode != null && currentNode.getData() != target) {
            parentNode = currentNode;

            if (currentNode.getData() > target) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        if (currentNode == null) {
            return null;
        }

        targetNode = currentNode;
        // 자식 노드가 하나도 없는 경우
        if (targetNode.getLeftSubTree() == null && targetNode.getRightSubTree() == null) {
            if (parentNode.getLeftSubTree() == targetNode) {
                parentNode.removeLeftSubTree();
            }
            if (parentNode.getRightSubTree() == targetNode) {
                parentNode.removeRightSubTree();
            }
        }
        // 자식 노드가 1개인 경우
        if (targetNode.getLeftSubTree() == null || targetNode.getRightSubTree() == null) {
            BinaryTree targetNodeChild = null;

            if (targetNode.getLeftSubTree() != null) {
                targetNodeChild = targetNode.getLeftSubTree();
            }
            if (targetNode.getRightSubTree() != null) {
                targetNodeChild = targetNode.getRightSubTree();
            }

            if (parentNode.getLeftSubTree() == targetNode) {
                parentNode.setLeftSubTree(targetNodeChild);
            }
            if (parentNode.getRightSubTree() == targetNode) {
                parentNode.setRightSubTree(targetNodeChild);
            }
            // 자식 노드가 2개인 경우
        }
        if (targetNode.getLeftSubTree() != null && targetNode.getRightSubTree() != null) {
            // 왼쪽 자식노드에서 가장 큰 값 or 오른쪽 자식노드중 가장 작은 값으로 대체한다.
            BinaryTree replacement = targetNode.getLeftSubTree();
            BinaryTree replacementParent = targetNode;

            while (replacement.getRightSubTree() != null) {
                replacementParent = replacement;
                replacement = replacement.getRightSubTree();
            }

            int targetData = targetNode.getData();
            targetNode.setData(replacement.getData());

            if (replacementParent.getLeftSubTree() == replacement) {
                replacementParent.setLeftSubTree(replacement.getLeftSubTree());
            }

            if (replacementParent.getRightSubTree() == replacement) {
                replacementParent.setRightSubTree(replacement.getLeftSubTree());
            }

            targetNode = replacement;
            targetNode.setData(targetData);
        }

        if (fakeParentRootNode.getRightSubTree() != rootNode) {
            rootNode = fakeParentRootNode.getRightSubTree();
        }

        return targetNode;
    }

    public BinaryTree search(int target) {
        BinaryTree currentNode = rootNode;

        while (currentNode != null) {
            if (currentNode.getData() == target) {
                return currentNode;
            }

            if (currentNode.getData() > target) {
                currentNode = currentNode.getLeftSubTree();
                continue;
            }

            if (currentNode.getData() < target) {
                currentNode = currentNode = currentNode.getRightSubTree();
            }
        }

        return null;
    }

    public BinaryTree getRootNode() {
        return this.rootNode;
    }
}
