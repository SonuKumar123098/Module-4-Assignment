//https://course.acciojob.com/idle?question=6724980a-4f60-46df-acc1-7f0144f12959
import java.io.*;
import java.util.*;



class Main {
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int arr1[] = new int[m];
        int arr2[] = new int[n];
        for (int i = 0; i < m; i++) {
            arr1[i] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = input.nextInt();
        }
        int x = input.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.countElements(arr1, arr2, m, n, x));
    }
}

class Solution {
    public int countElements(int[] arr1, int[] arr2, int m, int n, int x) {
		HashSet<Integer>hs=new HashSet<>();
		for(int val:arr1)hs.add(val);
		int cnt=0;
		for(int val:arr2){
			if(hs.contains(x-val)) cnt++;
		}
		return cnt;
    }
}
//2nd approach using two pointers
//We initialize two pointers, one at the beginning of the first array and one at the end of the second array.
//We check if the sum of the two numbers is equal to the target. If it is, we increment the count and move both pointers.
//If the sum is less than the target, we move the pointer at the beginning of the first array.
//If the sum is greater than the target, we move the pointer at the end 
//of the second array. We return the count at the end of the function.
