//Time Complexity O(n^2 + m) | Space Complexity O(n+m)
import java.util.*;
class A
{
	public static void main(String[] args) 
	{
		//check if the x & y  can attain any value which must be a substring of given input String
		//and the pattern forms the given input Strung from that value of x and y
		//if this is not possible then return x = null & y = null
		String pattern = "xxyxxy";
		String input = "gogopowerrangergogopowerranger";

		//to store the result
		//result[0] stores value of x
		//result[1] stores value of y

		String[] result = getValueOfXandY(pattern,input);

		System.out.println("value of x "+result[0]);
		System.out.println("value of y "+result[1]);
		
	}

	public static String[] getValueOfXandY(String pattern,String input)
	{
		//if length of pattern is greater than length of input then we can never form 
		//given input for any value of x and y ,, so return x = null & y = null
		if(pattern.length() > input.length())
		{
			return new String[]{"",""};
		}

		//to take the pattern & convert it into ArrayList of characters

		ArrayList<Character> newPattern = getNewPattern(pattern);
		//System.out.println(newPattern.toString());


		//for further details see implementation of getNewPattren

		//if ever switched ,that means starting char of string pattern will not be equal to
		//first char store in ArrayList of char in newPattern

		boolean didSwitch = newPattern.get(0) != pattern.charAt(0);

		//count will store the number of occurances of x & y in pattren

		HashMap<Character,Integer> counts = new HashMap<Character,Integer>();
		//initialize it to 0 for both x and y
		counts.put('x',0);
		counts.put('y',0);

		//this method will count the number of occurances of x and y in the arraylist newPatterns
		//and store it in the counts hashmap
		//and it will return the index of first occurance of y in the pattern

		int firstYPos = getCountAndFirstYPos(newPattern,counts);
		//System.out.println(counts);
		//System.out.println(firstYPos);


		//if the pattern contains y 
		//then frequency of y in counts hashmap is never zero

		if(counts.get('y') != 0)
		{
			//iterate from 1 to length of inputs String ,that would be all potential length of x
			for(int lenOfX = 1 ; lenOfX < input.length() ; lenOfX++)
			{
				//according to a given x potential length ,calculate potential length of y as follows

				//input string length = length of x string + no of x(frequency) + length og y string * no of y(frequency)

				//                       input length     x length    no of x string   no of y strings
				float potentiallenOfY = (input.length() - lenOfX * counts.get('x')) / counts.get('y');
				
				//check if this potential length of y is a valid length or not
				//i.e it should be a proper integer value 
				//i.e for eg 13.0 is valid but 13.5 is not

				//check if valid or not

				// eg if ans comes 13.5 , flooring gives 13.0 , so this can be applied to check validity

				if(Math.floor(potentiallenOfY) != potentiallenOfY )
				{
					//go to next iteration as this length combination of x & y is invalid
					//update x length by 1 , then calculate new value for y  and so on
                   continue;
				}
				//if it is a valid length for y .. for eg i it comes 13.0
				//convert it to int value i.e 13
				int lenOfY = (int) potentiallenOfY;
				//potentially
				//calculate the index of String y from where string y should begin in inputs string

				//yindex = no of x strings coming before y i.e firstYPos in Pattern * length of x
				int yIdx = firstYPos * lenOfX ; 

				//form the value for x and y from given inputs String
				String x = input.substring(0,lenOfX);
				String y = input.substring(yIdx,yIdx+lenOfY);

				//construct the potential Solution from given pattern ,by taking this value of x and y

				String potentialSoln = constructFromXY(x,y,newPattern);

				//check if our formed potentailsoln matches with input
				//then this value of x and y is required solution

				if(potentialSoln.equals(input))
				{
					//then return this value of x and y
					//earlier if you would have switched the value of x and y ,
					//then here switch values again accordingly to maintainn consistency

					//remember firs index stires x value & second index stores y value

					//  if switched -? yes -> current x value is y value , current x value is y value
					return didSwitch ? new String[]{y,x} : new String[]{x,y};
				}

			}

		}
		//if the pattern contains only x
		else
		{
			//potential length of x = inputs string length / number of x strings
			float potentiallenOfX = input.length() / counts.get('x');
			//check if this potential length is a valid integer not floating point
			//i.e it should be of 13.0 type not 13.1 13.5 etc
			if(Math.floor(potentiallenOfX) == potentiallenOfX)
			{
				//convert this length to integer value i.e for eg 13.0 to 13
				int lenOfX = (int) potentiallenOfX;
				//form x string from given input String
				String x = input.substring(0,lenOfX);

				//form th potential soln using newPattern ArrayList taking this value as x
				//and pass value of y as null, as there is no y
				String potentialSoln = constructFromXY(x,"",newPattern);

				//if potentail soln matches with input string
				if(potentialSoln.equals(input))
				{
					//then this value if x the solution
					//if u hav switched earlier pass values accordingly
					//if switched x value = null & y value is v=current x value
					//if not switched x value = current x value & y value is null
					return didSwitch ? new String[]{"",x} : new String[]{x,""};
				}
			}
		}
		//return x = null & y = null if no value of x and y can form the input string
		return new String[]{"",""};
	}
	//with given value for s and y string and pattern it will construct string
	public static String constructFromXY(String x,String y,ArrayList<Character> newPattern)
	{
		//eg if pattern is xyx and x value is aa and y value o
		//xyx gives aaoaa

		StringBuffer sb = new StringBuffer();
		for(Character c : newPattern)
		{
			if(c=='y')
			{
				sb.append(y);
			}
			else
			{
				sb.append(x);
			}
		}
		return sb.toString();
	}
	//this method will count the number of occurances of x and y in the arraylist newPatterns
		//and store it in the counts hashmap
		//and it will return the index of first occurance of y in the pattern

	public static int getCountAndFirstYPos(ArrayList<Character> newPattern,HashMap<Character,Integer> map)
	{
		int ypos = -1;

		//iterate the ArrayList and store the frequency in the map
		for(int i =  0 ; i < newPattern.size() ; i++)
		{
			Character c = newPattern.get(i);
			
			if(map.containsKey(c))
			{
				int val = map.get(c);
				val++;
				map.put(c,val);
			}
			else
			{
				map.put(c,1);
			}
			//for first occurance of y we store its index in ypos
			if(c == 'y' && ypos == -1)
			{
				ypos=i;
			}

		}
		//return index of first occurance of y
		return ypos;
	}
	//this will convert a pattern of String type to ArrayList<Character> type with modification
	//as per requirement
	public static ArrayList<Character> getNewPattern(String pattern)
	{
		//to conver String to ArrayList
		ArrayList<Character> newPattern = new ArrayList<Character>();
				//here our pattern starts with x .. 
		//so we will directly iterate the String and store characters in ArrayList
		//but if the pattern would have been starting with y
		//we will switch values that is for y we will replace x and vice versa and then store in ArrayList
		//accordingly whilw returning final result for solution of x & y ,we can inr=terchange


		//check if we need to switch or not
		//i.e the given pattern starts with y or not

		//eg for xxyxxy the arraylist is x,x,y,x,x,y
		//but for yxyxyx the arraylist is x,y,x,y,x,y

		boolean needToBeSwitched = pattern.charAt(0) != 'x';

		for(int i = 0 ; i < pattern.length() ; i++)
		{
			//but for yxyxyx the arraylist is x,y,x,y,x,y
			if(needToBeSwitched)
			{
				if(pattern.charAt(i)=='y')
				{
					newPattern.add('x');
				}
				else
				{
					newPattern.add('y');
				}
			}
			//eg for xxyxxy the arraylist is x,x,y,x,x,y
			else
			{
				newPattern.add(pattern.charAt(i));
			}

		}
		return newPattern;
	}
}