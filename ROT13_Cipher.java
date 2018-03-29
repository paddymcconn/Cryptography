/* This is a variation of the caesar cipher. we rotate the letters 13 spaces, such that we go up half
 * way up the alphabet. to decrypt we simply apply the function again ROT13(ROT13(X)) = X
 *  
 */
import java.util.*;
  
public class ROT13_Cipher
{
    public static void main (String args[])
    {
        Scanner Sc = new Scanner(System.in);
        String ROTString = Sc.nextLine();
        System.out.println("Encrypting : "+Encrypt(ROTString));
        System.out.println("Decrypting : "+Decrypt(Encrypt(ROTString)));
        Sc.close();
    }
    public static String Encrypt(String ROT)
    {
        String Holder = "";
        for(int i =0; i<ROT.length(); i++)
        {
            char toMove = ROT.charAt(i);
            toMove = (char) ((toMove + 13));
            Holder += toMove;
            // add 13 places to the character.
        }
        return Holder;
    }
    public static String Decrypt(String ROT)
    {
        String Holder = "";
        for(int i =0; i<ROT.length(); i++)
        {
            char toMove = ROT.charAt(i);
            toMove = (char) ((toMove - 13));
            Holder += toMove;
            // take 13 places from character, easier than modulo around.
        }
        return Holder;
    }
}