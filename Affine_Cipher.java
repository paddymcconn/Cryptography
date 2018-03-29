/*
 * This is a class for encrypting and decrypting the Affine cipher, once given the first and second coprimes
 * as an input. This is for testing different coprimes and to verify the encryption is correct rather than
 * to perform the encryptions. The other Affine class is to see all 312 combinations of the letters,
 * Note: If it is in caps, then 'A' needs to be too, as ascii values are different to 'a'
 * */
  
import java.math.BigInteger;
public class Affine_Cipher
{
    private static int firstKey = 5;
    private static int secondKey = 19;
    private static int module = 26;
    public static void main(String args[])
    {
        String input = " FXLLR JEEOP AQYXJ ";
        String cipher = encrypt(input);
        String deciphered = decrypt(cipher);
        System.out.println("Source:    " + input);
        System.out.println("Encrypted: " + cipher);
        System.out.println("Decrypted: " + deciphered);
    }
    // Encrypt(String x) = (ax + b) % m
    public static String encrypt(String input)
    {
        char a = 'a';
        StringBuilder builder = new StringBuilder();
        for (int in = 0; in < input.length(); in++)
        {
            char character = input.charAt(in);
            if(input.charAt(in)>=97)
            {
                a = 'a';
            }
            else
            {
                a = 'A';
            }
            if (Character.isLetter(character))
            {
                character = (char) ((firstKey * (character - a) + secondKey) % module + a);
            }
            builder.append(character);
        }
        return builder.toString();
    }
    // Decrypt (String x) = a^-1(x-b) % m
    public static String decrypt(String input)
    {
        StringBuilder builder = new StringBuilder();
        // compute firstKey^-1 aka "modular inverse"
        BigInteger inverse = BigInteger.valueOf(firstKey).modInverse(BigInteger.valueOf(module));
        // perform actual decryption
        for (int in = 0; in < input.length(); in++)
        {
            char a = 'a';
            char character = input.charAt(in);
            if(input.charAt(in)>=97)
            {
                a = 'a';
            }
            else
            {
                a = 'A';
            }
            if (Character.isLetter(character))
            {
                int decoded = inverse.intValue() * (character - a - secondKey + module);
                character = (char) (decoded % module + a);
            }
            builder.append(character);
        }
        return builder.toString();
    }
}