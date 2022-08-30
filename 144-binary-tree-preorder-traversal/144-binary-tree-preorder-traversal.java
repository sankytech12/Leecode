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
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> ll =new ArrayList<Integer>();
        if(root==null){
            return ll;
        }
	    		Stack<TreeNode> st=new Stack<>(); 
	    		st.push(root);
	    		while(!st.isEmpty()) {
	    			TreeNode rv=st.pop();
	    			ll.add(rv.val);
	    			if(rv.right!=null) {
	    				st.add(rv.right);
	    			}if(rv.left!=null) {
	    				st.push(rv.left);
	    			}
	    		}
	    		return ll;
    }
}