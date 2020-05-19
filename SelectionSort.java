import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
		System.out.println("Unsorted Array"+ Arrays.toString(arr));
		//This i s also an in place sortibg algorithm no extra space required
		selectionSort(arr);
		System.out.println("Sorted Array"+Arrays.toString(arr));
	}
	public static void selectionSort(int[] arr)
	{
       int currentIndex = 0; // to keep track of current
       int smallestIndex = currentIndex; //to keep track of smallest element
       
       //loop through the array ..last element is not included because after
       //selecting smallest from unsorted list and appending it into sorting list
       //within the array only,,in one element array the same element is the smallest element
       while(currentIndex < arr.length - 1)
       {
       	smallestIndex = currentIndex;
       	for(int i = currentIndex+1 ; i < arr.length ; i++)
       	{
       		if(arr[i]<arr[smallestIndex])
       		{
       			swap(i,smallestIndex,arr);
       		}
       	}
       	currentIndex++;
       }
	}
	public static void swap(int a , int b , int[] arr)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
			
}