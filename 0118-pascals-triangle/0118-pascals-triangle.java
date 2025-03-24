class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            if(i == 0){
                result.add(new ArrayList<>());
                result.get(0).add(1);
            } 
            else{
                List<Integer> temp = new ArrayList<>();
                for(int j = 0;j<=i;j++){
                    int l = 0,r = 0;
                    if(j-1>=0) l = result.get(i-1).get(j-1);
                    if(j<i) r = result.get(i-1).get(j);
                    temp.add(l+r);
                }
                result.add(temp);
            }
        }
        return result;
    }
}