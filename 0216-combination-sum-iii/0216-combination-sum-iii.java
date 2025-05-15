class Solution {
    List<List<Integer>> result;
    int k , n ;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.result = new ArrayList<>();
        this.k = k;
        this.n = n;
        backtrack(1,0,new ArrayList<>());
        return result;
    }

    private void backtrack(int top,int sum,List<Integer> list){
        if(list.size() == k){
            if(sum == n) result.add(new ArrayList<>(list));
            return ;
        }
        for(int i = top;i<10;i++){
            if(sum + i > n) return ;
            list.add(i);
            backtrack(i+1,sum+i,list);
            list.remove(list.size()-1);
        }
    }
}