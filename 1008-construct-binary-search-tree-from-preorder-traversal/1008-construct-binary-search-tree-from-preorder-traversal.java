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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        if(n==0){
            return null;
        }
        TreeNode nn=new TreeNode(preorder[0]);
        int root=preorder[0];
        for(int i=1;i<preorder.length;i++){
            nn=AddBst(nn,preorder[i]);
        }
        return nn;
    }
    public TreeNode AddBst(TreeNode nn,int i){
        if(nn==null){
            return new TreeNode(i);
        }
        if(i<nn.val){
            nn.left=AddBst(nn.left,i);
        }else{
            nn.right=AddBst(nn.right,i);
        }
        return nn;
    }
}