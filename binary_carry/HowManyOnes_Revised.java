package algorithm01;

import java.util.Scanner;

public class HowManyOnes_Revised {
	
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
		
		String num = number;
		int cnt = 1;
		
		while(!hasAllOnes1(num)){
			if(num.length() > 40){
				System.out.println("number not found");
				break;
			}
	
			cnt++;
			char[] s1 = number.toCharArray(); 
			char[] s2 = num.toCharArray();
			//s2's length is always longer
			
			StringBuilder res = new StringBuilder();
			int carry = 0;
			for(int i = s2.length-1, j = s1.length-1; j >= 0 ; i--, j--){
				int a = s1[j]-'0';
				int b = s2[i]-'0';
				int c = (a + b + carry)%10; 
				carry = (a + b + carry)/10;
				res.append(c);
			
 			}
			
			for(int i = s2.length-s1.length-1; i >= 0; i--){
				int a = s2[i]-'0';
				int c = (a + carry)%10;
				//System.out.println("	b: "+a+" c: "+c+" carry ="+carry);
				carry = (a + carry)/10;
				res.append(c);
			}
			
			if(carry != 0){
				res.append(carry);
			}
			
			String result = res.reverse().toString();
			num = result;			
		}
		System.out.println(countOnes1(num));
		System.out.println("cnt :"+cnt);
	}

}
