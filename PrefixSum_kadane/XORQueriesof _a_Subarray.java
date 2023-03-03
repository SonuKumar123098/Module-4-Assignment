//https://leetcode.com/problems/xor-queries-of-a-subarray/
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
         for(int i=1;i<arr.length;i++){
				arr[i]=arr[i-1]^arr[i];
			}
		 int[] ans=new int[queries.length];
		 for(int i=0;i<queries.length;i++){
			 int a=queries[i][0]-1>=0?arr[queries[i][0]-1]:0;
			 ans[i]=arr[queries[i][1]]^a;
		 }
		 return ans;
    }
}
