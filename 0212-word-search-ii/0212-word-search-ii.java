class Solution {
    char[][] board;

    private class Node{
        Node[] next = new Node[26];
        String word ;
        boolean isTerminal ;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Node head = new Node();
        this.board = board;
        for(String s : words){
            Node ptr = head;
            for(char c : s.toCharArray()){
                if(ptr.next[c-'a'] == null) ptr.next[c-'a'] = new Node();
                ptr = ptr.next[c-'a'];
            }
            ptr.word = s;
            ptr.isTerminal = true;
        }
        List<String> result = new ArrayList<>();
        for(int i =0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                findWord(head,i,j,result);   
            }
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    private void findWord(Node root,int i ,int j,List<String> result){
        if(root.isTerminal) result.add(root.word);
        if(i < 0 || j < 0|| i == board.length || j==board[0].length||board[i][j] == '.') return ;
        int index = board[i][j]-'a';
        if(root.next[index] == null) return ;
        char c = board[i][j];
        board[i][j] = '.';
        findWord(root.next[index],i-1,j,result);
        findWord(root.next[index],i+1,j,result);
        findWord(root.next[index],i,j-1,result);
        findWord(root.next[index],i,j+1,result);
        board[i][j] = c;
    }
}