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
    public int deepestLeavesSum(TreeNode root) {
        int ans=0;
        LinkedList<TreeNode> qq=new LinkedList<>();
        qq.add(root);
        while(!qq.isEmpty()){
            int s=qq.size();
            ans=0;
            while(s-->0){
                TreeNode curr=qq.remove();
                if(curr.left!=null) qq.add(curr.left);
                if(curr.right!=null) qq.add(curr.right);
                ans+=curr.val;
            }
        }
        return ans;
    }
}