//search an element in the given sorted matrix and return its coordinate
//if the element is not present return -1,-1
//Time Complexity O(m+n) m = row length n = col length
//Space Compelxity O(1)
class A
{
	public static void main(String[] args) 
	{
		//it is a soretd matrix that is
		//Every row elements are in ascending order
		//Every column elements are in asceding order
		int[][] matrix = new int[][]{{1,4,7,12,15,1000},
	                             {2,5,19,31,32,1001},
	                             {3,8,24,33,35,1002},
	                             {40,41,42,44,45,1003},
	                             {49,100,103,106,128,1004}};

	    int target = 44;

	    int[] coordinate = getLocation(matrix,target);
	    System.out.println("the target location");
	    System.out.println("row no "+coordinate[0]);
	    System.out.println("column no "+coordinate[1]);

		
	}
	public static int[] getLocation(int[][] arr,int target)
	{
		int row =0;
		int col = arr[0].length-1;
		while(row < arr.length && col >= 0)
		{
			if(arr[row][col] > target)
			{
				col--;
			}
			else if(arr[row][col] < target)
			{
				row++;
			}
			else
			{
				return new int[]{row,col};
			}

		}
		return new int[]{-1,-1};
	}
}