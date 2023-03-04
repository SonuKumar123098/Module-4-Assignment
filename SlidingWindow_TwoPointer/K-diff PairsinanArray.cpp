//https://leetcode.com/problems/k-diff-pairs-in-an-array/description/
class Solution {
public:// two pointer approach optimal approach->HashMap
    int findPairs(vector<int>& nums, int k) {
        int cnt=0;
       unordered_map<int,int>m;
       for(int i:nums){
           m[i]++;
       }
       for(auto it:m){
           if((k==0 && it.second>1)|| (k>0 && m.count(it.first+k))) cnt++;
       }
       return cnt;
    }
};
//2nd approach 2 pointer
class Solution {
public:// two pointer approach optimal approach
    int findPairs(vector<int>& nums, int k) {
        sort(nums.begin(),nums.end());
        int n=nums.size();
        int i=0,j=1;
        int count=0;
        while(i<n and j<n)
        {
            int diff=nums[j]-nums[i];
            if(diff==k and i!=j and(i==0 or (nums[j]!=nums[j-1] ))) { 
                count++;
                j++;
                i++; 
            }
            else if(diff<k) j++;
            else i++;
        }
        return count;
    }
};
