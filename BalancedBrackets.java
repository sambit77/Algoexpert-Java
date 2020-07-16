//O(n) time | O(n) Space 
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter the parethesis query");
		//String st = sc.nextLine();
		
		String st = "(([]()()){})()";

		boolean result = checkBalanced(st);
		System.out.println("Given String is balance ? "+result);

		
	}
	public static boolean checkBalanced(String st)
	{
		ArrayList<Character> openBrackets = new ArrayList<Character>();
		openBrackets.add('(');
		openBrackets.add('{');
		openBrackets.add('[');
		ArrayList<Character> closedBrackets = new ArrayList<Character>();
		closedBrackets.add(')');
		closedBrackets.add('}');
		closedBrackets.add(']');
		HashMap<Character,Character> partner = new HashMap<Character,Character>();
		partner.put('}','{');
		partner.put(']','[');
		partner.put(')','(');

		Stack<Character> myStack = new Stack<Character>();


		for(int i = 0 ; i < st.length() ; i++)
		{
          if(openBrackets.contains(st.charAt(i)))
          {
             myStack.push(st.charAt(i));
          }
          else if(closedBrackets.contains(st.charAt(i)))
          {
          	if(myStack.isEmpty())
          	{
          		return false;
          	}
          	else
          	{
          		if(myStack.peek()==partner.get(st.charAt(i)))
          		{
                    myStack.pop();
          		}
          		else
          		{
          			return false;
          		}
          	}
          }

		}
		return myStack.isEmpty();
	}
}