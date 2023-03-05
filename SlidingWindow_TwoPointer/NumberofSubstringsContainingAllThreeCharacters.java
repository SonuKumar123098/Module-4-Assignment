//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
class Solution {//using sliding window
    public int numberOfSubstrings(String s) {
        int[]freq=new int[3];
        int cnt=0;
        int left=0; 
        int n=s.length();
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++;
            while(left<i && freq[0]>0 && freq[1]>0 && freq[2]>0){
                cnt+=n-i;
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return cnt;
    }
}
