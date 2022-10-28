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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //ListNode temp=dummy;
        ListNode fast=dummy;
        ListNode start=dummy;
        for(int i=0;i<n;i++){
            fast=fast.next;
        }
        while(fast!=null && fast.next!=null){
             start=start.next;
            fast=fast.next;
        }
        start.next=start.next.next;
        return dummy.next;
    }
}