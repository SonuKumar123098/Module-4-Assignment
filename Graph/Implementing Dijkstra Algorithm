//https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        // Code here
        vector<int> rec(V,-1);
        // vector<int>vis(V,0);
        priority_queue<pair<int,int>,vector<pair<int,int>>, greater<pair<int,int>>>q;
        q.push({0,S});
        while(q.size())
        {
            pair<int,int>p=q.top();
            q.pop();
            int node=p.second;
            int dist=p.first;
            if(rec[node]!=-1)continue;
            // vis[node]=1;
            rec[node]=dist;
            for( auto newnode:adj[node])
            {
                if(rec[newnode[0]]==-1)
                {
                    q.push({dist+newnode[1],newnode[0]});
                }
            }
        }
        return rec;
    }
