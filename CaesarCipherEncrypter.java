//Time Complexity O(n) | Space Complexity O(n)
//The algorithm shifts each letter of input string by given no of positions called key
class A
{
	public static void main(String[] args) 
	{
		String in = new String("xyz");
		int key = 2;
		String encryptedString = encryptor(in,2);
		System.out.println("Given String"+in);    //xyz
		System.out.println("Encrypted String"+encryptedString);  //zab
	}
	public static String encryptor(String in , int key)
	{
		//using StringBuffer so that append operations can be done in O(1) time
		//if we have used String append will take O(n) time overall time will )(n^2)
		StringBuffer sb = new StringBuffer();
        
		int newKey = key%26; //for large number keys it will make them fall in[0,26]

		//traverse the input String for each character
		for(int i = 0 ; i < in.length() ; i++)
		{
			//each character is coded and then appended
			sb.append(encodedChar(in,newKey,i));
		}
		return new String(sb);

	}

	//code a given character
	public static char encodedChar(String in , int key,int idx)
	{
		//increase the ascii value if given character by given key
		int newLetterCode = (int) in.charAt(idx)+key;
		

		if(newLetterCode <= 122)
		{
			//return the character corresponding to dat ascii by types\ casting
			return (char) newLetterCode;
		}
		else
		{
			//if the new ascii does not fall in range of (97-122) i.e in range of 
			//lower cas alphabets then mod it to fall in the range by ... modding
			//it with 122 and the adding 96(value previous to a)
			return (char) (96+newLetterCode%122);
		}
		
		
	}
}