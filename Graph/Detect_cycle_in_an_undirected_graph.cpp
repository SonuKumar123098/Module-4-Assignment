//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
class Solution {
  public:
    // Function to detect cycle in an undirected graph.
    bool isCycle(int V, vector<int> adj[]) {
        // Code here
        vector<int>visited(V,0);
		for(int i=0;i<V;i++){
			if(!visited[i]){
				if(cycle(i,adj,visited,-1)) return 1;
			}
		}
		return 0;
    }
    bool cycle(int v,vector<int>adj[],vector<int>&visited,int parent){
	 visited[v]=1;
	 for(int node:adj[v]){
		 if(!visited[node]){
			 if(cycle(node,adj,visited,v))return 1;
		 }
			 else if(visited[node] and node!=parent) return 1;
	 }
	 return 0;
 }
};
