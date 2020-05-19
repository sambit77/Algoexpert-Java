//Time Complexity O(n) | Space Complexity O(n)
import java.util.*;
class A
{
 public static void main(String[] args) 
 {
 	String st = "Sambit"; //given String
 	System.out.println("Given String "+st);
 	boolean b = isPallindrome(st);
 	System.out.println("Given String is Pallindrome ? "+b);
 }
 public static boolean isPallindrome(String s)
 {
 	StringBuffer revString = new StringBuffer();
 	//Traversing Original String backward
 	for(int i = s.length()-1 ; i >= 0 ; i--)
 	{
 		//appending each char in constant time  O(1) (amortized time over n appends)
       revString = revString.append(s.charAt(i));
 	}

 	return new String(revString).equalsIgnoreCase(s);
 }
}