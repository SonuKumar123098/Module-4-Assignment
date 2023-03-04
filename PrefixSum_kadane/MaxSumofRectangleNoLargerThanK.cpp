//https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/description/
class Solution {//binary search + prefixSum
public:
    int maxSumSubmatrix(vector<vector<int>>& matrix, int k) {
        int row=matrix.size();
        int col=matrix[0].size();
        int res=INT_MIN;
        for(int l=0;l<col;l++){
            vector<int>sums(row);
            for(int r=l;r<col;r++){
                for(int i=0;i<row;i++){
                    sums[i]+=matrix[i][r];
                }
                set<int>s={0};
                int curSum=0;
                for( int sum:sums){
                    curSum+=sum;
                    auto it=s.lower_bound(curSum-k);
                    s.insert(curSum);
                    if(it!=s.end()) res=max(res,curSum-*it);
                }
            }
        }
        return res;
    }
};
