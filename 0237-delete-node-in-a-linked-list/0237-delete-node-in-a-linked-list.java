/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nn=node.next;
        node.val=nn.val;
        node.next=node.next.next;
        nn.next=null;
        
    }
}