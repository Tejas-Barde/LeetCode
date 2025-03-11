class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<String> q = new LinkedList<>();
        boolean[] visited = new boolean[bank.length];
        q.offer(startGene);
        int result = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0;j<size;j++){
                String curr = q.poll(); 
                if(curr.equals(endGene)) return result;

                for(int i = 0;i<bank.length;i++){
                    if(visited[i] ) continue;
                    if(!bank[i].equals(curr) && isDiffOne(bank[i],curr)){
                        visited[i] = true;
                        q.offer(bank[i]);
                    } 
                }
            }
            result++;
        }
        return -1;
    }

    private boolean isDiffOne(String s1, String s2){
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();
        int diff = 0;
        for(int i = 0;i<a1.length;i++){
            if(a1[i] != a2[i]){
                if(++diff > 1) return false;
            } 
        }
        return true;
    }
}