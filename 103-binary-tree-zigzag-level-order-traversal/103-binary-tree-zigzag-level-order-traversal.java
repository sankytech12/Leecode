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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
	    	 List<Integer> ll=new ArrayList<Integer>();
	    	 int level=0;
	    	 LinkedList<TreeNode> queue=new LinkedList<>();
	    	 LinkedList<TreeNode> help=new LinkedList<>();
        if(root==null){
            return ans;
        }
	    	 queue.add(root);
	    	 while(!queue.isEmpty()) {
	    		 TreeNode rv=queue.remove();
	    		 ll.add(rv.val);
	    		 if(rv.left!=null) {
	    			 help.add(rv.left);
	    		 }if(rv.right!=null) {
	    			 help.add(rv.right);
	    		 }
	    		 if(queue.isEmpty()) {
	    			 queue=help;
	    			 help=new LinkedList<>();
	    			 if(level%2!=0) {
	    				 Collections.reverse(ll);
	    				 ans.add(ll);
	    			 }else ans.add(ll);
	    			 ll=new ArrayList<Integer>();
	    			 level++;
	    		 }
	    	 }
	    	 return ans;
	    }
}