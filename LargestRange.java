//Given an array of numbers find the largest range(continious ) of numbers present in array
//Time Complexity O(n) | Space Complexity O(n)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		int[] arr = new int[]{1,11,3,0,15,5,2,4,10,7,12,6};
		int[] maxRange = getLargestRange(arr);
		//maxRange[0]-> gives lower limit of range contained in array
		//maxRange[1]-> gives higher limit of range contained in array
		//eg the array contains all elemnts from 0 t0 7 and the length of range is maximum i.e 7
		//so maxRange[0] = 0 , maxRange[1]= 7;

		System.out.println("Maximum length of range of numbers in array is");
		System.out.println(Arrays.toString(maxRange));
		
	}
	public static int[] getLargestRange(int[] arr)
	{
		//to keep track of left & right index of bestRange(maximum length range)
		int[] bestRange = new int[2];//bestRange[0] = lower bounf , bestRange[1]=upper bound

		//keep maximum length of range time to time
		int maxLength = 0;

		//this hashmap contains all the elemnts in array mapped to a boolean value
		//where true denotes the element is explored
		HashMap<Integer,Boolean> nums = new HashMap<Integer,Boolean>();
        //add all elements to the hashmap & map them to true
		for(int num : arr)
		{
			nums.put(num,true);
		}

		//traverse each element of array
		for(int i = 0; i < arr.length ; i++)
		{
			//if the elemnt is explored previously then skip it & continue
           if(!nums.get(arr[i]))
           	continue;

           //if it is getting explored for first time

           //mark this element as visited in hashmap
           nums.put(arr[i],false);
           //set current length of range to 1 , i.e the number itself length is 1
           int currentLength = 1;

           //go to left of element and checks its present in hashmap(i.e indirectly checking its present in array)
           int left = arr[i]-1;
           //go to rigth of element and checks its present in hashmap(i.e indirectly checking its present in array)
           int right = arr[i]+1;
           //
           //checking its presence in map in constant time operation
           while(nums.containsKey(left))
           {
           	//if it is present in hashmap
           	//mark this element as visited
           	nums.put(left,false);
           	//increment the current length of range
           	currentLength++;
           	//decrement the left till the decremented number present in hashmap
           	left--;
           }

           //chehcking its presence in map in constant time operation
           while(nums.containsKey(right))
           {
           	//if  is present in hashmap
           	//mark this element as visited
           	nums.put(right,false);
           	//increment the current length of range
           	currentLength++;
           	//increment the right till the incremented present in hashmap
           	right++;
           }

           //the breaking of while loop occurs when we go extra step with left & right
           //the actual upper bound & lower bound can be obtained by doing the reverse operation than those
           //done in while loop

           //we have gone extar 1 step lower than the actual lower bound of range (in an order to break while loop)
           //so increment the left by 1
           left = left+1;

           //we have gine extra step above than the actual upper bound of range (in an order to break from while loop)
           //so decrement right by1
           right = right-1;
           

           //check if length of previously stored range is smaller than the current range length
           if(currentLength>maxLength)
           {
           	//if so update the maxLEngth to current length
           	maxLength=currentLength;
           	//accordingly set the upper and lower bpund of range
           	bestRange[0]=left;
           	bestRange[1]=right;

           }
		}
		//retrun the range whoose length is maximum
		return bestRange;
	}
}