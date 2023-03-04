//https://leetcode.com/problems/sliding-window-maximum/
//approach using deque
class Solution {//optimal approach->another approach using Dequeue
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer>dq=new LinkedList<>();
        int end=0;
        int start=0;
        int[]ans=new int[n-k+1];
        while(end<k){
            //check if element present in deque is small or larger than end 
           // element and remove smaller than end element
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[end])
            dq.removeLast();
            dq.addLast(end);
            end++;
        }
        //add first maximum window in ans
        ans[start]=nums[dq.peekFirst()];
        while(end<n){
            while(dq.size()>0 && nums[dq.peekLast()]<nums[end]) dq.removeLast();
            dq.addLast(end);
            end++;
            //check start positioin is within the range of window or not
            //if not then increment start position
            while(start+k<end) start++;
            //check first element in deque is in the range of window or not
            // if not then remove first element index
            while(start>dq.peekFirst()) dq.removeFirst();
            //maximum value is at start index is first element in deque
            // store in ans array
            ans[start]=nums[dq.peekFirst()];
        }
        //this is our final answer 
        return ans;
    }
}
//2nd approach using stack and next greater element
class Solution {//optimal approach
    int[] nextGreaterOnRightIdx(int[] nums)
    {
        int n=nums.length;
        int ans[]=new int[n];
        Stack<Integer>st=new Stack();
        for(int i=n-1;i>=0;i--)
        {
           while(!st.isEmpty() && nums[st.peek()]<=nums[i])
               st.pop();
           if(st.isEmpty()) ans[i]=n;
           else ans[i]=st.peek();
           st.push(i);
        }
        return ans;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        int nGE[]=nextGreaterOnRightIdx(nums);
        int j=0;
        for(int i=0;i<=n-k;i++)
        {
            //if j is laging behind i
            if(j<i) j=i;
            //j will be within window
            while(nGE[j]<i+k)  j=nGE[j];
            // j will be pointion window maximum
            ans[i]=nums[j];
        }
        return ans;
    }
}
