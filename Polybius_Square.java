/* a hard coded example of how to take a secret word and fill it into a polybius square.
 * Note: this does not omit any letter, it leaves Z out as it runs past 25,
 * you can easily remove a letter from alpha to get rid of a letter you wont 
 * use a letter for the encryption, eg. Q.
 * */
public class Polybius_Square
{
	public static void main (String args[])
	{
		String alpha = new String(" FXLLR JEEOP AQYXJ ZXMLB LWMLE EOAPQ KUJGL TDEBHUVGLT NGONP UFXLL RJEEO PNZYX JWGNT MINCV MFWRU OJVCV GBZIZ NXOVF BYXJY IBYEA LRJLB DZSSS ANQFP BQBGL TVGBG GUQKD JVCLQ HLYPN UDESR UASGL TYUFN XONVN IQFLQ HNXOX DTECV MKNNX OBMXD IUNZF NPMNX OYQNH XULBL YSANX OBMXD IUBQN NXOJG XGLTV GBLQH EZAFK YOJRU OMLXB HNYET QYYNR FETOO XSHCK SYXJU OMCUT QEJZS SPPDL NHNZF TLFUY BLBLZ PURKC LBLXX CCUBL BLXFM NPMQL YYWJC HILBL TMMLN HLBLQ GAVKD SBOLB LNAIE LTNXO BZSYX JZXML BLWML NXOYQ NKTQW JTNXO VAYYX JZQOQ LXWPJ EVALB LMGRZ SSHXU LBLYS AMKNG LTVGB EGYNX OABNY XJNXO BFMLQ HBUUT MYVAH NXOEY OYXJO EDPOW NXODD SNXOY MMYXJ CHYZS STMIX YODZS TEJNX OBFML BLNXO KLWYX JLZCA TPECV SANJI IXTTV GBEIF GLTMR WHCWZ ANFTS HXHHL RRFEV GBFIF ZANFT SHXHH LRDVH RFELP DNSIL QHYFH NUDES RUASG LTYUF NXOLZ CNVNH QUHLR VGBYD SNXOF EQYXJ EEOSC YLQHD RLBPW TMIYX JNXOR HPDEJ LRJRY GOJRN XOBMX DIUTM IYXJN XORHP CSOHW GAGQM UCOJR ORHMS PNXOD ZFPNA EUGNZ FLBLN PMMFW TMIPR ILRJY SAAGQ CASNP ZTMIB FMLRJ OJUMF WTMIP RIMKN DDSLB LXYUX RSHVE RYSLQ HTMIB FMLRJ AGMNX OXEIQ IOSBK LQHVI HLBLSRLZSS PMXYX JECVN RPHJA JARNC VQMYY ACHUV RGI ");// extend the alphabet to x^2 for bigger square
		String secret = new String("codebook");
		char [][] Poly = new char [(int)Math.sqrt(alpha.length())][(int)Math.sqrt(alpha.length())];
		String holder ="";
		holder = RemoveDups(holder,secret);
		holder = SecretAlphabet(alpha,holder);
		Poly = FillPoly(Poly,holder);
		PrintPoly(Poly);
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
			if (alpha.charAt(a) == temp.charAt(0))
			{
				alpha = alpha.substring(0, a) + alpha.substring(a+1);
				temp = temp.substring(1);
				a=0;
			}
			a++;
		}
		return holder +=alpha;

	}	
	public static char[][] FillPoly(char Poly[][], String holder)
	{
		int a = 0;
		int len = Poly[0].length;
		//System.out.println(len);
		for(int i=0; i<len; i++)
		{
			for(int j=0; j<len; j++)
			{
				Poly[i][j] = holder.charAt(a);
				a++;
			}
		}
		return Poly;
	}
	
	public static char[][] PrintPoly(char Poly [][])
	{
		int len = Poly[0].length;
		for(int i=0; i<len; i++)
		{
			for(int j=0; j<len; j++)
			{
				System.out.print(Poly[i][j]+" ");
			}
			System.out.println();
		}
		return Poly;
	}
}
