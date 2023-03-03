//https://practice.geeksforgeeks.org/problems/hamiltonian-path2522/1
class Solution 
{ 
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        // code here
        ArrayList<Integer>[]adj=new ArrayList[N];
        for(int i=0;i<N;i++)adj[i]=new ArrayList<>();
        for(var e:Edges){
            adj[e.get(0)-1].add(e.get(1)-1);
            adj[e.get(1)-1].add(e.get(0)-1);
        }
        boolean visited[]=new boolean[N];
        ArrayList<Integer>path=new ArrayList<>();
        for(int i=0;i<N;i++){
            if(!visited[i]){
                if(hamiltonianPath(adj,visited,path,i)) return true;
            }
        }
        return false;
    }
    private boolean hamiltonianPath(ArrayList<Integer>[]adj,boolean 
    visited[],ArrayList<Integer>path,int node){
        if(path.size()==adj.length-1){
            return true;
        }
        visited[node]=true;
        path.add(node);
        for(int nbr:adj[node]){
            if(!visited[nbr]){
                if(hamiltonianPath(adj,visited,path,nbr)) return true;
            }
        }
        visited[node]=false;
        path.remove(path.size()-1);
        return false;
    }
} 
