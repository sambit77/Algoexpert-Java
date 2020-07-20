//Time Complexity O(n) | Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{2,3,1,-4,-4,2};
		boolean result = hasSingleCycle(arr);
		System.out.println("Does it have single cycle "+result);
		
	}
	public static boolean hasSingleCycle(int[] arr)
	{
		int elementsVisited = 0;
		int currentIdx = 0;

		while(elementsVisited < arr.length )
		{
			if(elementsVisited>0 && currentIdx==0)
			{
				return false;
			}
			elementsVisited++;
			currentIdx = getNextIdx(currentIdx,arr);
		}
		if(currentIdx==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public static int getNextIdx(int currentIdx,int[] arr)
	{
		int jumps = arr[currentIdx];
		int nextIdx = (currentIdx+jumps) % arr.length ;

		return nextIdx < 0 ? nextIdx+arr.length : nextIdx;
	}
}