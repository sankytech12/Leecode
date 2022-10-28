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
    public boolean isPalindrome(ListNode head) {
        // Stack<Integer> st=new Stack<>();
        // ListNode temp=head;
        // while(temp!=null){
        //     st.push(temp.val);
        //     temp=temp.next;
        // }
        // temp=head;
        // while(!st.isEmpty()){
        //     if(st.peek()!=temp.val){
        //         return false;
        //     }
        //     st.pop();
        //     temp=temp.next;
        // }
        // return true;
        if(head==null || head.next==null) return true;
        ListNode fast=head,slow=head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=reverse(slow.next);
        slow=slow.next;
        ListNode temp=head;
        while(slow!=null){
            if(slow.val!=temp.val) return false;
            slow=slow.next;
            temp=temp.next;
        }
        return true;
        
    }
    public ListNode reverse(ListNode node){
        ListNode prev=null;
        while(node!=null){
            ListNode ahead=node.next;
            node.next=prev;
            prev=node;
            node=ahead;
        }
        return prev;
    }
}