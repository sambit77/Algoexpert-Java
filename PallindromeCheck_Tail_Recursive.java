//Time Complexity O(n) | Space Complexity O(1)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		String st = new String("madam");
		boolean b = isPallindrome(st);
		System.out.println("Given String is "+st); 
		System.out.println("is it Pallimdrome ? "+b);
 	}
 	public static boolean isPallindrome(String st)
 	{
 		
            return isPallindromeHelper(st,0);
 	}
 	public static boolean isPallindromeHelper(String st , int firstIdx)
 	{
 		int lastIdx = st.length()-1-firstIdx;

 		//while comparing elements if the index overlap each other or criss cross
 		//that means given string ia p-allindrome
 		if(firstIdx >= lastIdx)
 		{
 			return true;
 		}

 		//comparing elements by picking from both ends together one by one and if they are
 		//not equal string is not pallindrome
 		if(st.charAt(firstIdx) != st.charAt(lastIdx))
 		{
 			return false;
 		}

 		//Here the recursive call is at the absolute end of the program it is called Tail Reucrsion
 		//Here the function stack space can be replaced one by one in each recursive call instead 
 		//of piling uo over the stack .. so it gives O(1) space instead of the default recursion
 		//space complexity O(n)

 		return isPallindromeHelper(st,firstIdx+1);

 	}
}