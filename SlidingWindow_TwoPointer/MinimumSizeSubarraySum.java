//https://leetcode.com/problems/minimum-size-subarray-sum/
class Solution {//using sliding window optimal-> binary search
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int start=0,end=n;
        while(start<end){
            int m=start+(end-start)/2;
            if(exist(m,target,nums)) end=m;
            else start=m+1;
        }
        return exist(start,target,nums)==true?start:0;
    }
    private boolean exist(int size,int target,int[] nums){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(i>=size)sum-=nums[i-size];
            if(sum>=target) return true;
        }
        return false;
    }
}
