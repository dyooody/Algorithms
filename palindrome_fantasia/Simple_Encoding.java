package algorithm02;

import java.util.Scanner;

public class Simple_Encoding {
	
	public static int getEncodedNumber_opt(int arr[]){
		int max = 1;
		int min_idx = 0;
		for(int i =0; i< arr.length; i++){
			if( arr[min_idx] > arr[i])
				min_idx = i;
		}
		
		arr[min_idx]++;
		for(int i=0; i<arr.length; i++){
			max = max*arr[i];
		}
		arr[min_idx]--;
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		
		int[] num_array = new int[num];
		
		for(int i = 0; i < num; i++){
			num_array[i] = scan.nextInt();
		}
		int result = getEncodedNumber_opt(num_array);
		
		scan.close();
		System.out.println(result);

	}

}
