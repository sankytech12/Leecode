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
    public boolean isSubtree(TreeNode root, TreeNode t) {
        if(root==null) return t==null;
        if(isSame(root,t)) return true;
        return isSubtree(root.left,t) || isSubtree(root.right,t);
        
    }
    boolean isSame(TreeNode s,TreeNode t){
        if(s==null && t==null) return true;
        if(s==null || t==null) return false;
        if(s.val!=t.val) return false;
        boolean l=isSame(s.left,t.left);
        boolean r=isSame(s.right,t.right);
        return l&&r;
    }
}
