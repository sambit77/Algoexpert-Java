//Time Complexity O(n) | Space Complexity O(n)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{8,4,2,1,3,6,7,9,5};
		int result = getMinRewards(arr);
		System.out.println("Minimum Reward is "+result);
		
	}
	public static int getMinRewards(int[] arr)
	{
		int[] rewards = new int[arr.length];
		for(int i = 0 ; i < arr.length ; i++)
		{
			rewards[i]=1;
		}

		//we do not need to find local minimums actually 
		//we can mimic the left & right exapnsions from local mins by
		//traversing the given array forward and backward & applying mins condition accordingly

		//traversing in forward direction
		//mimicing right expansion from localmins
		//starting from one because arr[0] has no previous element

		for(int i = 1 ; i < arr.length ; i++)
		{
			if(arr[i-1]<arr[i])
			{
				//store the maximum
				//we can also write rewards[i] = Math.max(rewards[i],rewards[i-1]+1)
				//but its not necessary cause previously stored value is always 1 ,,and incremented value will
				//always greater than 1
				rewards[i] = rewards[i-1]+1;
			}
		}
		//travesring in backward direction
		//mimicing left expansion from local min point
		//statrting from arr.length-2 beacause arr[arr.length-1] has no next element to compare
		for(int i = arr.length-2 ; i >=0 ; i--)
		{
           if(arr[i+1]<arr[i])
           {
           	rewards[i]=Math.max(rewards[i],rewards[i+1]+1);
           }
		}
		System.out.println(Arrays.toString(rewards));
		return sum(rewards);
	}
	public static int sum(int[] arr)
	{
		int sum = 0;
		for(int num : arr)
		{
			sum += num;
		}
		return sum;
	}
}