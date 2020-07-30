//Time Complexity O(n log n) (because for n numbers at max we have to shiftDown log n)
//Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{8,5,2,9,5,6,3};
		int[] sorted = heapSort(arr);
		System.out.println("Sorted Array is "+Arrays.toString(sorted));
		
	}
	public static int[] heapSort(int[] arr)
	{
		buildMaxHeap(arr);
		for(int i = arr.length-1; i >= 0 ; i--)
		{
			swap(0,i,arr);
			shiftDown(0,i-1,arr);
		}
		return arr;
	}
	public static void buildMaxHeap(int[] arr)
	{
		int firstNonLeaf = arr.length/2;

		for(int i = firstNonLeaf+1; i >=0 ; i--)
		{
			shiftDown(i,arr.length-1,arr);
		}
	}
	public static void shiftDown(int current,int size,int[] arr)
	{
		int left = ((2*current)+1)/2;
		int right = ((2*current)+2)/2;
		int largest = 0;

		if(left <= size && arr[left] > arr[current])
		{
			largest=left;
		}
		else
		{
			largest=current;
		}
		if(right<=size && arr[right] > arr[largest])
		{
			largest=right;
		}

		if(largest != current)
		{
			swap(largest,current,arr);
			shiftDown(current,size,arr);
		}

	}
	public static void swap(int i, int j ,int[] arr)
	{
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}