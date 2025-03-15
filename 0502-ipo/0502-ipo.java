class Solution {

    private class Project{
        int capital;
        int profit;

        public Project(int capital, int profit){
            this.capital = capital;
            this.profit = profit;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<Project> projects = new ArrayList<>();
        for(int i = 0;i<profits.length;i++){
            projects.add(new Project(capital[i],profits[i]));
        }    
        Collections.sort(projects,(a,b)->Integer.compare(a.capital,b.capital));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        while((k--) != 0){
            while(i<profits.length && projects.get(i).capital <= w){
                maxHeap.add(projects.get(i++).profit);
            }
            if(maxHeap.isEmpty()) return w;
            w += maxHeap.poll();
        }
        return w;
    }
}