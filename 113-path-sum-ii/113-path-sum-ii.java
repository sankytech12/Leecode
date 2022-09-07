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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        List<Integer> curr=new ArrayList<Integer>();
        pathsUm(root,targetSum,list,curr);
        return list;
    }
    public void pathsUm(TreeNode root,int t,List<List<Integer>> list,List<Integer> curr){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null&&t-root.val==0){
            curr.add(root.val);
            list.add(new ArrayList<Integer>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        curr.add(root.val);
        pathsUm(root.left,t-root.val,list,curr);
        pathsUm(root.right,t-root.val,list,curr);
        curr.remove(curr.size()-1);
    }
}