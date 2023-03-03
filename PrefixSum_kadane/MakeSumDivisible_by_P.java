//https://leetcode.com/problems/make-sum-divisible-by-p/
class Solution {
    public int minSubarray(int[] nums, int p) {
        int rem=0;
        for(int x:nums){
            rem=(rem+x)%p;
        }
        if(rem==0)return 0;
        Map<Integer,Integer>hm=new HashMap<>();
        hm.put(0,-1);
        int cur=0; int res=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            cur=(cur+nums[i])%p;
            int want=(cur-rem+p)%p;
            // if(want<0)want+=p;
            res=Math.min(res,i-hm.getOrDefault(want,-nums.length));
            hm.put(cur,i);
        }
        return res<nums.length?res:-1;
    }
}
