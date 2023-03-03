//kahn's algorithm topological sort
//https://leetcode.com/problems/course-schedule-ii/description/
//https://course.acciojob.com/idle?question=6f9356f8-63d7-41b3-9967-0bcaf5d2e8b8
public int[] findOrder(int numCourses, int[][] prerequisites) {
        int []indegree=new int[numCourses];
        int idx=0;
        int[]order=new int[numCourses];
        ArrayList<Integer>[]adj=new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++) adj[i]=new ArrayList<>();
        for(var x:prerequisites) {
            adj[x[1]].add(x[0]);
            indegree[x[0]]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)q.add(i);
        }
        //bfs
        while(q.size()>0){
            int node=q.remove();
            order[idx]=node;
            idx++;
            for(int vtces:adj[node]){
                indegree[vtces]--;
                if(indegree[vtces]==0){
                    q.add(vtces);
                }
            }
        }
        if(idx<numCourses) return new int[0];
        return order;
    }
