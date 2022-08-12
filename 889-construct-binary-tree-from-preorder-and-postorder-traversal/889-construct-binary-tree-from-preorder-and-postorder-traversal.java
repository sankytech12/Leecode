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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder,0,preorder.length-1,postorder,0,postorder.length-1);
    }
    public TreeNode construct(int[] preorder,int prelo,int prehi,int []postorder,int polo,int pohi){
        if(prelo>prehi){
            return null;
        }
          TreeNode nn=new TreeNode(preorder[prelo]);
        if(prelo==prehi){
            return nn;
        }
        int i=search(postorder,polo,pohi,preorder[prelo+1]);
        int lele=i-polo+1;
      
        nn.left=construct(preorder,prelo+1,prelo+lele,postorder,polo,i);
        nn.right=construct(preorder,prelo+lele+1,prehi,postorder,i+1,pohi-1);
        return nn;
    }
    public int search(int []postorder,int polo,int pohi,int n){
        for(int i=0;i<postorder.length;i++){
            if(postorder[i]==n){
                return i;
            }
        }
        return -1;
    }
    
}