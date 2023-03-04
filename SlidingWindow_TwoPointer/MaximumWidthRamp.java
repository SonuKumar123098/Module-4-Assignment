//https://leetcode.com/problems/maximum-width-ramp/description/
class Solution { //two pointer->monotonic stack
    public int maxWidthRamp(int[] nums) {
       int n=nums.length;
    //    Stack<Integer>st=new Stack<>();
       int []rmax=new int[n];
		rmax[n-1]=nums[n-1];
		for(int i=n-2;i>=0;i--){
			rmax[i]=Math.max(rmax[i+1],nums[i]);
		}
		int i=0;int j=1;
		int ans=0;
		while(j<n){
            // if(i<n-1 && j<=i)j=i+1;
			if(nums[i]<=rmax[j]){
				ans=Math.max(ans,j-i);
				j++;
			}else i++;
		}
		return ans;
    }
}
