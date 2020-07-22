//Time Complexity O(n) | Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{7,6,4,-1,1,2};
		int target = 16;
		findQuadrapule(arr,target);
		
	}
	public static void findQuadrapule(int[] arr,int target)
	{
		for(int i = 0 ; i < arr.length ; i++)
		{
			for(int j = i+1; j < arr.length ; j++)
			{
				for(int k = j+1 ; j < arr.length ; j++)
				{
					for(int l = k+1; l < arr.length ; l++)
					{
						if(arr[i]+arr[j]+arr[k]+arr[l]==target)
						{
							System.out.println("["+arr[i]+","+arr[j]+","+arr[k]+","+arr[l]+"]");
						}
					}
				}
			}
		}
	}
}