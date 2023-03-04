//https://leetcode.com/problems/boats-to-save-people/
class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int cnt=0;
        Arrays.sort(people);
        int n =people.length;
        int i=0;int j=n-1;
        while(i<=j){
            if(people[i]+people[j]<=limit){
                i++;
                j--;
                cnt++;
            }else{
                j--; cnt++;
            }
        }
        return cnt;
    }
}
