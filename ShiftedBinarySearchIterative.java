//Time Complexity O(log n) |Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{45,61,71,72,73,0,1,21,33,45};
		int target = 33;
		int idx = search(arr,target);
		System.out.println(target+" is present in "+idx+" of array");
		
	}
	public static int search(int[] arr, int target)
	{
		return shiftedBinarySearch(arr,target,0,arr.length-1);
	}
	public static int shiftedBinarySearch(int[] arr,int target ,int left,int right)
	{
		//modified Binary Search
		while(left<=right)
		{
			int mid = (left+right)/2;
			if(arr[mid]==target)
			{
				return mid;
			}
		else if(arr[mid]>target)
		{
			//that means target sould be to the left of mid index if it would have been sorted array
			//but it is shifted so not sorted

			//check if left halve is sorted or not && target is greater than arr[left]
			//i.e target falls in left sub halve

 			if(arr[left]<arr[mid] && target >= arr[left])
 			{
 				//search in left sub halve
 				right = mid-1;
 			}
 			//target falls in right subhalve
 			else
 			{
 				//search in rght sub halve
 				left = mid+1;
 			}
 			
		}

		else //(arr[mid]<target)
 		{
 			//targetb will fall in right sub halve if it would have been sorted
 			//nut it is shifted

 			//check if right sub halve is sorted and arr[right] is greater tah equal to target
 			//target falls in rights sub halve
 			if(arr[mid]<arr[right] && arr[right]>=target)
 			{
 					//search in right subhalve
 					left = mid + 1;
 			}
 			else
 			{
 					//search in left sub halve
 					right = mid-1;
 			}
 		}
		}
		


		return -1;
	}
}