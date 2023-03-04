//https://leetcode.com/problems/subarray-product-less-than-k/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return numberOfSubarray(nums,k);
    }
    private int numberOfSubarray(int[] nums,int k){
        int start=0;
        int end=0;
        int n=nums.length;
        int cnt=0;
        int prod=1;
        while(end<n){
            //expand window
            prod*=nums[end];
            end++;
            //shrink window
            while(start<end && prod>=k){
                prod/=nums[start];
                start++;
            }
            //calculation
            cnt+=(end-start);
        }
        return cnt;
    }
}
