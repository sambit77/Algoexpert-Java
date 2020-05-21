//Time Complexity O(n^3) | Space Complexity O(1)
//Find the triplets from array which adds to give target duplicate elements are not allowed 
//Array also contains unique elements 
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{12,3,1,2,-6,5,-8,6};
		int target = 0;
		System.out.println("given array "+Arrays.toString(arr));
		System.out.println("given target "+target);
		threeSum(arr,target);
	}
	public static void threeSum(int[] arr,int target)
	{

              
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = 0 ; j < arr.length ; j++)
			{
				for(int k = 0 ; k < arr.length ; k++)
				{
					if(i != j && j != k && i  != k  && arr[i]+arr[j]+arr[k] == target)
					{
						System.out.println(arr[i]+" "+arr[j]+" "+arr[k]+"="+target);
					}
				}
			}
		}
	}
}