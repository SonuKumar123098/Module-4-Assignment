//https://leetcode.com/problems/4sum/
class Solution {//good approach
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<>();
        int n=nums.length;
        for(int a=0;a<n-3;a++){
            if(a!=0 && nums[a]==nums[a-1]) continue;
            long i=target-nums[a];
            for(int b=a+1;b<n-2;b++){
                if(b>a+1 && nums[b]==nums[b-1]) continue;
                int d=n-1; long j=i-nums[b];
                for(int c=b+1;c<n-1 && c<d;c++){
                    long k=j-nums[c];
                    while(d>c+1 && nums[d]>k) d--;
                    if(nums[d]==k){
                        List<Integer>res=new ArrayList<>();
                        res.add(nums[a]);
                        res.add(nums[b]);
                        res.add(nums[c]);
                        res.add(nums[d]);
                        ans.add(res);
                    }
                    while((d>c+1 && nums[d]==k)) d--;
                }
            }
        }
        return ans;
    }
}
