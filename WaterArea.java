//Time Complexity O(n) | Space Complexity O(n)
//we use 3 array of length n or 1 array of length n space complexity is not changed it remains O(n) for
//but here instead of storing leftMax , rightMax & minimum of 2 in 3 separate arrays
//we will be logicallys use only array and replace values inplace within the single array itself
//the value of this array at any index will denote area of water at that index 
//and to get total water area we can return sum of array
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//heights of pillars at diferenet indices
		int[] heights = new int[]{0,8,0,0,5,0,0,10,0,0,1,1,0,3};
		//will return total watre logged area
		int waterArea = getWaterLoggedArea(heights);
		System.out.println("water logged are : "+waterArea);
		
	}
	public static int getWaterLoggedArea(int[] heights)
	{
		the value of this array at any index will denote area of water at that index 
		//and to get total water area we can return sum of array
		int[] maxs = new int[heights.length];
		//leftMax denote maximum height of pillars present in left to current index
		int leftMax = 0;

		for(int i = 0 ; i < heights.length ; i++)
		{
			//height of pillar at current index
			int currentHeight = heights[i];
			//storing first leftMax in maxs[i] later logically will replace values inplace within this array
			//maxs[i] = current left maximum pillar height
			maxs[i] = leftMax;
			//update left max while traversing toward right to the maximum current index pillar height compare that
			//to previously stored leftmax value
			leftMax = Math.max(currentHeight,leftMax);
		}
		//rightMax denote maximum height of pillars present in right to current index
		//programmatically we will itrate the array backwards so that it can get easily traversed and computed
		int rightmax = 0;
		for(int i = heights.length - 1 ;i >=0 ; i--)
		{
			//current height of pillar at index i
			int currentHeight = heights[i];
			//take the minimum of rightmax pillar & leftMax pillar falling towards right & left of current index respectively
			//we can compare current right max with maxs[i] to get left max of pillar at index i 
			//as currently max[i] is storing left MAx
			//we get the minimum height among leftMax and rightMax
			int minHeight = Math.min(rightmax,maxs[i]);
			//ig height of the pillar at current index is minimu than the minimu of its left & right pillar
			//it is a water logged area 
			//amount of water logged is the difference between minimum height & current height
			if(currentHeight<minHeight)
			{
				//storing the amount of water logged at current index by computing difference
				maxs[i] = minHeight-currentHeight;
			}
			else
			{
				//else if current height of pillar is grater than or equal to minimum (its eft max pillar,right max pillar)

				//then this is the hilly region amount of wtare logged is zero
				maxs[i]=0;
			}
            
            //update the right max to maximum of current height of pillar and previously store right max value
			rightmax = Math.max(rightmax,currentHeight);
		}
        
        //as the maxs array represents the watre area at each index to get the total water area return the sum of this array
		return sum(maxs);
	}
	public static int sum(int[] arr)
	{
		int sum = 0; 
		for(int num : arr)
		{
			sum = sum + num;
		}
		return sum;
	}
}