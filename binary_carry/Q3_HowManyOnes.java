package algorithm01;

import java.util.Scanner;

public class Q3_HowManyOnes {
	
	/*public static int countOnes(int n) {
		int ret = 0;
		while(n!=0) {
			ret++;
			n /= 10;
			if(ret >= 40) return 0;
		}
		return ret;
	}
		 
	public static boolean hasAllOnes(int n) {
		while(n != 0) 
		{
			int t = n%10;
			if( t != 1) return false;
			n = n/10;
		}
			return true;
	}*/
	
	public static int countOnes1(String number)
	{
		return number.length();
	}
	
	
	public static boolean hasAllOnes1(String number) {
		char[] n = number.toCharArray();
		for(int i = 0; i< n.length; i++){
			if(n[i] != '1')
				return false;
		}
		return true;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan = new Scanner(System.in);
		 String number = scan.next();
		 scan.close();
		 //System.out.println(number.length());
		 int c = 1;
		 String t = number;
		 String upshot = number;
		 
		 while( !hasAllOnes1( upshot )) {
		 //while( c < 11 ) {	 
			 /*if(upshot.length() >= 7){
				 System.out.println("not found");
				 break;
			 }*/
		 	 c++;
			 int[] res = new int[t.length()+(int)Math.log10(c)+1];
			 //System.out.println("res.length(): "+res.length);
			 
			 //System.out.println("c: "+c);
			 char[] n = t.toCharArray();
			 //System.out.println("-------------------");
			 int s = c;
			 int move = 0;
			 while(s != 0){
				 int k = s%10; 
				 int carry = 0;
				 //System.out.println("s%10: "+k);
				 //System.out.println("-------------------");
				 for(int i = 0; i < t.length(); i++){
					 
						//c *= Character.getNumericValue(n[i]);
					 	
						int f = n[t.length()-1-i]-'0';				
						//System.out.println("i =" + (i+move) +" num: "+f);
						
						res[i+move] += k * f +carry;
						//System.out.println("res[i+move]: "+res[i+move]);
						carry = res[i+move]/10;
						res[i+move] = res[i+move]%10;
						
						//System.out.printf("res[%d]: %d\n", i+move, res[i+move]);
						//System.out.println("carry: "+ carry);
					} 
				
				 	res[t.length()+move] += carry;
				 	//System.out.printf("res[%d]: %d\n" ,t.length()+move, res[t.length()+move]);
				 	s = s/10;
				 	move++;
				 	//System.out.println("move = " + move);
					
			 }
			 
			 StringBuffer result = new StringBuffer();
			 int i = res.length-1;
			 
			 while(i>0 && res[i]==0){
				 i--;
			 }
			 while(i>=0){
				 result.append(res[i]);
				 i--;
			 }
			 upshot = result.toString();
			 //System.out.println("upshot: "+ upshot);
			 
		}	
		 System.out.println("final C: "+c);
		 System.out.println(upshot);
		 System.out.println(countOnes1(upshot));                                                                                                                                                               

	}

}
