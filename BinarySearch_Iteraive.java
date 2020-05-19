//Time Complexity O(log n) | Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{12,30,45,67,89,90,435,23}; //given array should be in sorted order
		int target = 435; //element to find

		int index = binarySearch(arr,target);
		System.out.println("Given Arrray"+Arrays.toString(arr)); //prints the input array
		System.out.println(target+" is found at "+index);
	}
	public static int binarySearch(int[] arr, int target)
	{
		return binarySearchHelper(arr,target,0,arr.length-1);
	}
	public static int binarySearchHelper(int[] arr,int target,int begin,int end)
	{
		int mid = 0;

		while(begin <= end)
		{
			mid = (begin+end)/2;
			if(arr[mid] == target)
			{
               return mid;  // element found at mid index
			}
			else if(arr[mid] > target)
			{
				end = mid - 1;  //element is in left halv
			}
			else
			{
				begin = mid + 1;  // element in roght halve
			}
		}

		return -1;  //element is not found 


	}
}
