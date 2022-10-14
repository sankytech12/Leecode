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
    public class Pair{
        int num;
        TreeNode nn;
        Pair(TreeNode nn,int num){
            this.nn=nn;
            this.num=num;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=0;
        LinkedList<Pair> qq=new LinkedList<>();
        qq.add(new Pair(root,0));
        while(!qq.isEmpty()){
            int n=qq.size();
            int first=0,second=0;
            int mini=qq.peekFirst().num;
            for(int i=0;i<n;i++){
                Pair rv=qq.remove();
                int curr=rv.num-mini;
                if(i==0) first=curr;
                if(i==n-1) second=curr;
                if(rv.nn.left!=null){
                    qq.add(new Pair(rv.nn.left,curr*2+1));
                }
                if(rv.nn.right!=null){
                    qq.add(new Pair(rv.nn.right,curr*2+2));
                }
            }
            ans=Math.max(ans,second-first+1);
        }
        return ans;
    }
}