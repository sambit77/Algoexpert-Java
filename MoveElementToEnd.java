//Time Complexity O(n) | Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{2,1,2,2,2,3,4,2};
		int toMove = 2;
		System.out.println("Before Moving ");
		System.out.println(Arrays.toString(arr));
		moveToEnd(arr,toMove);
		System.out.println("After Moving");
		System.out.println(Arrays.toString(arr));
		
	}
	public static void moveToEnd(int[] arr,int toMove)
	{
		int i = 0;
		int j = arr.length-1;
		int temp = 0;

		while(i<j)
		{
			while(arr[j]==toMove && i < j)
			{
				j--;
			}
			if(arr[i]==toMove)
			{
				//swap the elements
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
			i++;
		}
	}
}