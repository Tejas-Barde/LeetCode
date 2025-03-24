class Trie {
    Node head ;
    private class Node{
        Node[] next;
        boolean isTerminal;

        public Node(){
            next = new Node[26];
            Arrays.fill(next,null);
            isTerminal = false;
        }
    }
    
    public Trie() {
        head = new Node();
    }
    
    public void insert(String word) {
        Node ptr = head;
        for(char c : word.toCharArray()){
            if(ptr.next[c-'a'] == null){
                ptr.next[c-'a'] = new Node();
            }
            ptr = ptr.next[c-'a'];
        }
        ptr.isTerminal = true;
    }
    
    public boolean search(String word) {
        if(head == null) return false;
        Node ptr = head;
        for(char c : word.toCharArray()){
            if(ptr.next[c-'a'] == null) return false;
            ptr = ptr.next[c-'a'];
        }
        return ptr.isTerminal;
    }
    
    public boolean startsWith(String prefix) {
        Node ptr = head;
        for(char c : prefix.toCharArray()){
            if(ptr.next[c-'a'] == null) return false;
            ptr = ptr.next[c-'a'];
        }
        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */