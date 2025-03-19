class WordDictionary {
    private class Node{
        Node[] next;
        boolean isTerminal;
        public Node(){
            next = new Node[26];
            Arrays.fill(next,null);
            isTerminal = false;
        }
    }
    Node head;
    public WordDictionary() {
        head = new Node();
    }
    
    public void addWord(String word) {
        Node ptr = head;
        for(int i = 0;i<word.length();i++){
            int index = word.charAt(i)-'a';
            if(ptr.next[index] == null) ptr.next[index] = new Node();
            ptr = ptr.next[index];
        }
        ptr.isTerminal = true;
    }
    
    public boolean search(String word) {
        return search(head,word,0);
    }

    private boolean search(Node root,String word,int top){
        if(top == word.length()) return root.isTerminal;
        boolean result = false;
        if(word.charAt(top) == '.'){
            for(Node node : root.next){
                if(node != null){
                    if(search(node,word,top+1)) return true;
                }
            }
        }
        else{
            int index = word.charAt(top)-'a';
            if(root.next[index] == null) return false;
            result = search(root.next[index],word,top+1);
        }
        return result;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */