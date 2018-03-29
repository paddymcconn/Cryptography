/* this is a rectangular cipher where we put the ciphertext in a rectangle and read it 
 * either vertically up and down, diagonally (create 2 squares side by side or wrap around)
 * 
 * 
 * need to input a length check and fill to make it a square of the right dimentions.
 * */

import java.util.*;

public class Rectangular_Cipher
{	 
    public static void main(String[] args)
    {
    	Scanner Sc = new Scanner(System.in);
        String in = Sc.nextLine();
    	in = in.replace(" ", "");
    	int length = in.length();
    	if(Math.sqrt(length)*2 != length)
    	{
    		in+='x';
    		length = in.length();
    		System.out.println(length);
    	}
    	int ROW = (int)Math.sqrt(length);
        int COL = (int)Math.sqrt(length);
    	char M [][] = new char [ROW][COL];
    	// rectangle of the right dimensions
    	int index =0;
    	// follow the string
    	for(int i =0; i<ROW; i++)
    	{
    		for(int j=0; j<COL; j++)
    		{
    			M[i][j] = in.charAt(index);
    			index++;
    		}
    	}
        print(M);
        diagonalPrint(M);
        Sc.close();
    }

 
    public static void diagonalPrint(char[][] m)
    {    
        int row=m.length;
        int col = m[0].length;    
        for (int line =1;line <=(row+col-1);line++)
        {
             int start_col =  max(0, line-row);
             int count = min(line, (col-start_col), row);
            for (int j=0; j<count; j++)
			{
				System.out.print(m[min(row, line) - j - 1][start_col + j]);
			}
             System.out.println();
        }
 
    }
 
	public static int min(int a, int b)
	{
		return (a < b) ? a : b;
	}

	// A utility function to find min of three integers
	public static int min(int a, int b, int c)
	{
		return min(min(a, b), c);
	}
 
    // A utility function to find max of two integers
    public static int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
 
    public static void print(char[][] m)
    {
        for (int i = 0; i < m.length; i++)
        {
            for (int j = 0; j < m[0].length; j++)
            {
                System.out.print(m[i][j]);
            }
            System.out.println();
        }
    }
}
