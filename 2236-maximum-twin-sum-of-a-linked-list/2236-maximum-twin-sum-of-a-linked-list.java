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
    public int pairSum(ListNode head) {
        ListNode slow = head;
        for(ListNode fast = head;fast != null && fast.next != null;){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode nhead = reverse(slow);
        int result = 0;
        while(nhead != null){
            result = Math.max(result,nhead.val + head.val);
            nhead = nhead.next;
            head = head.next;
        }
        return result;
    }

    private ListNode reverse(ListNode head){
        if(head.next == null) return head;
        ListNode prev = null;
        ListNode ptr = head;
        ListNode next = null;
        while(ptr != null){
            next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
        }
        return prev;
    }
}
