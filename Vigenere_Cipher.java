import java.util.Scanner;

public class Vigenere_Cipher
{
    public static void main(String[] args)
    {
    	Scanner Sc = new Scanner(System.in);
        String Key = Sc.nextLine();
        String Plaintext = Sc.nextLine();
        //String Encrypted = encrypt(Plaintext, Key);
        //System.out.println(Encrypted);
        System.out.println(decrypt(Plaintext, Key));
        Sc.close();
    }
 
    public static String encrypt(String text, String key)
    {
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z')
            	{
            		continue;
            	}
            res += (char)((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    static String decrypt(String text, String key)
    {
        String result = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c < 'A' || c > 'Z') //used to ignore the chars that are not in the bounds
            	{
            		continue; // exit this iteration, but continue loop
            	}
            result += (char)((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return result;
    }
}