//Time Complexity O(n^2) | Space Complexity O(n)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//scores of individual student
		int[] arr = new int[]{8,4,2,1,3,6,7,9,5};
		int result = getMinRewards(arr);
		System.out.println("Minimum Reward is "+result);
		
	}
	public static int getMinRewards(int[] arr)
	{
		//to store rewards of individual student
		int[] rewards = new int[arr.length];
		//intialize rewards with 1 //as atleast  1 reward is the minimum for any student
		for(int i = 0 ; i < rewards.length ; i++)
		{
           rewards[i] = 1;
		}

        //iterarte the array using i (forward direction)
		for(int i = 1 ; i < arr.length ; i++) //starts from 1 as arr[0] has no previous element
		{
			//j is used to iterate array backwards
			int j = i-1;
			//if current element is greater than previous element
			if(arr[i]>arr[j])
			{
				//reward of current element is 1 greater than reward of previous element
				rewards[i] = rewards[j]+1;
			}
			//if currenet element is lesser than previous element 
			//go till begin of array from here till elements get increase while moving towards begining
			else
			{
				while(j>=0 && arr[j]>arr[j+1])
				{
					rewards[j] = Math.max(rewards[j],rewards[j+1]+1);
					j--;
				}
			}
		}
		//System.out.println(Arrays.toString(rewards));

		//return the sum of rewards array
		return sum(rewards);
	}
	public static int sum(int[] arr)
	{
		int sum = 0;
		for(int num : arr)
		{
			sum +=num;
		}
		return sum;
	}
}