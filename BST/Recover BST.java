//https://course.acciojob.com/idle?question=5c814944-2552-47b2-999d-e85df0cba97f
import java.util.Scanner;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static TreeNode a,b;
    public static void recoverTree(TreeNode root) {
        //Write code here
		a=null;
		b=null;
		prev=null;
		solve(root);
		if(a!=null)
		{
			int k=a.val;
		    a.val=b.val;
		    b.val=k;
		}
    }
	static TreeNode prev=null;
  private static void solve(TreeNode root){
	  if(root==null)return;
	  solve(root.left);
	  if(prev!=null){
		  if(prev.val>root.val){
			  if(a==null) {
				  a=prev;
				  b=root;
			  }
			  else b=root;
		  }
	  }
	  prev=root;
	  solve(root.right);
  }
    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);
        recoverTree(root);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
