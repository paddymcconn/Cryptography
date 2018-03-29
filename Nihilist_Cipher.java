/* A nihilist cipher needs a polyWord word that is shared between the two parties, say Aleksandr Nikolaevich(killed by the nihilists)
 * We then need to use a 5X5 grid to fill this into without letter repetition, a polybius square.
 * Note: j is usually omitted or used coinciding with i as it comes up irregularly and we only can use 25 letters.
 *      1   2   3   4   5
 *  1   A   L   E   K   S
 * 
 *  2   N   D   R   I   O
 *  
 *  3   V   C   H   B   F
 *  
 *  4   G   M   P   Q   T
 *  
 *  5   U   W   X   Y   Z
 *  
 *  This is our 5X5 polybius square with the shared polyWord word in it.
 *  This can then be turned into the corresponding numbers, eg A=11
 *  
 *  we need both a keyword for the square and a separate key that will be used to
 *  add it to the message in number for, repeated the key as needed.
 *  
 *  to decrypt we need to find the polyWord word and take the values away from the numbered encryption.
 *  after this we have the number form of the letters, then we just need to convert them back into characters
 *  as from what is on our known square.
 * */
// we are merging i and j for this example.

import java.util.*;
import java.util.stream.Collectors;
 
public class Nihilist_Cipher
{
	public static void main (String args[])
	{
		String Alpha = new String("abcdefghiklmnopqrstuvwxyz");
		String PolyWord = new String("secret");
		String Key = "russian";
		Key = Key.toLowerCase();
		Key = Key.replace(" ", "");
		String Plaintext ="dynamite winter palace";
		Plaintext = Plaintext.toLowerCase();
		Plaintext = Plaintext.replace(" ", "");
				
		char [][] Poly = new char [5][5];
		String holder ="";
		holder = RemoveDups(holder,PolyWord);
		holder = SecretAlphabet(Alpha,holder);
		Poly = FillPoly(Poly,holder);
		PrintPoly(Poly);
		List <String> KeyNum = new ArrayList<String>();
		List <String> Numbers = new ArrayList<String>();
		List <Integer> Cipher = new ArrayList<Integer>();
		List <Integer> ExtendedKey = new ArrayList<Integer>();
		// hold the numbers after they are found
		System.out.println(Key+" In number form :"+(KeyNum = PolyAsNums(Poly,Key,KeyNum)));
		// change the key word to its numbers as per square
		System.out.println(Plaintext+" In number form :"+(Numbers = PolyAsNums(Poly,Plaintext,Numbers)));
		// change the polybius square to its index corresponding partner.
		
		int len = Numbers.size();
		System.out.println("Extended Key as nums is:"+(ExtendedKey = ExtendKeyNum(KeyNum,len)));
		// extend the keyword to the length of the cipher text.
		System.out.println("Cipher as nums is :"+(Cipher = AddToCipher(KeyNum,Numbers)));
		// Finally encrypt it as numbers.
		System.out.println("Original as nums is :"+DecryptToNums(ExtendedKey,Cipher));
		System.out.println("cipher back to characters is:"+DecryptToChars(Poly,Cipher));
	}
	public static List<Character> DecryptToChars(char poly [][],List<Integer> Cipher)
	{
		List<Character> OriginalMessage = new ArrayList<Character>(Collections.nCopies(Cipher.size(), 'a'));
		// char list of size cipher list
		for(int i=0; i<Cipher.size(); i++)
		{
			Integer a = Cipher.get(i);
			String b = a.toString();
			char one = b.charAt(0);
			char two = b.charAt(1);
			int oneint = Character.getNumericValue(one)-1;
			int twoint = Character.getNumericValue(two)-1;
			OriginalMessage.set(i, poly[oneint][twoint]);
		}
		
		return OriginalMessage;
	}
	
	public static List<Integer> DecryptToNums(List<Integer> extendedKey, List <Integer>Cipher)
	{
		for(int i=0; i<Cipher.size(); i++)
		{
			int j = Cipher.get(i);
			int k = extendedKey.get(i);
			Cipher.set(i, j-k); // set the index of i as the sum of both
		}
		return Cipher;
	}
	
	public static List<Integer> AddToCipher(List<String>KeyNum, List<String>Numbers)
	{
		List <Integer> KeyNum2 = KeyNum.stream().map(Integer::parseInt).collect(Collectors.toList());
		List <Integer> Numbers2 = Numbers.stream().map(Integer::parseInt).collect(Collectors.toList());
		// parse the string as a number list
		for(int i=0; i<Numbers2.size(); i++)
		{
			int j = KeyNum2.get(i);
			int k = Numbers2.get(i);
			Numbers2.set(i, j+k); // set the index of i as the sum of both
		}
		//System.out.println(Numbers2);
		return Numbers2;
	}
	public static List<Integer> ExtendKeyNum(List <String> KeyNum, int len) // this is used to make the numberfied key 
	//to the length of the text to be encrypted.
	{
		int adding =0;
		while(KeyNum.size()<len)
		{
			KeyNum.add(KeyNum.get(adding));
			adding++;
		}
		ArrayList<Integer> KeyNumInteger = new ArrayList<Integer>(KeyNum.size());
        for (String myInt : KeyNum) { 

          KeyNumInteger.add(Integer.parseInt(myInt)); 
        }
		return KeyNumInteger;
	}
	public static List<String> PolyAsNums(char Poly[][],String text,List <String> TextAsNums)
	{
		int count =0;
		while(count != text.length())
		{
			for(int i=0; i<5; i++)
			{
				for(int j=0; j<5; j++)
				{
					if(count == text.length())
					{
						break;
					} // check the length as goes +1 on length because of where increment is.
					if (Poly[i][j] == text.charAt(count))
					{
						String ij = (i + 1) + "" + (j + 1);
						TextAsNums.add(ij);
						count++;
						i = 0;
						j = 0;
					}
				}
			}
		}
		return TextAsNums;
	}
	public static String RemoveDups(String holder, String polyWord)
	{
		for (int i = 0; i < polyWord.length(); i++)
		{
	        if(!holder.contains(String.valueOf(polyWord.charAt(i))))
	        {
	            holder += String.valueOf(polyWord.charAt(i));
	        }
	    }// above takes the duplications out of the string and preserves ordering
		return holder;
	}
	
	public static String SecretAlphabet(String alpha, String holder)
	{
		String temp =holder;
		int a =0;
		while(!temp.isEmpty())
		{
			if (alpha.charAt(a) == temp.charAt(0))
			{
				alpha = alpha.substring(0, a) + alpha.substring(a+1);
				temp = temp.substring(1);
				a=0;
			}
			a++;
		}
		return holder +=alpha;

	}	
	public static char[][] FillPoly(char Poly[][], String holder)
	{
		int a = 0;
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				Poly[i][j] = holder.charAt(a);
				a++;
			}
		}
		return Poly;
	}
	
	public static char[][] PrintPoly(char Poly [][])
	{
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				System.out.print(Poly[i][j]+" ");
			}
			System.out.println();
		}
		return Poly;
	}
}
