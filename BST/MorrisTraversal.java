//https://leetcode.com/problems/binary-tree-preorder-traversal/
class Solution {//morris traversal
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>ans=new ArrayList<>();
        while(root!=null){
            if(root.left==null){
                ans.add(root.val);
                root=root.right;
                }else{
                    TreeNode cur=root.left;
                    while(cur.right!=null && cur.right!=root)
                        cur=cur.right;
                    if(cur.right==root){
                        cur.right=null;
                        root=root.right;
                    }else{
                        ans.add(root.val);
                        cur.right=root;
                        root=root.left;
                    }
                }
        }
        return ans;
    }
}
//https://leetcode.com/problems/binary-tree-inorder-traversal/
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //morris traversal
        List<Integer>ans=new ArrayList<>();
        while(root!=null){
            if(root.left==null){
                ans.add(root.val);
                root=root.right;
            }else{
                TreeNode cur=root.left;
                while(cur.right!=null && cur.right!=root){
                    cur=cur.right;
                }
                if(cur.right==root){
                    cur.right=null;
                    ans.add(root.val);
                    root=root.right;
                }else{
                    cur.right=root;
                    root=root.left;
                }
            }
        }
        return ans;
    }
}
