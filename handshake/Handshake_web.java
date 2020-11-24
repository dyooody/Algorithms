package algorithm03;

import java.util.HashMap;
import java.util.Scanner;

public class Handshake_web {
	
	public static long Handshake(int num, HashMap<Integer,Long> memo) {
		if(memo.containsKey(num)){
			return memo.get(num);
		}else if(num == 2 || num == 0){
			return 1;
		}else{
			long sum = 0;			
			for(int k = 0; k < num/2; k++){
				sum += Handshake(k*2, memo)*Handshake((num-2)-(k*2), memo);
				memo.put(num, sum);
			}
			return sum;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int people = scan.nextInt();
		HashMap<Integer, Long> mem = new HashMap<Integer, Long>();
		
		long result = Handshake(people, mem);
		System.out.println(result);

		scan.close();
	}

}
