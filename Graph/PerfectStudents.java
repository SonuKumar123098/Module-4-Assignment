//https://course.acciojob.com/idle?question=0eb7825c-c00f-4e45-a951-d27950980419
import java.io.*;
import java.util.*;
  class Edge {
      int src;
      int nbr;

      Edge(int src, int nbr) {
         this.src = src;
         this.nbr = nbr;
      }
   }
class Solution{
    public static int perfectStudents(int vtces,  ArrayList<Edge>[] graph){
       // Your code here
		boolean[]visited=new boolean[vtces];
		int res=vtces*(vtces-1)/2;
		for(int i=0;i<vtces;i++){
			if(!visited[i]){
				int cnt=dfs(graph,i,visited);
				res-=(cnt*(cnt-1)/2);
			}
		}
		return res;
   }
	private static int dfs(ArrayList<Edge>[] graph,int node,boolean[]visited){
		visited[node]=true;
		int cnt=1;
		for(Edge e:graph[node]){
			if(!visited[e.nbr]){
				cnt+=dfs(graph,e.nbr,visited);
			}
		}
		return cnt;
	}
}
			
public class Main {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int n = Integer.parseInt(br.readLine());
      int k = Integer.parseInt(br.readLine());

      int vtces = n;
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = k;
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         graph[v1].add(new Edge(v1, v2));
         graph[v2].add(new Edge(v2, v1));
      }
      System.out.println(Solution.perfectStudents(n, graph));
   }

}
