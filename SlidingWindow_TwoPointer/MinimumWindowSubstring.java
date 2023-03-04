//https://leetcode.com/problems/minimum-window-substring/
class Solution {
    String solve(String s,int[]bfreq,int k){
		int ans=Integer.MAX_VALUE;
		int ansStart=-1;
		int ansEnd=-1;
		int start=0,end=0;
		int n=s.length();
		int unique=0;
		int[] afreq=new int[128];
		while(end<n){
			//1.expansion
			afreq[s.charAt(end)]++;
			if(afreq[s.charAt(end)]==bfreq[s.charAt(end)])
				unique++;
			end++;
			//2.contraction
			while(start<end && unique==k){
				if(afreq[s.charAt(start)]==bfreq[s.charAt(start)]) 
					unique--;
				afreq[s.charAt(start)]--;
				//3.calculation
				if(ans>(end-start)){
					ansStart=start;
					ansEnd=end;
                    ans=end-start;
				}
				start++;
			}
		}
		if(ansStart==-1) return "";
		return s.substring(ansStart,ansEnd);
	}
    public String minWindow(String s, String t) {
       int bfreq[]=new int[128];
		int distinct=0;
		int n=t.length();
		for(int i=0;i<n;i++){
			char c=t.charAt(i);
			bfreq[c]++;
			if(bfreq[c]==1) distinct++;
		}
		return solve(s,bfreq,distinct);
    }
}
