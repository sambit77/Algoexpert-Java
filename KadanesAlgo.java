//Given an array compute  the maximum sum that you can generate by taking a subarray of given array
//|Maximum Sub array Sum
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{3,5,-9,1,3,-2,3,4,7,2,-9,6,3,1,-5,4};
		int result = kadane(arr);
		System.out.println("Maximum subarray sum is "+result );

	}
	public static int kadane(int[] arr)
	{
		int maxEndingHere = arr[0];
		int maxSofar = arr[0];

		for(int i = 1 ; i < arr.length ; i++)
		{
			maxEndingHere = Math.max(arr[i],maxEndingHere+arr[i]);
			maxSofar = Math.max(maxSofar,maxEndingHere);
		}
		return maxSofar;
	}
}