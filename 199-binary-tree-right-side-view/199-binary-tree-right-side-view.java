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
    int max;
    public List<Integer> rightSideView(TreeNode root) {
        max=-1;
        List<Integer> ll=new ArrayList<>();
        RView(root,0,ll);
        return ll;
    }
    public void RView(TreeNode root,int curr, List<Integer> ll){
        if(root==null){
            return;
        }
        if(curr>max){
            ll.add(root.val);
            max=curr;
        }
        RView(root.right,curr+1,ll);
        RView(root.left,curr+1,ll);
    }
}