class LRUCache {
    Map<Integer,Node> map ;
    int capacity;
    Node head;
    Node tail;
    private class Node{
        int key;
        int val;
        Node next = null;
        Node prev = null;
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToTail(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            moveToTail(node);
            return ;
        }
        Node newNode = new Node(key,value);
        map.put(key,newNode);
        if(head == null) head = tail = newNode;
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        if(map.size() > capacity){
            map.remove(head.key);
            head = head.next;
            if(head != null) head.prev = null;
        }
    }

    private void moveToTail(Node node){
        if(node == tail) return ;

        if(node == head){
            head = head.next;
            if(head != null) head.prev = null;
        }
        else{
            if(node.prev != null) node.prev.next = node.next;
            if(node.next != null) node.next.prev = node.prev;
        }
        tail.next = node;
        node.prev = tail;
        node.next = null;
        tail = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */