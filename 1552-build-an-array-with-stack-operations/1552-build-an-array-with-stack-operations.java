class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int top = 0;
        for(int i = 1;i<=n;i++){
            if(top == target.length) break;
            if(target[top] == i){
                result.add("Push");
                top++;
            }
            else{
                result.add("Push");
                result.add("Pop");
            }
        }
        return result;
    }
}