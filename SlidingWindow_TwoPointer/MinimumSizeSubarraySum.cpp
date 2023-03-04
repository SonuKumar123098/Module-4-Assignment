//https://leetcode.com/problems/minimum-size-subarray-sum/description/
//optimal approach using sliding window
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int n=nums.size();
        int start=0,end=0;
        int ans=INT_MAX;
        int sum=0;
        while(end<n){
            //expansion
            sum+=nums[end];
            end++;
            //contraction
            while(start<end && sum>=target){
                //calculation
                ans=min(ans,end-start);
                sum-=nums[start];
                start++;
            }
        }
        if(ans!=INT_MAX) return ans;
        return 0;
    }
};
//2nd approach using binary search
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
