package algorithm01;

import java.util.Scanner;

public class Q1_Binary_Carry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int a = scanner.nextInt();	
		int b = scanner.nextInt();
		scanner.close();
		
		int carry = 0;
		int cnt = 0;
		
		while( a != 0 || b != 0) 
		{
		   int s = a % 2;
		   int t = b % 2;
		   
		   carry = (s + t + carry) / 2;
		   
		   if(carry == 1) cnt++;
		   
		   a = a/2;
		   b = b/2;
		   
		} 
		
		System.out.println(cnt);
	}

}
