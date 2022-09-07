/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
         List<Integer> ll=new ArrayList<Integer>();
	        // Stack<TreeNode> st=new Stack<>();
	        // TreeNode node=root;
	        // while(true) {
	        // 	if(node!=null) {
	        // 		st.push(node);
	        // 		node=node.left;
	        // 	}
	        // 	else {
	        // 		if(st.isEmpty()) break;
	        // 		 node =st.pop();
	        // 		ll.add(node.val);
	        // 		node=node.right;
	        // 	}
	        // }
	        // return ll;
        if(root==null){
            return ll;
        }
        add(root,ll);
        return ll;
    }
    public void add(TreeNode root, List<Integer> ll){
        if(root==null){
            return;
        }
        add(root.left,ll);
        ll.add(root.val);
        add(root.right,ll);
    }
}