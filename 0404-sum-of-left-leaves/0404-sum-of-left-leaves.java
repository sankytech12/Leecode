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
    public int sumOfLeftLeaves(TreeNode root) {
        boolean isLeft=false;
        Stack<TreeNode> st=new Stack<>();
        int ans=0;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            if(curr.left==null && curr.right==null && isLeft){
                ans+=curr.val;
                isLeft=false;
            }
            if(curr.right!=null){
                st.push(curr.right);
                isLeft=false;
            }
            if(curr.left!=null){
                st.push(curr.left);
                isLeft=true;
            }
        }
        return ans;
    }
   
}