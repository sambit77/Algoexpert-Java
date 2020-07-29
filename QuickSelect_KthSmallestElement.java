//find the kth smallest element in array
//same concept can be used to find kth largest elemen in array
//Time Complexity O(n) (best & average case) O(n^2) worst case
//Space Compelxity O(1)
//bit of quicksort partioning concept is used 
//as aplying pivot element partioning pivot element gets its coorect position insorted rray like wise we can find
//the posion of kth smallest i. element at k-1 th index in srted version array
//and for that we dont need to sort the array
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{8,5,2,9,7,6,3};
		int k = 3;
		

		int result = kthSmallest(arr,k);
		System.out.println(k+"th smalest element in array is "+result);
		
	}
	public static int kthSmallest(int[] arr,int k)
	{
		//kth smallest element is found at k-1 in sorted version of the array
		int position = k-1;
		return kthSmallestHelper(arr,position,0,arr.length-1);
	}
	public static int kthSmallestHelper(int[] arr,int position,int start,int end)
	{
		while(true)
		{
			//choosing first elemnt as pivot element
		   int pivot = start;	
		   int left = start+1;
		   int right = end;
		   while(left<=right)
		   {
		   	if(arr[left] > arr[pivot] && arr[right] < arr[pivot])
		   	{
		   		swap(left,right,arr);
		   	}
		   	if(arr[left]<=arr[pivot])
		   	{
		   		left++;
		   	}
		   	if(arr[right]>=arr[pivot])
		   	{
		   		right--;
		   	}
		   }
		   swap(pivot,right,arr);
		   if(right==position)
		   {
		   	return arr[right];
		   }
		   else if(right < position)
		   {
		     start = right+1;
		   }
		   else
		   {
		   	end = right-1;
		   }
		}
       
	}
	public static void swap(int i , int j , int[] arr)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}