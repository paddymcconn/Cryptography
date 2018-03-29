/*playfair rules:
 * get the secret word
 * fill into 5X5 matrix without dups and fill rest with alphabet in order
 * can either omit q, treat i and j the same or omit x, doesnt matter as message
 * will be clear without these.
 * 
 * still need to make the decrypting method.
 * puts X inbetween double letters to try and obscure digraphs, easily seen in large texts.
 * */
import java.util.*;
public class Playfair_Cipher
{
	public static void main (String args[])
	{
		String alpha = new String("abcdefghiklmnopqrstuvwxyz");
		// we are omitting q for this example
		String secret ="codebook";
		secret = secret.replace(" ", "");
		secret = secret.toLowerCase();
		// remove the spaces
		String holder ="";
		
		List<Character> message = new ArrayList<Character>();
		String MessageToEncrypt = "wearediscoveredsaveyourselfx";
		MessageToEncrypt = MessageToEncrypt.toLowerCase();
		MessageToEncrypt = MessageToEncrypt.replace(" ", "");
		for(int i=0; i<MessageToEncrypt.length(); i++)
		{
			message.add(MessageToEncrypt.charAt(i));
		}// fill the list with message characters
		if(message.size()%2!= 0)
		{
			message.add('x');
		}// if an odd length add an X to the end so all have pairs.
		// note that the letter you append to the end changes what letter is paired with the end,
		// meaning it will be a different letter, a different handling of this pair.
		
		char playfair [][] = new char [5][5];
		holder = RemoveDups(holder,secret);
		holder = SecretAlphabet(alpha,holder);
		playfair = FillPoly(playfair,holder);
		PrintPoly(playfair);
		String encrypt ="";
		while(!message.isEmpty())
		{
			encrypt+=dimensions(playfair,message);
			System.out.println(encrypt);
			message.remove(0);
			message.remove(0);
		}// while the list is not empty, call encrypt as length is even.
		System.out.println(encrypt);
	}
	public static String dimensions(char [][] playfair, List<Character> message)
	{
		char one = (char) message.get(0);
		char two = (char) message.get(1);
		char holder1;
		char holder2;
		String pair ="";
		// where we will hold the returned pair of letters
		String charone ="";
		String chartwo ="";
		// holds the reference in a string
		boolean foundone = false;
		boolean foundtwo = false;
		for(int i=0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				if(playfair[i][j] == one)
				{
					charone = (int)i+""+(int)j;
					foundone = true;
				} //  taking the number reference as a string
				if(playfair[i][j] == two)
				{
					chartwo = (int)i+""+(int)j;
					foundtwo = true;
				} //  taking the number reference as a string	
			}	
			if(foundone== true && foundtwo == true)
			{// here we need to remove the first 2 letters from the array
				if(charone.charAt(0) == chartwo.charAt(0)) // the same row
				{
					char onecolumn = charone.charAt(0);
					int onecolumnint=onecolumn-'0';
					
					char onerow = charone.charAt(1);
					int onerowint = onerow -'0';
					onerowint = (onerowint+1)%5;
					
					char twocolumn = chartwo.charAt(0);
					int twocolumnint = twocolumn -'0';
					
					char tworow = chartwo.charAt(1);
					int tworowint = tworow -'0';
					tworowint = (tworowint+1)%5;
					// modulo to wrap around 5 to prevent out of index
					holder1 = playfair[onecolumnint%5][onerowint%5];
					holder2 = playfair[twocolumnint%5][tworowint%5];
					// get the letters 
					if(charone.equals(chartwo))// if its a double letter put an x in the middle
					{// this can be filled in a number of different ways, such as moving both over +1 and +2
					// could also pick character below or below and across, all depends.
						pair =holder1+"x"+holder2;
						return pair;
					}
						pair = holder1+""+holder2;
				}
				else if(charone.charAt(1) == chartwo.charAt(1)) // same column
				{
					char onecolumn = charone.charAt(0);
					int onecolumnint=onecolumn-'0';
					onecolumnint = (onecolumnint%5)+1;
					
					char onerow = charone.charAt(1);
					int onerowint = onerow -'0';
					
					char twocolumn = chartwo.charAt(0);
					int twocolumnint = twocolumn -'0';
					twocolumnint = (twocolumnint%5)+1;
					
					char tworow = chartwo.charAt(1);
					int tworowint = tworow -'0';
					// modulo to wrap around 5 to prevent out of index
					
					holder1 = playfair[onecolumnint%5][onerowint%5];
					holder2 = playfair[twocolumnint%5][tworowint%5];
					// get the letters 
					pair = holder1+""+holder2;
				}
				else
				{// create a rectangle still has to be done, see chrome for how to:
				char onecolumn = charone.charAt(1);
				int onecolumnint=onecolumn-'0';
				
				char onerow = charone.charAt(0);
				int onerowint = onerow -'0';
				
				char twocolumn = chartwo.charAt(1);
				int twocolumnint = twocolumn -'0';
				
				char tworow = chartwo.charAt(0);
				int tworowint = tworow -'0';
				
				holder1 = playfair[onerowint%5][twocolumnint%5];
				holder2 = playfair[tworowint%5][onecolumnint%5];
				pair = holder1+""+holder2;
				}
				return pair;
			}
		}
		return pair;
	}
	
	public static String RemoveDups(String holder, String secret)
	{
		for (int i = 0; i < secret.length(); i++)
		{
	        if(!holder.contains(String.valueOf(secret.charAt(i))))
	        {
	            holder += String.valueOf(secret.charAt(i));
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
			boolean bol = false; 
			if (alpha.charAt(a) == temp.charAt(0))
			{
				alpha = alpha.substring(0, a) + alpha.substring(a+1);
				temp = temp.substring(1);
				a=0;
				bol = true;
			}
			if(!bol)
			{
				a++;
			}
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
