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
		//intialize a  reward array with all 1s
		int[] rewards = new int[arr.length];
		for(int i = 0 ; i < rewards.length ; i++)
		{
			rewards[i]=1;
		}
		//get all the local minimums in the array
		ArrayList<Integer> localMinPoints = getLocalMinPoints(arr);
		//System.out.println(localMinPoints.toString());
		//for every local min point index in array start expanding towards left and right 
		//while expanding check that numbers in original array is increasing 
		//if so then increment by 1 in each step towards left & right
		//and start storing the maximum of (previously stored value,Incremented Value)
		for(int localMin : localMinPoints)
		{
			//exapnd towards left
			int left = localMin-1;
			//expand towards right
			int right = localMin+1;
            
            //keep expanding till begin of array or till forthcoming element is greater than its one previous element holds true
			while(left >=0 && arr[left]>arr[left+1]  )
			{//store the maximum
				
				rewards[left] = Math.max(rewards[left],rewards[left+1]+1);
				//decerement left 
				left--;
			}
			//keep expanding till end of array or till next element is greater than previous holds true
			while(right < arr.length&&arr[right]>arr[right-1]  )
			{

				//store the maximum
				//we can also write rewards[right] = Math.max(rewards[right],rewards[right-1]+1)
				//but its not necessary cause previously stored value is always 1 ,,and incremented value will
				//always greater than 1
				rewards[right] = rewards[right-1]+1;
				//keep traversing
				right++;
			}

		}
		//System.out.println(Arrays.toString(rewards));
		//return the sum of rewards array
		return sum(rewards);
	}

	//returns all the local minimum point index of an array
	public static ArrayList<Integer> getLocalMinPoints(int[] arr)
	{
		//lcoalminpoint  is thos index whoose valu is smaller than its adjacent values
		ArrayList<Integer> localMinPoints = new ArrayList<Integer>();
		if(arr.length == 0)
		{
			return localMinPoints;
		}
		if(arr.length == 1)
		{
			localMinPoints.add(arr[0]);
			return localMinPoints;
		}

		for(int i = 0; i < arr.length ; i++)
		{
			//for first element of array ,just check with next element(it has one adjacent element)
			if(i==0 && arr[i+1]>arr[i])
			{
				localMinPoints.add(i);
			}
			//for last element of array just check with prev element (it has one adjacent element)
			if(i==arr.length-1 && arr[i-1]>arr[i])
			{
				localMinPoints.add(i);
			}
			//if aove condition is not statisfied for first & last element of array
			//then when first & last element comes just skip them
			if( i == 0 || i == arr.length-1)
			{
				continue;
			}

			//for every interio elements of array ,check for local min points
			//check the condition for both of its adjacent elements
			if(arr[i]<arr[i+1] && arr[i]<arr[i-1])
			{
				localMinPoints.add(i);
			}
		}
		return localMinPoints;
	}

	//returns sum of elements of an array
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