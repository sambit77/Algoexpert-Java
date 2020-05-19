//Time Complexity O(n^2)  | Space Complexity O(n)
//Time Complexity rises to n^2 because String append operation using String is O(n) & further
//we traverse string of length n giving )(n^2)

//StringBuffer can be used to reduce the time complexity as append operations using StringBuffer
//is constant time O(1) opertaion
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		String st = new String("madam");
		System.out.println("Given String "+st);
		boolean b = isPallindrome(st);
		System.out.println("String is Pallindrome ? "+b);
	}
	public static boolean isPallindrome(String s)
	{

		String revString = new String();
		//the loop runs for n times so over all time complexity O(n^2)
		for(int i = s.length()-1 ; i >= 0 ;i--)  //traversing the original String backward
		{
			//appending a character to the String creates a copy of string each time
			//appended hence it has time complexity O(n)
			revString = revString + s.charAt(i); //picking character and appending it to form reversed String

		}
		return s.equalsIgnoreCase(revString); //compare the Strings 
		//if both are equal i.e original and reverse are equal then its pallindrome return true
		//if both are not equal i.e original and reverse are not  equal then its not pallindrome return false
	}
}