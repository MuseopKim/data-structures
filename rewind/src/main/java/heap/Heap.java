package heap;

import java.util.Comparator;

public class Heap<T> {

    private BinaryTree<T> root;
    private BinaryTree<T> lastInserted;
    private Comparator<T> comparator;

    public Heap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T data) {
        if (this.lastInserted == null) {
            this.lastInserted = new BinaryTree<>(data);
            this.root = this.lastInserted;
            return;
        }

        BinaryTree<T> insertingParent = this.getInsertingParent();
        BinaryTree<T> newNode = new BinaryTree<>(data);

        if (insertingParent.getLeftSubTree() == null) {
            insertingParent.setLeftSubTree(newNode);
        } else if (insertingParent.getRightSubTree() == null) {
            insertingParent.setRightSubTree(newNode);
        }

        newNode.setParent(insertingParent);
        this.lastInserted = newNode;

        while (newNode.getParent() != null) {
            BinaryTree<T> parent = newNode.getParent();
            if (isHigherPriority(newNode.getData(), parent.getData())) {
                T parentData = parent.getData();
                parent.setData(newNode.getData());
                newNode.setData(parentData);
                newNode = newNode.getParent();
            } else {
                break;
            }
        }
    }

    private BinaryTree<T> getInsertingParent() {
        /**
         * 마지막으로 삽입된 노드가 루트노드인 경우
         */
        if (this.lastInserted.getParent() == null) {
            return this.lastInserted;
        }

        /**
         * lastInserted가 부모노드의 왼쪽 자식노드인 경우
         */
        if (this.lastInserted == this.lastInserted.getParent().getLeftSubTree()) {
            return this.lastInserted.getParent();
        }

        /**
         * 마지막으로 삽입된 노드가 부모노드의 오른쪽 자식노드인 경우
         */
        BinaryTree<T> current = this.lastInserted;
        BinaryTree<T> firstRightSibling = null;

        // 루트노드 이전까지 반복
        while (current.getParent().getParent() != null) {
            current = current.getParent();
            firstRightSibling = getRightSibling(current);
            if (firstRightSibling != null) {
                break;
            }
        }

        // a. 부모노드 중에서 오른쪽 형제 노드를 가지는 노드가 존재하는 경우
        if (firstRightSibling != null) {
            while (firstRightSibling.getLeftSubTree() != null) {
                firstRightSibling = firstRightSibling.getLeftSubTree();
            }

            return firstRightSibling;
        }

        // b. 부모노드 중에서 오른쪽 형제 노드를 가지는 노드가 존재하지 않는 경우
        current = this.root;
        while (current.getLeftSubTree() != null) {
            current = current.getLeftSubTree();
        }

        return current;
    }

    private BinaryTree<T> getRightSibling(BinaryTree<T> node) {
        // 현재노드가 부모노드의 오른쪽 자식이 아니라면
        if (node.getParent().getRightSubTree() != node) {
            return node.getParent().getRightSubTree();
        }

        return null;
    }

    private BinaryTree<T> getLeftSibling(BinaryTree<T> node) {
        // 현재노드가 부모노드의 왼쪽 자식이 아니라면
        if (node.getParent().getLeftSubTree() != node) {
            return node.getParent().getLeftSubTree();
        }

        return null;
    }

    public boolean isHigherPriority(T one, T other) {
        return comparator.compare(one, other) < 0;
    }

    public BinaryTree<T> getRoot() {
        return root;
    }

    public BinaryTree<T> remove() {
        BinaryTree<T> deletedNode = null;
        // 마지막 노드가 루트노드인 경우
        if (this.lastInserted == this.root) {
            deletedNode = this.root;
            this.root = null;
            this.lastInserted = null;
            return deletedNode;
        }

        BinaryTree<T> prevLastInsertedNode = this.getNewLastInsertedNode();
        T parentData = this.root.getData();
        this.root.setData(this.lastInserted.getData());
        this.lastInserted.setData(parentData);

        if (this.lastInserted.getParent().getLeftSubTree() == this.lastInserted) {
            this.lastInserted.getParent().setLeftSubTree(null);
        } else {
            this.lastInserted.getParent().setRightSubTree(null);
        }

        this.lastInserted.setParent(null);
        deletedNode = this.lastInserted;
        this.lastInserted = prevLastInsertedNode;

        BinaryTree<T> current = this.root;
        do {
            BinaryTree<T> higherChild = this.getHigherPriorityChild(current.getLeftSubTree(), current.getRightSubTree());
            if (higherChild == null) {
                break;
            }

            if (!this.isHigherPriority(current.getData(), higherChild.getData())) {
                T currentData = current.getData();
                current.setData(higherChild.getData());
                higherChild.setData(currentData);
                current = higherChild;
            } else {
                break;
            }
        } while (current.getLeftSubTree() != null || current.getRightSubTree() != null);

        return deletedNode;
    }

    private BinaryTree<T> getNewLastInsertedNode() {
        BinaryTree<T> prevLastInsertedNode = null;

        /**
         * 마지막에 삽입된 노드가 부모노드의 왼쪽 자식노드인 경우
         */
        if (this.lastInserted == this.lastInserted.getParent().getLeftSubTree()) {
            BinaryTree<T> current = this.lastInserted;
            BinaryTree<T> firstLeftSibling = null;

            while (current.getParent().getParent() != null) {
                current = current.getParent();
                firstLeftSibling = getLeftSibling(current);

                if (firstLeftSibling != null) {
                    break;
                }
            }

            // a. 부모노드 중에 왼쪽 형제노드가 있는 경우
            if (firstLeftSibling != null) {
                while (firstLeftSibling.getRightSubTree() != null) {
                    firstLeftSibling = firstLeftSibling.getRightSubTree();
                }

                prevLastInsertedNode = firstLeftSibling;
                return prevLastInsertedNode;
            }

            // b. 부모노드 중에 왼쪽 형제노드가 존재하지 않는 경우
            current = this.root;
            while (current.getRightSubTree() != null) {
                current = current.getRightSubTree();
            }

            prevLastInsertedNode = current;
            return prevLastInsertedNode;


        }

        /**
         * 마지막에 삽입된 노드가 부모노드의 오른쪽 자식노드인 경우
         */
        prevLastInsertedNode = lastInserted.getParent().getLeftSubTree();
        return prevLastInsertedNode;
    }

    private BinaryTree<T> getHigherPriorityChild(BinaryTree<T> left, BinaryTree<T> right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (this.isHigherPriority(left.getData(), right.getData())) {
            return left;
        }

        return right;
    }
}
