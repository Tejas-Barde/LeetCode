class Solution {
    public String clearStars(String s) {
        int n = s.length();
        boolean[] remove = new boolean[n];
        Stack<Integer>[] map = new Stack[26];
        for(int i = 0;i<26;i++) map[i] = new Stack<>();
        PriorityQueue<Character> minHeap = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(c == '*'){
                char small = minHeap.poll();
                remove[map[small-'a'].pop()] = true;
                remove[i] = true;
            }
            else{
                minHeap.offer(c);
                map[c-'a'].push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            if(remove[i]) continue;
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}