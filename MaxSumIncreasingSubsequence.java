//Time Complexity O(n^2) | Space Complexity O(n)
import java.util.*;
class A
{
	//to share max sum of increasing subsequnce across functions/methods
	public static int maxSum = 0;
	public static void main(String[] args) 
	{
		//given array from which we need to find max sun increasing sub sequence
		int[] arr = new int[]{8,12,2,3,15,5,7};

		//returns the increasing sequence of numbers from array whoose sum is maximum
		ArrayList<Integer> sequences = getTheSequence(arr);
		//prints the sequence
		System.out.println(sequences.toString());
		System.out.println("Maximum sum that can be generated from a increasing subsequence");
		System.out.println("way 1 by finding largest number in sums array ");
		//sums array is in another function and the largest element in sums array is shared
		//across functions in the global varibale
		System.out.println(maxSum);


		//finding sum of all the elements that form the max sum incraesing subsequence that we received
		System.out.print("way 2 by finding the sum of the sequence arraylist that forms the ");
		System.out.println("maximum sum increasing subsequence");
		int maxSumUsingSequence = 0;
		for(int num : sequences)
		{
			maxSumUsingSequence+=num;
		}
		System.out.println(maxSumUsingSequence);
		
	}
	public static ArrayList<Integer> getTheSequence(int[] arr)
	{
		//to keep track of sums of subsequeces in increasing order
		int[] sums = new int[arr.length];

		//keeps track of index of maxSum (largest element in sums array)
		//we need to pass this as paarmeter while building increasing sequence having max sum
		//from sequence index array
		int maxSumIndex = 0;
        
        //initailizs sums array with given array as sum at any sequence from index 0 is atleast the same number itself
		for(int i = 0 ; i < arr.length ; i++)
		{
			sums[i] = arr[i];
		}

		//it keeps track of previous index of  number  from which max sum is formed
		int[] sequenceIndices = new int[arr.length];
		//initialize it with -1 as it will be used as a stopping criteria while building sequence
		for(int i = 0 ; i < sequenceIndices.length  ; i++)
		{
			sequenceIndices[i] = -1;
		}
        

        //iterate the given arr from 1 , as index 0 has no previous element to compare with
		for(int i = 1 ; i < arr.length ; i++)
		{
		    //i goes from 1 to arr,length - 1
			int currentNum = arr[i];
			//j runs from 0 to i-1 
			//that is j denotes  all previous elemnts to arr[i]
			for(int j = 0 ; j < i ; j++)
			{
				//if the sequence is increasing and by adding current num to previous number
				//previoulsy present value in sums array is lesser than the addition result
				if(currentNum > arr[j] && sums[j]+currentNum >= sums[i])
				{
					//then update the sums array
					sums[i] = sums[j]+currentNum;
					//update the sequence array as increasing sequrncr sum upto index i 
					//previous sums to index i is at index j 
					sequenceIndices[i]=j;
				}

			}
		}
		//the maximum sum of increasing  subsequence is the largest element in sum array 
		//either we can decalre a global variable and assign this max value to get the maximum sum
		for(int num : sums)
		{
			if(num > maxSum)
			{
				maxSum = num;
			}
		}

		//or we are returning an ArrayList of numbers those form the increasingSubsequence & there sum is maximum
		//so in main() mehod we can receive this increasing Subsequence and can find sum of all elements of this arraylist to 
		//get maximum sum increasing subsequence
		//System.out.println(Arrays.toString(sums));
        
        //get the index of largset element of sums array
        //if i is the index of largest element in sums array
        //sequenceIndices[i] stores the index of the previous number from which the sum has come from(the sequence itself)
		for(int i = 0 ; i < sums.length ; i++)
		{
			if(sums[maxSumIndex]<sums[i])
			{
				maxSumIndex = i;
			}
		}

		//pass the given array, indices array , index of max number in sums array
		return buildSequenceFromIndices(arr,sequenceIndices,maxSumIndex);
	}

	//build the sequence from the indices
	public static ArrayList<Integer> buildSequenceFromIndices(int[] numbers,int[] sequenceIndices,int maxIdx)
	{
		//go on appending nums 
		ArrayList<Integer> sequence = new ArrayList<Integer>();

		//last number in the sequence (result) is at index maxIdx
		//now we will tarverse backward and from the sequence in reversed order 
		//i,e is actual increasing order of numbers that form max sum will ne formed here in reversed manner
		int i = maxIdx;

		//stopping criteria wwe set for sequenceIndices array
		while(i != -1)
		{
			//get the index from indices array
			//get the number from numbers array and append it to sequence ArrayList
			sequence.add(numbers[i]);
			//next index to iterate i.e previous number of current num is found from sequence array
			i=sequenceIndices[i];
		}

		//reverse the currently formed sequence ArrayList
		//as we have iterated backwards we need to reverse it before returning

		Collections.reverse(sequence);

		//return the sequence 
		return sequence;

	}
}