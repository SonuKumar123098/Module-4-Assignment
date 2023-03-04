//https://practice.geeksforgeeks.org/problems/maximum-consecutive-ones/1
class Solution {
    public static int longestOnes(int n, int[] nums, int k) {
        // code here
        return maxOnes(nums,k);
    }
    private static int maxOnes(int[] nums,int k){
        int start=0;
        int end=0;
        int n=nums.length;
        int res=0;
        int zeros=0;
        while(end<n){
            //expand window
            if(nums[end]==0) zeros++;
            end++;
            //shrink window
            while(start<end && zeros>k){
                if(nums[start]==0) zeros--;
                start++;
            }
            //calculation
            res=Math.max(res,end-start);
        }
        return res;
    }
}
        
