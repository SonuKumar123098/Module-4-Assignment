//https://leetcode.com/problems/count-number-of-nice-subarrays/description/
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start=-1;
        int end=0;
        int n=nums.length;
        int cnt=0;
        int first=-1;
        int last=-1;
        int odd=0;
        boolean flag=false;
        while(end<n){
            if(nums[end]%2==1)odd++;
            if((nums[end]%2)==1 && first==-1 ) first=end;
            if(last==-1 && odd==k){
                last=end;
                flag=true;
            }
            if(odd>k){
                cnt+=(end-last)*(first-start);
                start=first;
                last=end;
                odd--;
                while(first<end && nums[first+1]%2!=1){
                    first++;
                }
                first++;
            } 
           end++;
        }
        if(flag) cnt+=(end-last)*(first-start);
        return cnt;
    }
}
//2nd approach using sliding window 
class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        return subarray(nums,k)-subarray(nums,k-1);
    }
    private:
    int subarray(vector<int>&nums, int k){
        int start=0;
        int end=0;
        int cnt=0;
        while(end<nums.size()){
            k-=(nums[end]%2);
            end++;
            while(start<end && k<0){
                k+=(nums[start]%2);
                start++;
            }
            cnt+=(end-start);
        }
        return cnt;
    }
};
