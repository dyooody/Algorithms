package algorithm02;

import java.util.Scanner;

public class Finding_Path_In_Fantasia {
	
	public static void finding_path(int x, int y){
		int p = x;
		int q = y;
		
		int p1 = 1;   
		int p2 = 0;
		
		int q1 = 1;
		int q2 = 0;
		
		while( p1 + p2 != p && q1 + q2 != q){
			if((p1+p2)/(double)(q1+q2) < p/(double)q){
				System.out.print("R");
				p2+=p1;
				q1+=q2;
			}else if((p1+p2)/(double)(q1+q2) > p/(double)q){
				System.out.print("L");
				p1+=p2;
				q2+=q1;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		
		finding_path(a,b);
		//System.out.println(result);

	}

}
