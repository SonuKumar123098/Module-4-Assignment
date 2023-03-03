//https://course.acciojob.com/idle?question=06b725f6-b68c-4f4a-ae0f-db18ce5ee4d4
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int maximumSum(int[] A, int[][] ops) {
		int n=A.length;
            int freq[]=new int[n];
		for(int i=0;i<ops.length;i++){
			freq[ops[i][0]]++;
			if(ops[i][1]!=n-1)freq[ops[i][1]+1]--;
		}
		for(int i=1;i<n;i++) freq[i]+=freq[i-1];
		Arrays.sort(freq);
		Arrays.sort(A);
		int ans=0;
		int mod=(int)1e9+7;
		for(int i=0;i<n;i++){
			ans+=(freq[i]*A[i])%mod;
			ans%=mod;
		}
		return ans%mod;
    }
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
          String inputLine1[] = br.readLine().trim().split(" ");
          ops[i][0]=Integer.parseInt(inputLine1[0]);
          ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
	}
}

