//https://course.acciojob.com/idle?question=71f9e64f-56ec-499b-95d0-da312adf139c
import java.util.*;

class Solution {
    public boolean RangeCheck(int[][] intervals, int a, int b) {
        // Write your code here
          int[]freq=new int[52];
		for(int[]x:intervals){
			freq[x[0]]++;
			freq[x[1]+1]--;
		}
		for(int i=1;i<52;i++)freq[i]=freq[i-1]+freq[i];
		for(int value=a;value<=b;value++){
			if(freq[value]<=0) return false;
		}
		return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int[][] intervals = new int[n][2];
        for(int i = 0; i < n; i++) {
            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
	    Solution Obj = new Solution();
        if(Obj.RangeCheck(intervals, a, b))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
