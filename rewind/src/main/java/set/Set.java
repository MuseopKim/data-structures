package set;

import doublylinkedlist.DoublyLinkedList;
import doublylinkedlist.DoublyLinkedList.Node;
import hashtable.HashTable;
import hashtable.HashTable.HashData;

/**
 * FIXME
 * 구현한 HashTable을 활용하기 위해
 * 데이터 타입을 Integer로 한정하여 구현 함
 */
public class Set {

    private HashTable<Integer> hashTable = new HashTable<>(10);

    public void add(int data) {
        if (this.hashTable.get(data) == null) {
            this.hashTable.put(data, data);
        }
    }

    public boolean contains(int data) {
        return this.hashTable.get(data) != null;
    }

    public void remove(int data) {
        this.hashTable.remove(data);
    }

    public void clear() {
        for (int i = 0; i < hashTable.size(); i++) {
            this.hashTable.getBuckets()[i].clear();
        }
    }

    public boolean isEmpty() {
        for (int i = 0; i < hashTable.size(); i++) {
            if (this.hashTable.getBuckets()[i].size() != 0) {
                return false;
            }
        }

        return true;
    }

    public void printAll() {
        for (int i = 0; i < this.hashTable.size(); i++) {
            DoublyLinkedList<HashData<Integer>> currentNode = this.hashTable.getBuckets()[i];

            for (int j = 0; j < currentNode.size(); j++) {
                Node<HashData<Integer>> node = currentNode.getNodeAt(j);
                System.out.println(node.getData().getValue());
            }
        }
    }
}
