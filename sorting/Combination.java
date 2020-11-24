package practices;

import java.util.HashMap;
import java.util.Scanner;

public class Combination {
	static int cnt = 0; 
	public static void solution(int[] items, int[] bucket, int k){
		cnt++;
		if(k == 0){ //No more to choose 
			for(int i = 0; i < bucket.length; i++){
				System.out.print(bucket[i]+" ");
			}System.out.println();
			return;
		}
		int lastIndex = bucket.length-k-1;
		
		for(int i = 0; i < items.length; i++){
			if(bucket.length == k){ //First time to choose
				bucket[0] = items[i];
				solution(items, bucket, k-1);
			}else if(bucket[lastIndex] < items[i]){ //Choosing numbers in order 
				bucket[lastIndex+1] = items[i];
				solution(items, bucket, k-1);
			}
		}
	}
	
	public static void solutionMemoization(int[] items, int[] bucket, int k, int[] memo){
		cnt++;
		if(memo[k] > 0) solution_Repetition(items, bucket, k-1);
		
		if(k == 0){ //No more to choose 
			for(int i = 0; i < bucket.length; i++){
				System.out.print(bucket[i]+" ");
			}System.out.println();
			return;
		}
		int lastIndex = bucket.length-k-1;
		
		for(int i = 0; i < items.length; i++){
			if(bucket.length == k){ //First time to choose
				bucket[0] = items[i];
				solutionMemoization(items, bucket, k-1, memo);				
			}else if(bucket[lastIndex] <= items[i]){ //Choosing numbers in order 
				bucket[lastIndex+1] = items[i];
				solutionMemoization(items, bucket, k-1, memo);
			}
		}
	}
	
	//Combination with Repetition
	public static void solution_Repetition(int[] items, int[] bucket, int k){
		cnt++; 
		if(k == 0){ //If there is no more to choose
			//for(int i = 0; i < bucket.length; i++){
				//System.out.print(bucket[i]+" ");
			//}System.out.println();
			return;
		}
		
		int lastIndex = bucket.length-k-1;
		
		for(int i = 0; i < items.length; i++){
			if(bucket.length == k){
				bucket[0] = items[i];
				solution_Repetition(items, bucket, k-1);
			}else if(bucket[lastIndex] <= items[i]){
				bucket[lastIndex+1] = items[i];
				solution_Repetition(items, bucket, k-1);
			}
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] items = {0,1,2,3,4,5,6,7};
		int[] items = {0,1,2};
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int[] bucket = new int[num];
	
		solution(items, bucket, num);
		System.out.println(cnt);
		System.out.println("-------------------------------");
		cnt = 0;
		solution_Repetition(items, bucket, num);
		System.out.println("Repetition cnt: "+cnt);
		cnt = 0;
		
		int[] memo = new int[num+1];
		solutionMemoization(items, bucket, num, memo);
		System.out.println("Memoization cnt: "+cnt);
		
		scan.close();
	}	

}
