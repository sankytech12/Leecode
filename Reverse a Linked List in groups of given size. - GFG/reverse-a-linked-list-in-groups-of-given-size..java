//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class ReverseInSize
{
    static Node head;
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a1 = sc.nextInt();
            Node head = new Node(a1);
            Node tail = head;
            for(int i = 1; i < n; i++)
            {
                int a = sc.nextInt();
                // addToTheLast(new Node(a));
                tail.next = new Node(a);
                tail =tail.next;
            }
            
            int k = sc.nextInt();
            Solution ob = new Solution();
            Node res = ob.reverse(head, k);
            printList(res);
            System.out.println();
        }
    }
    
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
}


// } Driver Code Ends


/*node class of the linked list

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

*/

class Solution
{
    public static Node reverse(Node node, int k)
    {
        //Your code here
        // if(node==null || k==1) return node;
        // Node dummy=new Node(0);
        // dummy.next=node;
        // Node prev=dummy,curr=dummy,nex=dummy;
        // int count=0;
        // while(curr.next!=null){
        //     curr=curr.next;
        //     count++;
        // }
        //  while(count>=k){
        //     curr=prev.next;
        //     nex=curr.next;
        //     for(int i=1;i<k;i++){
        //         curr.next=nex.next;
        //         nex.next=prev.next;
        //         prev.next=nex;
        //         nex=curr.next;
        //     }
        //     prev=curr;
        //     count-=k;
        // }
        // curr=prev.next;
        // Node p=null;
        // while(curr!=null){
        //     Node nex=curr.next;
        //     curr.next=p;
        //     prev=curr;
        //     curr=nex;
        // }
        // return dummy.next;
        Stack<Node> st=new Stack<>();
        Node dummy=new Node(0);
        Node temp=dummy;
        Node curr=node;
        while(curr!=null){
            Node nn=new Node(curr.data);
            st.push(nn);
            if(st.size()==k){
                while(!st.isEmpty()){
                    dummy.next=st.pop();
                    dummy=dummy.next;
                }
            }
            curr=curr.next;
        }
        while(!st.isEmpty()){
            dummy.next=st.pop();
            dummy=dummy.next;
        }
        return temp.next;
    }
    
}

