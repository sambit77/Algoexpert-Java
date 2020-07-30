//Time Complexity O(n log(n)) (Best & average case)
//Space Complexity O(log n)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{8,5,2,9,7,6,3};
		int[] sorted = quickSort(arr);
		System.out.println("Sorted array is "+Arrays.toString(sorted));
		
	}
	public static int[] quickSort(int[] arr)
	{

		quickSortHelper(arr,0,arr.length-1);
		return arr;
	}
	public static void quickSortHelper(int[] arr,int start,int end)
	{
		//base condition for return
		if(start>=end)
		{
			return;
		}
		//pick the start element as pivot , we can pick any element as pivot
		//and swap the first elemnt with pivot then use first index as pivot index as code is written acoordingly
		//i.e at the end of each while we swap the pivot idx with right idx in end
		//if we use last idx as pivot idx then we need to swap left idx with pivot idx at the end of while loop
		int pivot = start;
		//pick left & right pointer
		int left = start+1;
		int right = end;
		//while left does not surpass right
		while(left<= right)
		{
			//if leftIdx Element is greater than pivot element & right idx element is less than pivot element
			//then swap left & right as they are not in correct postion 
			if(arr[left]>arr[pivot] && arr[right]<arr[pivot])
			{
				
				swap(left,right,arr);

			}
			//if left Idx element is less than or equal to pivot element then this element is in its correct side with 
			//respect to pivot element
			//so move ahead by incrementing left pointer
			if(arr[left]<= arr[pivot])
			{
				left++;
			}
			//if right idx element is greater than or equal to pivot element then this element is at its 
			//correct side with respect to pivot element
			//thus go for the next element by decrementing i
			if(arr[right]>= arr[pivot])
			{
				right--;
			}
		}
		//at the end swao the pivot element with right idx
		swap(pivot,right,arr);

		//then recursively call this method for both left & right subarrays
		//for left sub array end = right -1
		//for right sub array start = right+1
		//we could do this directly but we will do a small optimisation
		/*quickSortHelper(arr,start,right-1);
		quickSortHelper(arr,right+1,end);*/


		//to achieve O(log n ) Space Complexity we will recursively go for smallest sub-array first
		//so we have to decide the smalles between left sub array & right sub array & accordingly 
		//we will decide order of recursion

		//calculate the size of both sub array by finding differnece betweeb=n endIdx & startIdx
		int leftSize = (right-1)-start;
		int rightSize = end-(right+1);

		boolean leftIsSmaller = leftSize < rightSize;

		//if left sub array is smaller then go for recursion with left subarray first then right sub array
		if(leftIsSmaller)
		{
			quickSortHelper(arr,start,right-1);
			quickSortHelper(arr,right+1,end);
		}
		//if right sub array is smaller then go for recursion with right subarray first then left sub array
		else
		{
			quickSortHelper(arr,right+1,end);
			quickSortHelper(arr,start,right-1);
		}
	}
	public static void swap(int i , int j , int[] arr)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}