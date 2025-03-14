class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int result = 0;
        boolean[] visited = new boolean[wordList.size()];
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        while(!q.isEmpty()){
            result++;
            int size = q.size();
            for(int j = 0;j<size;j++){
                String curr = q.poll();
                if(curr.equals(endWord))return result;
                for(int i = 0;i<wordList.size();i++){
                    if(!visited[i] && isDiffOne(wordList.get(i),curr)){
                        visited[i] = true;
                        q.offer(wordList.get(i));
                    } 
                }
            }
        }
        return 0;
    }

    private boolean isDiffOne(String a, String b){
        int diff = 0;
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i) != b.charAt(i)){
                if(++diff > 1) return false;
            }
        }
        return true;
    }
}