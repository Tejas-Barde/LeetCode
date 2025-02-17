class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[n*2 - 1];
        backtrack(n,0,new boolean[n],result);
        return result;
    }

    private boolean backtrack(int n ,int top , boolean[] visited,int[] result){

        while(top < result.length && result[top] != 0) top++;
        if(top == result.length) return true;
        for(int i = n;i>0;i--){
            if(visited[i-1]) continue;
            if(i != 1 && top + i >= result.length) continue;
            if(i == 1){
                result[top] = 1;
                visited[i-1] = true;
                if(backtrack(n,top+1,visited,result)) return true;
                visited[i-1] = false;
                result[top] = 0;
            }
            else if(result[i+top] == 0){
                visited[i-1] = true;
                result[top] = result[i+top] = i;
                if(backtrack(n,top+1,visited,result)) return true;
                visited[i-1] = false;
                result[i+top] = result[top] = 0;
            }
        }
        return false;
    }
}