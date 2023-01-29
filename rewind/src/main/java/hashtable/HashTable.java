package hashtable;

import doublylinkedlist.DoublyLinkedList;
import doublylinkedlist.DoublyLinkedList.Node;

public class HashTable<T> {

    private DoublyLinkedList<HashData<T>>[] buckets;

    public HashTable(int size) {
        this.buckets = new DoublyLinkedList[size];

        for (int i = 0; i < size; i++) {
            buckets[i] = new DoublyLinkedList<>();
        }
    }

    public int getHashKey(int key) {
        return key % buckets.length;
    }

    public void put(int key, T value) {
        int hashKey = this.getHashKey(key);
        DoublyLinkedList<HashData<T>> buckets = this.buckets[hashKey];
        buckets.insertAt(0, new HashData<>(key, value));
    }

    public HashData<T> get(int key) {
        int hashKey = getHashKey(key);
        DoublyLinkedList<HashData<T>> buckets = this.buckets[hashKey];
        Node<HashData<T>> currentNode = buckets.getFirst();
        while (currentNode != null) {
            if (currentNode.getData().key == key) {
                return currentNode.getData();
            }

            currentNode = currentNode.getNext();
        }

        return null;
    }

    public void remove(int key) {
        int hashKey = getHashKey(key);
        DoublyLinkedList<HashData<T>> hashDataList = buckets[hashKey];

        for (int i = 0; i < hashDataList.size(); i++) {
            Node<HashData<T>>  currentNode = hashDataList.getNodeAt(i);
            if (currentNode.getData().key == key) {
                hashDataList.deleteAt(i);
                break;
            }
        }
    }

    public int size() {
        return this.buckets.length;
    }

    public DoublyLinkedList<HashData<T>>[] getBuckets() {
        return this.buckets;
    }

    public static class HashData<T> {

        private int key;
        private T value;

        public HashData(int key, T value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public T getValue() {
            return value;
        }
    }
}
