//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
class Solution {
public://best solution
    int maxProfit(vector<int>& prices) {
        int profit=0;
        int n=prices.size();
        int maxAtRight=prices[n-1];
        for(int i=n-2;i>=0;i--){
            profit=max(profit,maxAtRight-prices[i]);
            maxAtRight=max(maxAtRight,prices[i]);
        }
        return profit;
    }
};
