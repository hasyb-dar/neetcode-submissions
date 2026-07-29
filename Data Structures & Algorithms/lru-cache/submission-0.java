class LRUCache {
     class Node {
        int key;
        int value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private int size;

    // key -> previous node
    private HashMap<Integer, Node> map;

    private Node dummy;
    private Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        map = new HashMap<>();

        dummy = new Node(-1, -1);
        tail = dummy;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        moveToTail(key);

        return tail.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {

            moveToTail(key);
            tail.value = value;
            return;
        }

        // cache full
        if (size == capacity) {

            Node lru = removeNext(dummy);

            map.remove(lru.key);

            size--;
        }

        Node node = new Node(key, value);

        addToTail(node);

        size++;
    }
     private Node removeNext(Node prev) {

        Node node = prev.next;

        if (node == tail) {
            tail = prev;
        }

        prev.next = node.next;

        // update hashmap for next node
        if (node.next != null) {
            map.put(node.next.key, prev);
        }

        return node;
    }

    // add node at tail
    private void addToTail(Node node) {

        node.next = null;

        map.put(node.key, tail);

        tail.next = node;
        tail = node;
    }

    // move node to tail
    private void moveToTail(int key) {

        Node prev = map.get(key);
        Node node = removeNext(prev);

        addToTail(node);
    }

    
}
