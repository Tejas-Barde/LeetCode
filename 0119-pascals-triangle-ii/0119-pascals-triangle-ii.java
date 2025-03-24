class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        for(int i = 0;i<rowIndex;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1;j<i+1;j++){
                temp.add(result.get(j) + result.get(j-1));
            }
            temp.add(1);
            result = temp;
        }
        return result;
    }
}