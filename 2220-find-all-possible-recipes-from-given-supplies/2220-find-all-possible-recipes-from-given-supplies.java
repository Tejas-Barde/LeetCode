class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        Set<String>[] edges = new Set[n];
        int[] indegree = new int[n];
        int i = 0;
        for(List<String> list : ingredients){
            edges[i] = new HashSet<>();
            indegree[i] = list.size();
            for(String s : list){
                edges[i].add(s);
            } 
            i++;
        }
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        for(String s : supplies) q.offer(s);
        while(!q.isEmpty()){
            String s = q.poll();
            for(i = 0;i<n;i++){
                if(edges[i].contains(s)){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        q.offer(recipes[i]);
                        result.add(recipes[i]);
                    } 
                } 
            }
        }
        return result;
    }
}