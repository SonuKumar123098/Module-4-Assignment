//https://leetcode.com/problems/find-pivot-index/
class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        int total=0;
        int leftSum=0;
        for(int i=0;i<n;i++) total+=nums[i];
        for(int i=0;i<n;i++){
            int rightSum=total-leftSum-nums[i];
            if(leftSum==rightSum) return i;
            leftSum+=nums[i];
        }
        return -1;
    }
}
