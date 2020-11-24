import java.util.Scanner;

public class HowManyOnes_basic {
	
	public static int countAllOnes(int n){
		int ret = 0;
		while(n != 0){
			ret++;
			n /= 10;
		}
		
		return ret;
	}
	
	public static boolean hasAllOnes(int n){
		while(n != 0){
			int t = n%10;
			if(t != 1) return false;
			n = n/10;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		scan.close();
		
		int c = 1;
		int t = number;
		
		while ( !hasAllOnes(t)){
			c++;
			t = number*c;
		}
		
		System.out.println(t);
		System.out.println(countAllOnes(t));

	}

}
