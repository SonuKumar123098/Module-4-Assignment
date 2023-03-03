//https://leetcode.com/problems/product-of-array-except-self/description/
class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int n=nums.size();
            vector<int>rightproduct(n,1);
            vector<int>leftproduct(n,1);
            for(int i=n-2;i>=0;i--)
            {
                    rightproduct[i]=rightproduct[i+1]*nums[i+1];
            }
            for(int i=1;i<n;i++)
            {
                    leftproduct[i]=leftproduct[i-1]*nums[i-1];
                    rightproduct[i]=rightproduct[i]*leftproduct[i];
            }
            return rightproduct;
           
    }
};
