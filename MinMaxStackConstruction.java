//TimeComplexity O(1) Space Complxity O(1) individually algos
//overall Space Complexity O(3n) = o(n)
import java.util.*;
class A
{
	public static Stack<HashMap<String,Integer>> minMaxStack = new Stack<HashMap<String,Integer>>();
	public static void main(String[] args)  throws Exception
	{
		//initialize a stack instant
		Stack<Integer> myStack = new Stack<Integer>();

		//Note this is not the default way to push element to stack as 
		//provided in Collection Framework i.e myStack.push(5)

		//push value to the stack using our method so that we keep track of minimum 
		//and maximum element in stack side by side
		System.out.println("Using Thread.sleep() for slowing it down");
		System.out.println("Pushing value 5 to stack");
		Thread.sleep(1000);
		push(myStack,5);
		System.out.println("Current Minimum in Stack "+getMin(myStack));
		System.out.println("Current MAximum in Stack "+getMax(myStack));
		Thread.sleep(1000);
		System.out.println("Pushing value 7 to stack");
		push(myStack,7);
		Thread.sleep(500);
		System.out.println("Current Minimum in Stack "+getMin(myStack));
		System.out.println("Current MAximum in Stack "+getMax(myStack));
		Thread.sleep(1000);
		System.out.println("Pushing value 2 to stack");
		push(myStack,2);
		Thread.sleep(500);
		System.out.println("Current Minimum in Stack "+getMin(myStack));
		System.out.println("Current MAximum in Stack "+getMax(myStack));
		pop(myStack);
		Thread.sleep(1000);
		System.out.println("after one pooping");
		Thread.sleep(500);
		System.out.println("Current Minimum in Stack "+getMin(myStack));
		System.out.println("Current MAximum in Stack "+getMax(myStack));
		Thread.sleep(500);
		System.out.println("after another popping");
		pop(myStack);
		Thread.sleep(1000);
		System.out.println("Current Minimum in Stack "+getMin(myStack));
		System.out.println("Current MAximum in Stack "+getMax(myStack));
		System.out.println("Peeking into the stack "+peek(myStack));

	}
	public static int getMin(Stack<Integer> st)
	{
        HashMap<String,Integer> minMaxInstant = minMaxStack.peek();
        return minMaxInstant.get("min");
	}
	public static int getMax(Stack<Integer> st)
	{
        HashMap<String,Integer> minMaxInstant = minMaxStack.peek();
        return minMaxInstant.get("max");
	}
	public static void push(Stack<Integer> st,int data)
	{
       int newMin = data;
       int newMax = data;
       if(!st.isEmpty())
       {
          HashMap<String,Integer> map = minMaxStack.peek();
          newMin = Math.min(map.get("min"),newMin);
          newMax = Math.max(map.get("max"),newMax);
       }

       HashMap<String,Integer> minMaxInstant = new HashMap<String,Integer>();
       minMaxInstant.put("min",newMin);
       minMaxInstant.put("max",newMax);
       minMaxStack.push(minMaxInstant);
       st.push(data);
	}
	public static int pop(Stack<Integer> st)
	{
       minMaxStack.pop();
       return st.pop();
   	}
	public static int peek(Stack<Integer> st)
	{
      return st.peek();
	}
}