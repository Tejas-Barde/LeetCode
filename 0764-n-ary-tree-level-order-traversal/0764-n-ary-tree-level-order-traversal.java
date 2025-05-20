/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if(root == null) return new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node curr = que.poll();
                if(curr == null) continue;
                for(Node node : curr.children) que.offer(node);
                temp.add(curr.val);
            }
            result.add(temp);
        }
        return result;
    }
}