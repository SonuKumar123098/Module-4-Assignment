//https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
class Pair{
	int x;
	int y;
	Pair(int x ,int y){
		this.x=x;
		this.y=y;
	}
}
class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int m=grid.length;
		int n=grid[0].length;
		int arr[][]=new int[m][n];
		Queue<Pair>q=new LinkedList<>();
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1) q.add(new Pair(i,j));
			}
		}
		int dist=0;
		int dir[][]={{0,1},{1,0},{-1,0},{0,-1}};
		while(q.size()>0){
			int size=q.size();
			dist++;
			for(int i=0;i<size;i++){
				Pair p=q.remove();
				for(int j=0;j<4;j++){
					int X=p.x+dir[j][0];
					int Y=p.y+dir[j][1];
					if(isValid(grid,X,Y,m,n)&&arr[X][Y]==0){
						q.add(new Pair(X,Y));
							arr[X][Y]=dist;
					}
				}
			}
		}
		return arr;
    }
    private  boolean isValid(int[][]grid,int x,int y,int m,int n){
	  if(x<0||x>=m||y<0||y>=n|| grid[x][y]!=0) return false;
	  return true;
  }
}
