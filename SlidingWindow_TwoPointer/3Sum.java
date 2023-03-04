//https://leetcode.com/problems/3sum/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        // if(nums[0]+nums[1]+nums[2]>0) return ans;
        int n=nums.length;
        for(int i=0;i<n-2;i++){
            int k=n-1;
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-1 && j<k;j++){
                while(k>j+1 && nums[i]+nums[j]+nums[k]>0) k--;
                if(nums[i]+nums[j]+nums[k]==0){
                    List<Integer>al=new ArrayList<>();
                    al.add(nums[i]); al.add(nums[j]);
                    al.add(nums[k]);
                    ans.add(al);
                    while(k>j+1 &&nums[i]+nums[j]+nums[k]==0)k--;
                }
            }
        }
        return ans;
    }
}
