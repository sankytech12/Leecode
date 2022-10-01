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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode build(int []inorder,int ilo,int ihi,int []postorder,int plo,int phi){
        if(ilo>ihi){
            return null;
        }
        TreeNode nn=new TreeNode(postorder[phi]);
        int i=search(inorder,postorder[phi]);
        int noele=i-ilo;
        
        nn.left=build(inorder,ilo,i-1,postorder,plo,plo+noele-1);
         nn.right=build(inorder,i+1,ihi,postorder,plo+noele,phi-1);
        return nn;
         
    }
    public int search(int []inorder,int n){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==n){
                return i;
            }
        }
        return -1;
    }
}