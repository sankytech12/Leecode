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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        ListNode dummy=new ListNode();
        ListNode temp=dummy;
        Stack<ListNode> st=new Stack<>();
        while(curr!=null){
            ListNode nn=new ListNode();
            nn.val=curr.val;
            st.push(nn);
            while(st.size()==k){
                while(!st.isEmpty()){
                    dummy.next=st.pop();
                    dummy=dummy.next;
                }
                
            }
            curr=curr.next;
        }
        Collections.reverse(st);
        while(!st.isEmpty()){
                    dummy.next=st.pop();
                    dummy=dummy.next;
                }
        head=temp.next;
        return head;
    }
}