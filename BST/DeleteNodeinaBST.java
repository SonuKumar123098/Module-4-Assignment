//https://leetcode.com/problems/delete-node-in-a-bst/
class Tree {
    // Function to delete a node from BST.
    public static Node deleteNode(Node root, int val) {
        // code here.
        if(root==null) return root;
		if(root.data<val) root.right= deleteNode(root.right,val);
		else if(root.data>val) root.left= deleteNode(root.left,val);
		else{
			if(root.left==null && root.right==null)return null;
			else if(root.left==null && root.right!=null) return root.right;
			else if(root.left!=null && root.right==null) return root.left;
			else{//we reach where root have value is val and  two child 
				Node rightMin=root.right;
				while(rightMin.left!=null)rightMin=rightMin.left;
				root.data=rightMin.data;// swaping the both value
				rightMin.data=val;
				root.right= deleteNode(root.right,val);
			}
		}
		return root;
    }
}
