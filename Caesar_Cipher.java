/* This is a Caesar cipher that does all the shifts for the given string
 * This code assumes that there is at least a move, hence ops = 1 by default
 * commented out is to find the number of shifts to get the first letter to match
 * could try with same length string if you knew it was the same cipher
 */
  
import java.util.*;
public class Caesar_Cipher
{
    public static void main (String args [])
    {
        //String s = "TEHOE IORLS RFFLP SAMAI REAMA CPORN NMTTT JEEDAIHOIE ETSEB NERCC RTHTN IGMIC TTEHE ETLAA NUCEHSICDL IBTGR OOCET SRSYT IIAVN OUTCE YYTIY LCHECOURFM DEPUS TIAIMEGUPT IPSAT DAOTL GERNR WLHEREROES WYAHT NEAAA EILON IGNSO ANLHS ICLPN ORDJDFRTUR SDEOT TVRLH TFDPE MYASM KWPVD HWEYY YTLYLCEOPM EIERE FOTPL POIEE TAUHU DNLOL PHTER TNAAINAYSI DLGEE ETOAE RSNER MTNEA RFDMJ KSMET MEOTTPCITE EEAAS HAIDA EERHK COBRE EINUK NSINT NOKNSLTLTT SOAAU ADUWE ETAWS CTNOB IXWNH WRWDN JTODOEYHAY RCIWL PYCAO WYLTY CRIOF ORRLU IEELD DCGITT";
        Scanner Sc = new Scanner(System.in);
        String Str = Sc.nextLine();
        Str = Str.replace(" ", "");
        int letters = Str.length();
        Sc.close();
        int ops= 1;
        while(ops<26)
        {
            StringBuilder Sb = new StringBuilder();
            for(int i=0; i<letters; i++)
            {
                if((int)Str.charAt(i)<=122 & (int)Str.charAt(i)>=97)
                {
                    int a = (int)Str.charAt(i);
                    a+=ops;
                    while(a > 122)
                    {
                        a -= 26;
                    }
                    Sb.append((char)a);
                }
                else if((int)Str.charAt(i)<=90 & (int)Str.charAt(i)>=65)
                {
                    int a = (int)Str.charAt(i);
                    a+=ops;
                    while(a > 90)
                    {
                        a -= 26;
                    }
                    Sb.append((char)a);
                }
                else
                {
                    Sb.append((char)Str.charAt(i));
                }// the exceptions
            }
            /*
             * first for the letter matching as will always need to change in this cipher
               
            if(Sb.charAt(0) == 'M')
            {
                System.out.println(Sb.toString());
                ops = ops+65; // add 65 as ascii value
                System.out.println((char) ops + ops);
            }
              
              
             * second for the string to match completely 
  
            if(Sb.toString().equals("MKOCKB"))
            {
                System.out.println(Sb.toString());
                ops = ops+65; // add 65 as ascii value
                System.out.println((char) ops + ops);
            }
            */
            System.out.println(Sb.toString());
            ops++;
        }
    }
}