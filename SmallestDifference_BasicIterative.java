////Question :- find the pair having smallest absolute difference ,pick one element from array 1 and other from array 2
//Time Complexity O(n^2) | Space Complexity O(1)
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
   public static void calcSmallestDiff(int[] arr,int[] brr)
   {
   	  int smallestDiff = Integer.MAX_VALUE;  //stores the difference
   	  int potentialSoln = 0;
   	  int[] rrr = new int[2]; //stores the pair

   	  //iterate both the array and find the difference of every posiibke pair
   	  //stire the smallest by replacing 
     for(int i = 0 ; i < arr.length ; i++)
     {
     	 for(int j = 0 ; j < brr.length ; j++)
     	 {
              potentialSoln = Math.abs(arr[i]-brr[j]);
              if(potentialSoln < smallestDiff)
              {
              	smallestDiff = potentialSoln;
              	rrr[0]=arr[i];
              	rrr[1] = brr[j];
              }
     	 }
     }
     System.out.println("Smallest Difference is"+smallestDiff);
     System.out.println("The Pairs are"+Arrays.toString(rrr));
   }
}