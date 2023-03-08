//https://leetcode.com/problems/validate-binary-search-tree/description/
class Solution {
    TreeNode prev=null;
    boolean solve(TreeNode root){
        if(root!=null){
            if(!solve(root.left)) return false;
            if(prev!=null && root.val<= prev.val) return false;
            prev=root;
            return solve(root.right);
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return solve(root);
    }
}
// acciojob portal
class Solution{
    boolean isBST(Node node){
       // Your Code Here
     return  validateBST(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
	private boolean validateBST(Node root,int start,int end){
		if(root==null)return true;
		if(root.data>=end ||root.data<=start)return false;
		 boolean res=validateBST(root.left,start,root.data);
		res=res&&validateBST(root.right,root.data,end);
		return res;
	}
}
