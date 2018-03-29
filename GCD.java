/* finding the greatest common denominator
 * use to find coprimes, ones that return 1
 * 
 * */
public class GCD
{
    public static int gcd(int a, int b)
    {
        if (b == 0)
        {
            return a;
        }
        else if(a%b ==1)
        {
            return gcd(b,a%b);
            // return these as they are coprimes
        }
        else
        {
            return 0; //
        }
    }
}