package day01;

import java.util.Arrays;
import java.util.List;

public class StringTest {

	public static void main(String[] args) {
		String s="³ª´Â ÇÁ·Î±×·¡¸Ó ½º¸ÓÇÁ¾ß";
		String s2 = "ÁøÂ¥";
		//String : final Å¬·¡½º. immutability(ºÒº¯¼º). ¿øº» ºÒº¯
		System.out.println(s+s2);//¹®ÀÚ¿­ °áÇÕ
		System.out.println(s.concat(s2));
		System.out.println("s: " + s);
		System.out.println(s.charAt(3));
		System.out.println(s.startsWith("³ª´Â")+","+s.endsWith("³ª´Â"));
		//s¿¡¼­ "ÇÁ·Î±×·¡¸Ó" ´Ü¾î¸¦ ÃßÃâÇØ Ãâ·ÂÇÏ¼¼¿ä
		System.out.println(s.substring(3,8));
		//s¿¡¼­ "ÇÁ" ÀÚ°¡ À§Ä¡ÇÑ °÷ÀÇ ÀÎµ¦½º ¹øÈ£¸¦ Ã£¾Æ Ãâ·ÂÇÏ¼¼¿ä
		System.out.println(s.indexOf("ÇÁ"));
		//s¿¡¼­ "ÇÁ" ÀÚ°¡ À§Ä¡ÇÑ °÷ÀÇ ÀÎµ¦½º ¹øÈ£¸¦ µÚ¿¡¼­ Ã£¾Æ Ãâ·ÂÇÏ¼¼¿ä
		System.out.println(s.lastIndexOf("ÇÁ"));
		
		//¹®ÀÚ¿­ ÆíÁı==> StringBuffer(µ¿±âÈ­ ±¸ÇöµÊ), StringBuilder(µ¿±âÈ­ ±¸Çö ¾ÈµÊ)

		System.out.println(s.replace("³ª", "³Ê"));
		
	    String[] tokens= s.split(" ");
	    System.out.println(Arrays.toString(tokens));
	    
	    String str="[ 12, 25, 33, 8, 3,50  ]";
	    
	    System.out.println(str);
	    
	    //[1] str¿¡ ÀúÀåµÈ °ªµéÀÇ ÇÕ°è°ªÀ» Ãâ·Â
		String[] str2 = str.replace("[", "")
			       			.replace("]", "")
			       			.split(",");

		//[2] str¿¡ ÀúÀåµÈ °ªµéÀ» int[] ¹è¿­¿¡ ´ã¾Æ¼­ ¿À¸§Â÷¼ø Á¤·ÄÇØ Ãâ·ÂÇÏ¼¼¿ä
		int[] numbers = new int[str2.length];
		
		int sum=0;
		
		for(int i=0;i<numbers.length;i++) {
			numbers[i] = Integer.parseInt(str2[i].trim());
			sum += numbers[i];
		}
		
		System.out.println("ÇÕ°è: " + sum);
		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));
		
		String s3="Happy";
		
		char[] ch = s3.toCharArray();
		System.out.println(Arrays.toString(ch));
		
		String s4=" 'ÈŞÁö', 'ºí·ç º¼Ææ','Áö¿ì°³',+=-,'¤»¤»','Happy','0101'";
		
		//s4 Æ¯¼ö¹®ÀÚ(+=-') Á¦°ÅÇÑÈÄ Ãâ·Â
		s4=s4.replaceAll("[^¤¡-¤¾¤¿-¤Ó°¡-ÆR,a-zA-z0-9]","");//ÇÑ±ÛÀÌ ¾Æ´Ï¸é ¸ğµÎ ºó¹®ÀÚ¿­ ±³Ã¼
		
		System.out.println(s4);
		
	}

}
