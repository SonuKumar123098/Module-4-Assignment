//https://leetcode.com/problems/max-number-of-k-sum-pairs/
class Solution {//two pointer approach
    public int maxOperations(int[] nums, int k) {
        int cnt=0;
		Arrays.sort(nums);
		int n=nums.length;
		int j=n-1;
		for(int i=0;i<n && i<j;i++){
			while(j>i+1 && nums[i]+nums[j]>k)j--;
			if(nums[i]+nums[j]==k){
				j--; 
				cnt++;
			} 
		}
		return cnt;
    }
}
