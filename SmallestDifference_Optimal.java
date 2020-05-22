//Time Complexity O(n log(n) + m log(m))  | Space Complexity O(1)
// n = no of elements in array one
// m = no of elements in array two
//time complexity is show because of sorting technique as the most optimal sorting technique will have
// O(n log(n)) time complexity where n is no of elements in array

//the time complexity of actual scanning process by pointers is O(m+n) which falls below the overall time complexity
//of the algorithm
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
    int[] arr = new int[]{-1,5,10,20,28,3};
	int[] brr = new int[]{26,134,135,15,17};

	System.out.println("Given array"+Arrays.toString(arr));
	System.out.println("Given array"+Arrays.toString(brr));

	calcSmallestDiff(arr,brr);
	}
	public static void calcSmallestDiff(int[] arr, int[] brr)
	{
		//First Sort the array using inplace sorting algorithm so dat 
		//space complexity remains constant
		Arrays.sort(arr);
		Arrays.sort(brr);
		int[] rrr = new int[2]; // stores the pair;
		int smallestDiff = Integer.MAX_VALUE; // stores the smallest difference value

		int firstNum = 0 ;  //element of array 1
		int secondNum = 0; //element of array 2

		int idxa = 0; //pointer to scan array 1
		int idxb = 0;  //pointer to scan array 2
		int potentialSoln = 0;
		while(idxa < arr.length && idxb < brr.length)
		{
           firstNum = arr[idxa];
           secondNum = brr[idxb];
           potentialSoln = Math.abs(firstNum - secondNum);  //finding absolute diference

           if(firstNum < secondNum)
           {
              idxa += 1;
           }
           else if(firstNum > secondNum)
           {
              idxb += 1;
           }
           else
           {
		   //both numbers are same
           	potentialSoln = 0;
           }

           if(potentialSoln < smallestDiff)
           {
           	rrr[0] = firstNum;
           	rrr[1] = secondNum;
           	smallestDiff = potentialSoln;
           }
		}

		System.out.println("Smallest Difference is"+smallestDiff);
		System.out.println("Pair is "+Arrays.toString(rrr)); 
	}
}
