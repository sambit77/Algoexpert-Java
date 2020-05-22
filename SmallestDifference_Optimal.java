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

		int firstNum = 0 ;
		int secondNum = 0;

		int idxa = 0;
		int idxb = 0;
		int potentialSoln = 0;
		while(idxa < arr.length && idxb < brr.length)
		{
           firstNum = arr[idxa];
           secondNum = brr[idxb];
           potentialSoln = Math.abs(firstNum - secondNum);

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