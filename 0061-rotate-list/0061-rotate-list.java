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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0) return head;
        ListNode curr=head;
        int c=1;
        while(curr.next!=null){
            curr=curr.next;
            c++;
        }
        curr.next=head;
        k=c-(k%c);
        while(k>0){
            curr=curr.next;
            k--;
        }
        head=curr.next;
        curr.next=null;
        return head;
    }
}