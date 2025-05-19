/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode slow = head;

        for(ListNode fast = head; fast != null && fast.next != null;){
            slow = slow.next;
            fast = fast.next.next;
        }
        while(slow != null){
            stack.push(slow);
            slow = slow.next;
        }
        slow = head;
        ListNode next = null;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            next = slow.next;
            slow.next = node;
            slow = node.next = next;
        }
        if(slow != null){
            if(slow == slow.next) slow.next = null;
            else slow.next.next = null;
        };
    }
}