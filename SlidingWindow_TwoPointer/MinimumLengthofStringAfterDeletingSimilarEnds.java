//https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/
class Solution {
    public int minimumLength(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<end){
            char first=s.charAt(start);
            char last=s.charAt(end);
            //if both char are equal then remove 
            if(first==last){
                while(start<end && s.charAt(start+1)==first) start++;
                while(start<end && s.charAt(end-1)==last) end--;
            }else break;
            start++;
            end--;
        }
        return end-start+1>0?end-start+1:0;
    }
}
