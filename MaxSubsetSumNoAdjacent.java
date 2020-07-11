import java.util.*;
class A
{

	public static void main(String[] args) 
	{
		int[] arr =  new int[]{7,10,12,7,9,14};
		int result = getMaxSumNoAdjacent(arr);
		System.out.println("Maximun Sum of No adjacent elements taken is "+ result);
		int result2 = getMaxSumNoAdjacentSpaceOptimal(arr);
		System.out.println("Maximun Sum of No adjacent elements taken is (Space Optimised)"+ result2);
		
		
	}

	//Time Complexity O(n) | Space Complexity O(n) == n -> input array length
	public static int getMaxSumNoAdjacent(int[] arr)
	{
		if(arr.length == 0)
		{
			return 0;
		}
		if(arr.length == 1)
		{
			return arr[0];
		}
		int[] maxSums = new int[arr.length];
		maxSums[0]=arr[0];
		maxSums[1]= Math.max(arr[0],arr[1]);
		for(int i = 2 ; i < maxSums.length ; i++)
		{
			maxSums[i] = Math.max(maxSums[i-1],maxSums[i-2]+arr[i]);
		}
		return maxSums[maxSums.length-1];
	}

	//Time Complexity O(n) |Space Complexity O(1)
	public static int getMaxSumNoAdjacentSpaceOptimal(int[] arr)
	{
		if(arr.length == 0)
		{
			return 0;
		}
		if(arr.length == 1)
		{
			return arr[0];
		}
		int second = arr[0];
		int first  = Math.max(arr[0],arr[1]);
		int current = 0;

		for(int i = 2 ; i <  arr.length ; i++)
		{
           current = Math.max(first,second+arr[i]);
       
           second = first;
           first = current;
		}
		return current;
	}
}
