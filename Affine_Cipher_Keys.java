/* This is an Affine Cipher that is done for all possible letter combinations
 * this would mean there is 12X26 possible combinations, (312)
 * Note:
 * a must be a coprime of 26 as there is 26 letters to choose from
 * b is the shifts we are moving the letter along
 * this class is used to change to plain text when you do not know the key given.
 * 
 * */
public class Affine_Cipher_Keys
{
    public static void main (String args[])
    { 
        int c =0;
        int [] coprimes = new int [12];
        for(int i=0; i<26; i++)
        {   
            if (gcd(26,i) == 1)
            {
                coprimes[c] = i;
                c++;
            }           
        }
        //coprimes[c] contains the coprimes up to 26
        for(int i=0; i<12; i++)
        {
            for(int j=1; j<=26; j++)
            {
                System.out.println("The co prime keys for this returned text: "+coprimes[i]+"  "+j);
                Affine(coprimes[i], j);
                System.out.println();
                System.out.println("***************************");
            }
        }
    }
      
    // gets the coprimes
    public static int gcd(int a, int b)
    {
           if (b==0) return a;
           return gcd(b,a%b);
    }
      
    // F(x) = (ax+b) % m to encrypt a letter
    public static void Affine(int a, int b)
    {
        //String hello ="EPKH RTD RTDKPDH BUQR MPKVDJ RTDPCRIK KE MPIHIRIVD PKKRQ RK CGG DGDHDJRQ IQ HKQR KERDJ CLKVD";
        String hello = " FXLLR JEEOP AQYXJ ";
    	char arr [] = new char [hello.length()];
        for (int num = 0; num < 26; num++)
        {
            //System.out.println(((char)('A'+num)) + ":" + ((char)('A'+(a*num + b)% 26)));
            // this is for the alphabet, only for comparison not really useful to find the text.
            for(int l=0; l<hello.length();l++)
            {
                if((char)('A'+(a*num + b)% 26) == hello.charAt(l))
                {
                    arr[l] = (char)('A'+num); // point cipher back to plain text
                }
            }
        }
        for(int i=0; i<hello.length(); i++)
        {
            System.out.print(arr[i]);
        }
    }
}