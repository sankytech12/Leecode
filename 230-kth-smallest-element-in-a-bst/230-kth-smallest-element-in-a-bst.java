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
    int ans=Integer.MIN_VALUE;
     int idx=0;
    public int kthSmallest(TreeNode root, int k) {
       
        solve(root,k);
        //System.out.print(ans);
        return ans;
    }
    public void solve(TreeNode root,int k){
        if(root==null){
            return;
        }
        solve(root.left,k); 
        idx++;
        if(idx==k){
            ans=root.val;
           // return;
        }
        solve(root.right,k);
    }
}

// int count = 0;
// int result = Integer.MIN_VALUE;

// public int kthSmallest(TreeNode root, int k) {
//     traverse(root, k);
//     return result;
// }

// public void traverse(TreeNode root, int k) {
//     if(root == null) return;
//     traverse(root.left, k);
//     count ++;
//     if(count == k) result = root.val;
//     traverse(root.right, k);       
// }