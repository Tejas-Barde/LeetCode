class Solution {
    private List<Integer> result = new ArrayList<>();
    private int n;
    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        backtrack(0);
        return this.result;
    }

    private void backtrack(int num){
        if(num > n) return;
        if(num != 0) result.add(num);
        for(int i = 0;i<=9;i++){
            if(num == 0 && i == 0) continue;
            backtrack(10*num+i);
        }
    }
}