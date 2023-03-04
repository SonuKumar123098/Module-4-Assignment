//https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {// good approach
    int solve(String s,int n){
        int start=0,end=0;
        int ans=0;
        int freq[]=new int[128];
        while(end<n){
            //1. expansion
            freq[s.charAt(end)]++;
            //2. contraction
            while(start<end && freq[s.charAt(end)]==2){
                    freq[s.charAt(start)]--;
                start++;
            }
            //3.calculation
            end++;
            ans=Math.max(ans,end-start);
        }
        return ans;
    }
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        return solve(s,n);
    }
}
