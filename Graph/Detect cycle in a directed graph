//https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean visited[]=new boolean[V];
        boolean path[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(isContainsCycle(visited,path,adj,i)) return true;
            }
        }
        return false;
    }
    private boolean isContainsCycle(boolean visited[],boolean path[],ArrayList<ArrayList<Integer>> adj,int node){
        visited[node]=true;
        path[node]=true;
        for(int vertex:adj.get(node)){
            if(!visited[vertex]){
                if(isContainsCycle(visited,path,adj,vertex)) return true;
            }else if(path[vertex]) return true;
        }
        path[node]=false;
        return false;
    }
}
