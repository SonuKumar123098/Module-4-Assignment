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

// same approach java implementation
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        //Write code here
		int res=Integer.MIN_VALUE;
		int row=matrix.length; int col=matrix[0].length;
		for(int l=0;l<col;l++){
			int[]sums=new int[row];
			for(int r=l;r<col;r++){
				for(int i=0;i<row;i++){
					sums[i]+=matrix[i][r];
				}
				res=Math.max(res,maxSum(sums,k));
			}
		}
		return res;
    }
	private int maxSum(int[]sums,int k){
		TreeSet<Integer>bst=new TreeSet<>();
		bst.add(0);
		int ans=Integer.MIN_VALUE;
		int curSum=0;
		for(int sum:sums){
			curSum+=sum;
			Integer res=bst.ceiling(curSum-k);
			if(res!=null) ans=Math.max(ans,curSum-res);
			bst.add(curSum);
		}
		return ans;
	}
}
