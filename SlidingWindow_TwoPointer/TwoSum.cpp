//https://leetcode.com/problems/two-sum/description/
// using hashmap
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int>m;
        for(int i=0;i<nums.size();i++)
        {
            if(m.find(target-nums[i])!=m.end()){
                auto it=m[(target-nums[i])];
                return {it,i};
            }
            m[nums[i]]=i;
        }
        return {};
    }
};
//2nd approach using two pointer ,write youself as 4 sum problems, two pointer is optimal one when array is already sorted
// other wise it takes O(n log(n)) time complexity due to sort the array
