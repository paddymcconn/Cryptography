/* This is just used to map numbers to characters so that you can get the Index of Coincidence
 * to help figure out what type of cipher (if in numbers) it is likely to be
 * this assumes that the numbers have all been increased by the same amount and thus
 * if we mod it by 26 until it is in [1-26] and add 65 to get it as a char
 * */
import java.util.*;
public class Numbers_To_Chars
{
    public static void main (String args[])
    {
        String str = "42, 43, 73, 71, 72, 63, 51, 32, 23, 81, 43, 73, 23, 63, 62, 23, 32, 72, 62, 32, 31, 91, 43, 81, 42, 61, 82, 53, 81, 43, 33, 21, 23, 81, 63, 72, 93, 32, 72, 63, 52, 62, 63, 91, 53, 32, 31, 41, 32, 21, 82, 81, 42, 32, 62, 81, 43, 23, 21, 81, 43, 63, 62, 82, 73, 43, 62, 41, 32, 53, 53, 43, 71, 81, 43, 23, 23, 82, 72, 83, 32, 73, 73, 32, 62, 31, 61, 32, 21, 62, 32, 61, 21, 43, 53, 91, 43, 81, 42, 93, 62, 32, 23, 43, 62, 81, 42, 32, 73, 82, 22, 51, 32, 23, 81, 33, 43, 32, 53, 31, 73, 81, 21, 81, 43, 62, 41, 42, 63, 91, 93, 63, 82, 31, 32, 23, 72, 93, 71, 81, 32, 31, 21, 62, 31, 91, 42, 93, 93, 63, 82, 91, 21, 62, 81, 81, 63, 31, 63, 81, 42, 32, 71, 72, 63, 51, 32, 23, 81";
        int[] arr = Arrays.stream(str.substring(1, str.length()-1).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        // now have as int array
        Arrays.sort(arr);//getting bigger order
        char charArr[] = new char [arr.length];
         
        for(int i=0; i<arr.length; i++)
        {
            int a = arr[i];
            while(a>26)
                {
                    a = a%26;
                }
            a+=65;
            charArr[i] = (char)a;
        }
        Arrays.sort(charArr);
        for(int j=0; j<arr.length; j++)
        {
            System.out.println(charArr[j]+" : "+arr[j]);
        }
    } //  maps all numbers to a character for the time being
}