import java.util.HashMap;

class LRUCache99 {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache99(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0); // Dummy head
        this.tail = new Node(0, 0); // Dummy tail
        head.next = tail; // Initialize dummy head and tail
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node); // Remove from current position
            insert(node); // Move to front
            return node.value; // Return value
        }
        return -1; // Key not found
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key)); // Remove old node
        }
        
        if (map.size() == capacity) {
            // Remove least recently used element
            map.remove(tail.prev.key);
            remove(tail.prev);
        }
        
        Node newNode = new Node(key, value);
        insert(newNode); // Insert new node at front
        map.put(key, newNode); // Add to map
    }
}
