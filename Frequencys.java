/* This is used to get the occurences of different characters or numbers in this case delimited by ","
 * Given this it is easier to see what type of cipher would have been used
 * eg. in this example, there are 26 different integers, so its likely the alphabet
 * This means that it is most likely a substitution cipher that has encrypted it
 * Count[] in this case has the frequencies of the numbers
 * */
 
import java.util.*;
import java.util.Map.Entry;
 
public class Frequencys
{
    public static void main (String args[])
    {
        String NumbersInAString = "81, 42, 43, 73, 71, 72, 63, 51, 32, 23, 81, 43, 73, 23, 63, 62, 23, 32, 72, 62, 32, 31, 91, 43, 81, 42, 61, 82, 53, 81, 43, 33, 21, 23, 81, 63, 72, 93, 32, 72, 63, 52, 62, 63, 91, 53, 32, 31, 41, 32, 21, 82, 81, 42, 32, 62, 81, 43, 23, 21, 81, 43, 63, 62, 82, 73, 43, 62, 41, 32, 53, 53, 43, 71, 81, 43, 23, 23, 82, 72, 83, 32, 73, 73, 32, 62, 31, 61, 32, 21, 62, 32, 61, 21, 43, 53, 91, 43, 81, 42, 93, 62, 32, 23, 43, 62, 81, 42, 32, 73, 82, 22, 51, 32, 23, 81, 33, 43, 32, 53, 31, 73, 81, 21, 81, 43, 62, 41, 42, 63, 91, 93, 63, 82, 31, 32, 23, 72, 93, 71, 81, 32, 31, 21, 62, 31, 91, 42, 93, 93, 63, 82, 91, 21, 62, 81, 81, 63, 31, 63, 81, 42, 32, 71, 72, 63, 51, 32, 23, 81";
        String numtest = "12, 22, 33, 44, 34, 34, 34, 44, 33, 22, 22, 22, 12, 12, 12";
        //NumberOccurences(NumbersInAString);
        String test =" }?U&[ :E~O| }|E>| O:>&} ?O>OH ?E[O[ E&}^A I>}A{|:S[} E]:I[ ?U|&S &}O{I ?U]?< OCO<E *{I}? O{I}U|I<I> £[:E] :I{{U >]I%U <U}SI &HO<< I&I>I %U<U} S}EHE :(U>£ O[O>£ O>}<S U&I&& A{O£U >}O:O &}O£& }A£O> }&{A& }}I(O }?O|: S[}E] :I[?S {E£A< O}?U& SOI:U *SEAI :OU>} O:O&} O£&O> £{OI> O{IU< HU}?> OH?E[ OU>}? O&A%~ O|}*U O<£[< OI&O& O>£E> SEA:} ?U:£S OI:{I :(I>£ I|EA[ <OE*& O>}O> |O&I% EA}H? SSEAH I>}}E }I(OE >I|:S [}E]: I[?S[ :E~O| }I&HO <<*U> I<<S< O}{O( >EH?E HSEA£ O|:S[ }O£}? U&|U[ ?O:}O N}}?O >ON}[ I:}U& }E?O< [HU}? }?O*: O^AO> |SI>I <S&U& SEA>O O£}E£ O|:S[ }}?O| U[?O: }ON}I [:E[E &O£|< I&&I| }UE>< IH&AU }HI&* U<O£I ]IU>& }O^AU *INU> |<I}O }?A:& £ISOC O>U>] &?E:} <SI*} O:}?O |E{[I >S:O[ E:}O£ }?I}I >A>[: O|O£O >}O£? I|(?I £|E{[ :E{U& O£}?O [:UCI }OU>* E:{I} UE>E* I%EA} {U<<U E>[OE [<OU> }?O|E {[<IU >}*U< O£U>[ E:}<I >£E:O *O£O: I<|EA :}A&O :&I<< O]O£O ^AU*I NHI&> O]<U] O>}U> *IU<U >]}E[ :E}O| }|E>& A{O:£ I}I|? EE&U> ]}E&I CO{E> OSU>& }OI£E *&[O> £U>]E>}O|? >U|I< &I*O] AI:£& }?I}| EA<£? ICO&} E[[O£";
        String CharactersInAString ="D L J E L K O K J K O U V C O S I Y M O L I D M R Y M K U C M D C Z K I D V D C D Y L D M C O S I Y M E J K G Y C D V L K O X X J L Y P M Y Q J Y V C B D V D X B L O L K U P O V R K I Y W U L K C U W W U V X Y K K Y M L O S M U W O L Y R B U J K I D K O G U J X R J L Y D X X K G Y V K B L O F X Y K K Y M L L U K I D K W Y D V L K I D K O I D H Y T U K K U D R R Y F K M D G U M R L L J C I D L N Y X X B D V R A U U";
        String chars = "D LJELKOKJKOUV COSIYM OL IDMRYM KU CMDCZ KIDVD CDYLDM COSIYM EJK GY CDV LKOXX JLY PMYQJYVCBDVDXBLOL KU POVR KIY WULK CUWWUV XYKKYMLO SMUWOLYR BUJ KIDK O GUJXR JLY DXX KGYVKB LOFXYKKYML LU KIDK WYDVL KIDK O IDHY TUK KU DRRYFKMD GUMRL LJCI DL NYXXB DVR AUU";
        String s =" FXLLR JEEOP AQYXJ ZXMLB LWMLE EOAPQ KUJGL TDEBH UVGLT NGONP UFXLL RJEEO PNZYX JWGNT MINCV MFWRU OJVCV GBZIZ NXOVF BYXJY IBYEA LRJLB DZSSS ANQFP BQBGL TVGBG GUQKD JVCLQ HLYPN UDESR UASGL TYUFN XONVN IQFLQ HNXOX DTECV MKNNX OBMXD IUNZF NPMNX OYQNH XULBL YSANX OBMXD IUBQN NXOJG XGLTV GBLQH EZAFK YOJRU OMLXB HNYET QYYNR FETOO XSHCK SYXJU OMCUT QEJZS SPPDL NHNZF TLFUY BLBLZ PURKC LBLXX CCUBL BLXFM NPMQL YYWJC HILBL TMMLN HLBLQ GAVKD SBOLB LNAIE LTNXO BZSYX JZXML BLWML NXOYQ NKTQW JTNXO VAYYX JZQOQ LXWPJ EVALB LMGRZ SSHXU LBLYS AMKNG LTVGB EGYNX OABNY XJNXO BFMLQ HBUUT MYVAH NXOEY OYXJO EDPOW NXODD SNXOY MMYXJ CHYZS STMIX YODZS TEJNX OBFML BLNXO KLWYX JLZCA TPECV SANJI IXTTV GBEIF GLTMR WHCWZ ANFTS HXHHL RRFEV GBFIF ZANFT SHXHH LRDVH RFELP DNSIL QHYFH NUDES RUASG LTYUF NXOLZ CNVNH QUHLR VGBYD SNXOF EQYXJ EEOSC YLQHD RLBPW TMIYX JNXOR HPDEJ LRJRY GOJRN XOBMX DIUTM IYXJN XORHP CSOHW GAGQM UCOJR ORHMS PNXOD ZFPNA EUGNZ FLBLN PMMFW TMIPR ILRJY SAAGQ CASNP ZTMIB FMLRJ OJUMF WTMIP RIMKN DDSLB LXYUX RSHVERYSLQ HTMIB FMLRJ AGMNX OXEIQ IOSBK LQHVI HLBLS RLZSS PMXYX JECVN RPHJA JARNC VQMYY ACHUV RGI ";
        //CharacterOccurences(CharactersInAString);
        CharacterOccurences(s);
    }
    public static void CharacterOccurences(String s)
    {
        s = s.replace(" ", "");
        // remove the spaces
         
        char CharacterArray[] = s.toCharArray();
        // s as an array of characters
         
        int[] NumberArray = new int[CharacterArray.length];
        String NumbersAsString = "";
        // need to add nums to string one by one, otherwise you are adding the array object to the string which is illegal
        for (int i = 0; i < CharacterArray.length; i++)
        {
            NumberArray[i] = CharacterArray[(int) i];
             
            //System.out.println(CharacterArray[i]+ "   "+NumberArray[i]+ "   "+CharacterArray[(int)i]);
            // casting the character to a number
            NumbersAsString+=NumberArray[i]+",";
            // need to add the comma after to prevent the error of it seeing this as a number
        }
        NumberOccurences(NumbersAsString);
        // now same as numbers, so we can just call it
    }
    public static void NumberOccurences(String s)
    {
        int[] arr = Arrays.stream(s.substring(0, s.length()).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
        // converts the string of integers into an integer array which also removes the commas
         
        Arrays.sort(arr);
        // sort it in ascending order so it is easier to see the frequencies
        int len=arr[arr.length-1]+1;
        // necessary for getting the length properly
         
        int occurences[]=new int[len];
        for(int n:arr)
        {
            occurences[n]++;
        }
        Map <String,Integer> hm = new HashMap<String,Integer>();
        for(int j=1;j<occurences.length;j++)
        {
            if(occurences[j]>=1)
            {
                //String jj = ""+(char)j;
                //hm.put(jj,occurences[j]);
                System.out.println((char)j+" "+occurences[j]);
                //System.out.println();
                
                // print out the occurrences and its number correspondent
            }
        }
     //  HashMap_Sorting.sortByComparatorStringInteger(hm, true);
       // HashMap_Sorting.printMapValue(hm);
    }
}