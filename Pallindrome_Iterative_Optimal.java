//Time Complexity O(n) | Space Complexity O(1)
import java.util.*;
class A
{
  public static void main(String[] args) 
  {
    String st = "madam";
    boolean b = isPallindrome(st);
    System.out.println("given String "+st);
    System.out.println("is it pallindrome ?"+b);	
  }
  public static boolean isPallindrome(String s)
  {
  	int left = 0;
  	int right = s.length()-1;

  	while(left < right)
  	{
  		if(s.charAt(left) != s.charAt(right))
  		{
  			return false;
  		}
  		left += 1;
  		right -= 1; 

  	}
  	return true;
  }
}