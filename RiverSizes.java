import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		 ArrayList<Integer> sizes = new ArrayList<Integer>();
	  int[][] matrix = new int[][]{{1,0,0,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
	  boolean[][] visited = new boolean[matrix.length][matrix[0].length];

	     for(int i = 0 ; i < matrix.length ; i++)
	     {
	     	for(int j = 0 ; j < matrix[i].length ; j++)
	     	{
	     		if( visited[i][j])
	     		{
	     			continue;
	     		
	     		}
	     			traverse(i,j,visited,matrix,sizes);
	     	}
	     }	
         //print the river sizes
	     for(int size : sizes)
	     {
	     	System.out.print(size+" ");
	     }
	}
	public static void traverse(int i , int j , boolean[][] visited,int[][] matrix,ArrayList<Integer> sizes)
	{
		int currentSize = 0;
		Queue<int[]> nodesToExplore = new LinkedList<int[]>();
		nodesToExplore.add(new int[]{i,j});
        int[] currentNode = new int[2];
        int x;
        int y;
		while(!nodesToExplore.isEmpty())
		{
          currentNode = nodesToExplore.poll();
          x = currentNode[0];
          y=currentNode[1];

          if(visited[x][y])
          {
          	continue;
          }
          visited[x][y] = true;
          if(matrix[x][y]== 0)
          {
          	continue;
          }
          currentSize = currentSize + 1;
          ArrayList<int[]> unvisitedNeighbors = getUnVisitedNeighbors(x,y,visited,matrix);
          for(int[] neigbor : unvisitedNeighbors)
          {
          	nodesToExplore.add(neigbor);
          }


		}
		if(currentSize > 0)
		{
			sizes.add(currentSize);
		}
	}

	public static ArrayList<int[]> getUnVisitedNeighbors(int i , int j ,boolean[][] visited,int[][] matrix)
	{
		ArrayList<int[]> unvisitedNeighbors = new ArrayList<int[]>();
		if(i > 0 && (! visited[i-1][j]))
		{
			unvisitedNeighbors.add(new int[]{i-1,j});
		}
		if(j > 0 && (! visited[i][j-1]))
		{
			unvisitedNeighbors.add(new int[]{i,j-1});
		}
		if( i < matrix.length-1 && (!visited[i+1][j]))
		{
			unvisitedNeighbors.add(new int[]{i+1,j});
		}
		if(j < matrix[0].length-1 && ( !visited[i][j+1]))
		{
			unvisitedNeighbors.add(new int[]{i,j+1});
		}
		return unvisitedNeighbors;

	}
}