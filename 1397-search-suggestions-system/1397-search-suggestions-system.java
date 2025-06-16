class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int n = products.length;
        StringBuilder sb = new StringBuilder();
        List<List<String>> result = new ArrayList<>();
        for(char c : searchWord.toCharArray()){
            sb.append(c);
            String search = sb.toString();
            int start = 0,end = n-1; 
            while(start<end){
                int mid = start + (end-start)/2;
                if(products[mid].compareTo(search) < 0) start = mid+1; 
                else end = mid;
            }
            List<String> res = new ArrayList<>();
            while(start < n && products[start].startsWith(search) && res.size() != 3){
                res.add(products[start]);
                start++;
            }
            result.add(res);
        }
        return result;
    }
}