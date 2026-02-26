package systemdesign;

import java.util.HashMap;
import java.util.Map;

/**
 * Combine HashMap with DoublyLinkedList if not allowed to use Doubly Linked List
 * head <-> most recent ... least recent <-> tail
 * even add or update, it's considered as most recently used
 */
public class LRUCacheII<K, V> {

    private class Node {
        K key;
        V value;
        Node prev;
        Node next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<K, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCacheII(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        Node node = map.get(key);
        if (node == null) return null;

        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            moveToHead(node);
        } else {
            if (map.size() == capacity) {
                Node lru = removeTail();
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private Node removeTail() {
        Node node = tail.prev;
        removeNode(node);
        return node;
    }
}