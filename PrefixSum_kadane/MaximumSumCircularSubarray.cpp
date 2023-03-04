//https://leetcode.com/problems/maximum-sum-circular-subarray/
class Solution {
public:
    int maxSubarraySumCircular(vector<int>& nums) {
        int n=nums.size();
        int maxsum=nums[0];
        int minsum=nums[0];
        int maxcur=0;
        int mincur=0;
        int arrsum=0;
        for(int i=0;i<n;i++)
        {
            arrsum+=nums[i];
            maxcur+=nums[i];
            maxsum=max(maxcur,maxsum);
            if(maxcur<0) maxcur=0;
            mincur+=nums[i];
            minsum=min(minsum,mincur);
            if(mincur>0) mincur=0;
        }
        if(minsum==arrsum) return maxsum;
        return max(arrsum-minsum,maxsum);
    }
};
