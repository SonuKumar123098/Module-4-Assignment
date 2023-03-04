//https://course.acciojob.com/idle?question=7e2f8ed3-69ab-4d0c-ad56-467a99335a5b
import java.util.*;

class Solution {
    public ArrayList<Integer> FindIndices(String a, String b) {
        //Write your code here
          int j=0; int n=b.length();
		ArrayList<Integer>ans=new ArrayList<>();
		for(int i=0;i<a.length();i++){
			char A=a.charAt(i);
			char B=b.charAt(j);
			if(A==B){
				j++;
				if(j==n){
					ans.add((i-j+2));
						j=0;
				}
			}else j=0;
		}
		if(ans.size()==0)ans.add(-1);
		return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
	    Solution Obj = new Solution();
        ArrayList<Integer> ans = Obj.FindIndices(a, b);
        for(int x : ans)
            System.out.print(x + " ");
    }
}
