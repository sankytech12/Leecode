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
public class Diapair {
		int d=0;
		int ht=0;
	}
	class Solution {
// 		   public int diameterOfBinaryTree(TreeNode root) {
// 			   return diameter(root).d;
// 		   }
// 		   public Diapair diameter(TreeNode root) {
// 			   	if(root==null) {
// 			   		return new Diapair();
// 			   	}
			   	
// 			   	Diapair ldp=diameter(root.left);
// 			   	Diapair rdp=diameter(root.right);
// 			   	Diapair sdp=new Diapair();
// 			   	sdp.ht=Math.max(ldp.ht, rdp.ht)+1;
// 			   	int dia=ldp.ht+rdp.ht;
// 			   	sdp.d=Math.max(dia, Math.max(ldp.d, rdp.d));
// 			   	return sdp;
// 		   }
        public int diameterOfBinaryTree(TreeNode root) {
		        if(root==null) {
		        	return 0;
		        }
		        int ld=diameterOfBinaryTree(root.left);
		        int rd=diameterOfBinaryTree(root.right);
		        int sd=ht(root.left)+ht(root.right);
		        return Math.max(ld, Math.max(rd, sd));
		        
		    }
		    public int ht(TreeNode nn) {
		    	if(nn==null) {
		    		return 0;
		    	}
		    	int lh=ht(nn.left);
		    	int rh=ht(nn.right);
		    	return Math.max(lh, rh)+1;
		    }
	}