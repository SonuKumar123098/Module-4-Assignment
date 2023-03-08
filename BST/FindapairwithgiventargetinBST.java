//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
//https://practice.geeksforgeeks.org/problems/find-a-pair-with-given-target-in-bst/1
//https://course.acciojob.com/idle?question=0dd4bc90-7cd3-45f8-bd73-81ada8c52c67
class Pair{
    Node node;
    int state;
    Pair(Node node,int state){
        this.node=node;
        this.state=state;
    }
}
class Solution
{
    // root : the root Node of the given BST
    // target : the target sum
    public int isPairPresent(Node root, int target)
    {
        // Write your code here
        Stack<Pair>st1=new Stack();
		Stack<Pair>st2=new Stack();
		st1.push(new Pair(root,1));
		st2.push(new Pair(root,1));
		Node left=getNextFromNormal(st1);
		Node right=getNextFromReverse(st2);
// 		boolean flag=true;// if such pair is not present
		while(left.data<right.data){
			if(left.data+right.data<target)
               left=getNextFromNormal(st1);
			else if(left.data+right.data>target)
				right=getNextFromReverse(st2);
			else{
				// System.out.println(left.data+" "+right.data);
				left=getNextFromNormal(st1);
				right=getNextFromReverse(st2);
				return 1;
			} 
		}
// 		if(flag) System.out.println(-1);
       return 0;
        
    }
    Node getNextFromNormal(Stack<Pair>st){
		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				top.state++;
				if(top.node.left!=null)st.push(new Pair(top.node.left,1));
			}else if(top.state==2){
				top.state++;
				if(top.node.right!=null)st.push(new Pair(top.node.right,1));
				return top.node;
			}else st.pop();
		}
		return null;
	}
	Node getNextFromReverse(Stack<Pair>st){
		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				top.state++;
				if(top.node.right!=null)st.push(new Pair(top.node.right,1));
			}else if(top.state==2){
				top.state++;
				if(top.node.left!=null)st.push(new Pair(top.node.left,1));
				return top.node;
			}else st.pop();
		}
		return null;
	}
}
//acciojob portal
import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node constructBST(int[] arr, int start, int end, Node root) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;

        if (root == null)
            root = new Node(arr[mid]);

        root.left = constructBST(arr, start, mid - 1, root.left);
        root.right = constructBST(arr, mid + 1, end, root.right);

        return root;

    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        Arrays.sort(arr);
        Node root = null;
        BinarySearchTree bst = new BinarySearchTree();
        root = bst.constructBST(arr, 0, n - 1, root);

        Accio A = new Accio();
        A.targetSum(root, target);

        sc.close();
    }
}
class Pair{
	Node node;
	int state;
	Pair(Node node,int state){
		this.node=node;
		this.state=state;
	}
}
class Accio {
    public void targetSum(Node root, int tar)
    {
        // your code here
		Stack<Pair>st1=new Stack();
		Stack<Pair>st2=new Stack();
		st1.push(new Pair(root,1));
		st2.push(new Pair(root,1));
		Node left=getNextFromNormal(st1);
		Node right=getNextFromReverse(st2);
		boolean flag=true;// if such pair is not present
		while(left.data<right.data){
			if(left.data+right.data<tar)
               left=getNextFromNormal(st1);
			else if(left.data+right.data>tar)
				right=getNextFromReverse(st2);
			else{
				System.out.println(left.data+" "+right.data);
				left=getNextFromNormal(st1);
				right=getNextFromReverse(st2);
				flag=false;
			} 
		}
		if(flag) System.out.println(-1);
    }
	Node getNextFromNormal(Stack<Pair>st){
		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				top.state++;
				if(top.node.left!=null)st.push(new Pair(top.node.left,1));
			}else if(top.state==2){
				top.state++;
				if(top.node.right!=null)st.push(new Pair(top.node.right,1));
				return top.node;
			}else st.pop();
		}
		return null;
	}
	Node getNextFromReverse(Stack<Pair>st){
		while(st.size()>0){
			Pair top=st.peek();
			if(top.state==1){
				top.state++;
				if(top.node.right!=null)st.push(new Pair(top.node.right,1));
			}else if(top.state==2){
				top.state++;
				if(top.node.left!=null)st.push(new Pair(top.node.left,1));
				return top.node;
			}else st.pop();
		}
		return null;
	}
}
