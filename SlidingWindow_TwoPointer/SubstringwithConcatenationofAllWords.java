//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int m=s.length();
        int n=words.length;
        int wordLen=words[0].length();
        List<Integer>ans=new ArrayList<>();
        Map<String,Integer>ideal=new HashMap<>();
        for(String cur:words) ideal.put(cur,ideal.getOrDefault(cur,0)+1);
        Map<String,Integer>freq=new HashMap<>();
        for(int i=0;i<wordLen;i++){
            int start=i;
            int end=i;
            freq.clear();
            while(end<=(m-wordLen)){
                String expectedWord=s.substring(end,end+wordLen);
                end+=wordLen;
                //check expectedWord is present in ideal map or not
                //if not then substring within the range start and end is not   
                //our answer so we will searching for new answer from end point
                if(ideal.containsKey(expectedWord)){
                    freq.put(expectedWord,freq.getOrDefault(expectedWord,0)+1);
                }else{
                    start=end; 
                    freq.clear();
                }
                while(start<end && ideal.get(expectedWord)<freq.get(expectedWord)){
                    String first=s.substring(start,start+wordLen);
                    freq.put(first,freq.get(first)-1);
                    start+=wordLen;
                }
                if(end-start==wordLen*n) ans.add(start);
            }
        }
        return ans;
    }
}
