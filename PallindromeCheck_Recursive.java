//Time Complexity O(n) | Space Complexity O(n) (Stack used durein recursion)
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

 		//comparing elements by picking from both ends together one by one and if they are
 		//not equal string is not pallindrome

 		//Here the recursive call is at the absolute end of the program it is called Tail Reucrsion
 		//Here the function stack space can be replaced one by one in each recursive call instead 
 		//of piling uo over the stack .. so it gives O(1) space instead of the default recursion
 		//space complexity O(n)

 		return firstIdx >= lastIdx ? true : st.charAt(firstIdx) == st.charAt(lastIdx) && isPallindromeHelper(st,firstIdx+1);
 	}
}