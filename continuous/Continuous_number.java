import java.util.Scanner;

public class Continuous_Number {
	
	public static boolean solution(int[] items, int[] bucket, int k, int target){
		if(k==0){
			int sum = 0;
			for(int i = 0; i< bucket.length; i++)
				sum = sum + bucket[i]*(i+1);
				
			if( sum == target) {
				for(int j = 0; j< bucket.length; j++){
					if(bucket[j] == 1) System.out.print("+");
					else System.out.print("-");
					System.out.print(j+1);
				}
				System.out.println();
				return true;
			}
			return false;
		}
		int lastIndex = bucket.length-k-1;
		boolean ret = false;
		
		for(int i = 0; i < items.length; i++){
			bucket[lastIndex+1] = items[i];
			ret = solution(items, bucket, k-1, target) || ret;
		}
		return ret;
	}
	
	public static int sumN(int n){
		return n*(n+1)/2;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] items = {1, -1};
		Scanner scan = new Scanner(System.in);
		int target = scan.nextInt();
		
		int n = 1;
		while(sumN(n) < target){
			n++;
		}
		//System.out.println(n);
		
		int bucket[] = new int[n+1];
		solution(items, bucket, n+1, target);
		
		scan.close();
		
	}

}
