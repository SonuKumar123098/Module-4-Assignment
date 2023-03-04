//https://leetcode.com/problems/valid-triangle-number/description/
//optimal approach
class Solution {//O(n^3)->O(n^2 log n)->O(n^2)
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<n-2;i++){
            int k=i+2;
            for(int j=i+1;j<n-1 && nums[i]!=0;j++){
               while(k<n && nums[i]+nums[j]>nums[k])
               k++;
               count+=k-j-1;
            }
        }
        return count;
    }
    
}
//suboptimal approach
class Solution {//O(n^3)->O(n^2 log n)->
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        int end=n-1;
        int start=0;
        for(int i=0;i<n-2;i++){
            int k=i+1;
            for(int j=i+1;j<n-1 && nums[i]!=0;j++){
               k= search(nums,k,n-1,nums[i]+nums[j]);
               count+=k-j;
            }
        }
        return count;
    }
    private int search(int[] nums,int start,int end,int x){
        while(start<end){
            int mid=start+(end-start+1)/2;
            if(x<=nums[mid]) end=mid-1;
            else start=mid;
        }
        return start;
    }
}
//less optimal approach
class Solution {//O(n^3)->O(n^2 log n)->
    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        int end=n-1;
        int start=0;
        for(int i=0;i<n-2;i++){
            int k=i+1;
            for(int j=i+1;j<n-1;j++){
               k= search(nums,k,n-1,nums[i]+nums[j]);
               count+=k-j>0?k-j:0;
            }
        }
        return count;
    }
    private int search(int[] nums,int start,int end,int x){
        while(start<end){
            int mid=start+(end-start+1)/2;
            if(x<=nums[mid]) end=mid-1;
            else start=mid;
        }
        return start;
    }
}
