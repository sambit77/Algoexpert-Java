//Find three largest number in an Array

//Time Complexity O(n) | Space Complexity O(1)
import java.util.*;
class A
{

	public static int[] arr = new int[]{141,1,17,-7,-17,-27,18,541,8,7,7};
	public static void main(String[] args) 
	{
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		int third = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length ; i ++) 
        { 
            /* If current element is greater than 
            first*/
            if (arr[i] > first) 
            { 
                third = second; 
                second = first; 
                first = arr[i]; 
            } 
        
            /* If arr[i] is in between first and 
            second then update second  */
            else if (arr[i] > second) 
            { 
                third = second; 
                second = arr[i]; 
            } 
        
            else if (arr[i] > third) 
                third = arr[i]; 
        } 
        

		 System.out.println("Three largest elements are " + 
                       first + " " + second + " " + third); 
	}
	
	
}