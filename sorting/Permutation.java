package practices;

import java.util.Scanner;

public class Permutation {
	
	static int cnt = 0;
	
	public static void solution_Repetition(int[] items, int[] bucket, int k){
		
		if(k == 0){ //No more to choose 
			cnt++;
			for(int i = 0; i < bucket.length; i++){
				System.out.print(bucket[i]+" ");
			}System.out.println();
			return;
		}
		
		int lastIndex = bucket.length-k-1;
		for(int i=0; i<items.length; i++){
			bucket[lastIndex+1] = items[i];
			solution_Repetition(items, bucket, k-1);
		}
	}
	
	public static void solution(int[] items, int[] bucket, int k){
		cnt++;
		if(k == 0){ //No more to choose 
			for(int i = 0; i < bucket.length; i++){
				System.out.print(bucket[i]+" ");
			}System.out.println();
			return;
		}
		
		int lastIndex = bucket.length-k-1;
		for(int i=0; i<items.length; i++){
			
			int flag = 0;
			for(int j = 0; j<=lastIndex; j++){
				if(bucket[j] == items[i]) 
					flag = 1;
			}
			if(flag == 1) continue;
			
			
			bucket[lastIndex+1] = items[i];
			solution(items, bucket, k-1);
		}
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] items = {0,1,2,3,4,5,6,7};
		int[] items = {1,2,3,4};
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		int[] bucket = new int[num];
		
		//solution(items, bucket, num);
		System.out.println(cnt);
		cnt = 0;
		solution_Repetition(items, bucket, num);
		System.out.println(cnt);
	}

}
