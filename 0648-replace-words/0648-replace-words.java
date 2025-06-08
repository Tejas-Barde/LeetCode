class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Set<String> set = new HashSet();
        int minl = Integer.MAX_VALUE;
        int maxl = Integer.MIN_VALUE;
        for(String dict : dictionary){
            set.add(dict);
            minl = Math.min(dict.length(),minl);
            maxl = Math.max(dict.length(),maxl);
        }
        // String[] words = ;
        StringBuilder result = new StringBuilder();
        for(String word : sentence.split(" ")){
            String root = ""; 
            for(int i = minl;i<=Math.min(maxl,word.length());i++){
                root = word.substring(0,i);
                if(set.contains(root)) break;
                root = ""; 
            }
            if(root == "") result.append(" "+word);
            else result.append(" "+root);
        }
        return result.substring(1).toString();
    }   
}