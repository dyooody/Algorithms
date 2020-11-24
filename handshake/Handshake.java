import java.util.HashMap;
import java.util.Scanner;

public class Handshake {
	
	static double before, after = 0;
	static int cnt = 0;
	
	public static long handShaking_DP(int n){
		cnt++;
		long hand[] = new long[n+1];
		
		hand[0] = 1;
		hand[2] = 1;
		
		for(int i = 4; i <= n; i = i+2){
			long sum = 0;
			for(int j = 0; j < i; j = j+2){
				sum += hand[j]*hand[i-j-2];
			}
			hand[i] = sum;
		}
		
		return hand[n];
	}
	
	
	
	public static long Handshaking(int num){
		cnt++;
		//System.out.println("Handshake("+num+")");
		if(num == 2 || num == 0) return 1;
		else{
			long sum = 0;
			for(int k = 0; k<num/2; k++){
				sum += Handshaking(k*2)*Handshaking((num-2)-(k*2));
			}
			return sum;
		}
	}
	
	public static long Handshake(int num, HashMap<Integer,Long> memo) {
		cnt++;
		//System.out.println("Handshake("+num+")");
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
	
	public static long Handshake_memo(int num, long[] memo){
		cnt++;
		//System.out.println(num);
		if(memo[num] > 0) return memo[num];
		if(num == 2 || num == 0){
			memo[num] = 1;
		}else{
			//long sum = 0;
			for(int k = 0; k < num/2; k++){
				memo[num] += Handshake_memo(k*2, memo)*Handshake_memo((num-2)-(k*2), memo);
				//memo[num] = sum;
			}
		}
		return memo[num];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int people = scan.nextInt();
		
		long[] memo = new long[people+1];
		long ret = Handshake_memo(people, memo);
		System.out.println("Handshake_memo " + ret + " cnt " + cnt);
		cnt = 0;
		
		HashMap<Integer, Long> mem = new HashMap<Integer, Long>();
		long result = Handshake(people, mem);
		System.out.println("Handshake_hashmap " + result + " cnt " + cnt);
		cnt = 0;
		
		
		/*
		
		before = System.currentTimeMillis();
		long result = Handshake(people, mem);
		after = System.currentTimeMillis();
		System.out.println(result + " time " + (after-before) + " cnt " + cnt);
		
		
		cnt = 0;
		System.out.println("_____________________________");
		before = System.currentTimeMillis();
		long result1 = Handshaking(people);
		after = System.currentTimeMillis();
		System.out.println(result1 + " time " + (after-before) + " cnt " + cnt);*/
		
		long result1 = Handshaking(people);
		System.out.println("Handshake normal "+ result1 + " cnt " + cnt);
		
		cnt = 0;
		long result2 = handShaking_DP(people);
		System.out.println("DP "+ result2 + " cnt " + cnt);
		
		
		scan.close();
	}

}
