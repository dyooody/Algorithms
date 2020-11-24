package algorithm06;

import java.util.Scanner;

public class Bucket_Web {
	static int min = 0;
	static int check = 0;
	
	public static void swap(int[] arr, int a, int b){
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static int partition(int[] arr, int p, int r){
		int i = p, j = p;
		int pivot = arr[r];
		
		while(j<= r){
			if(arr[j] < pivot){
				swap(arr, i, j);
				j++;
				i++;
			}else{
				j++;
			}
		}
		
		swap(arr, r, i);		
		return i;
	}
	
	public static void quicksort(int[] arr, int p, int r){
		if(p < r){
			int q = partition(arr, p, r);
			quicksort(arr, p, q-1);
			quicksort(arr, q+1, r);
		}
	}

	public static int average(int[] arr){
		int avg;
		int sum = 0;
		for(int i = 0; i < arr.length; i++){
			sum += arr[i];
		}
		avg = sum/arr.length;
		
		return avg;
	}
	
	public static int MSE(int[] arr){
		int avg = average(arr);
		
		int mse = 0;
		for(int i = 0; i < arr.length; i++){
			int res = arr[i]-avg;
			mse += Math.pow(res, 2);
		}
		
		return mse;
	}
	
	public static void combination(int[] arr, int[] items, int k, int[] carry){
		if(k == 0){ 
			int ret = divide(carry, arr);
			if(check == 0){
				check++;
				min = ret;
			}
			else if(check !=0){
				if(min > ret){
					min = ret;
				}
			}
			return;
		}
		int lastIndex = carry.length-k-1;
		
		for(int i = 0; i < items.length; i++){
			if(carry.length == k){ //First time to choose
				carry[0] = items[i];
				combination(arr, items, k-1, carry);
			}else if(carry[lastIndex] < items[i]){ //Choosing numbers in order 
				carry[lastIndex+1] = items[i];
				combination(arr, items, k-1, carry);
			}
		}
	}
	
	public static int divide(int[] carry, int[] arr){
		int len = carry.length;
		int[][] arrays = new int[len+1][];
		
		for(int i = 0 ; i <= len; i++){
			int start;
			if(i == 0){
				start = 0;
			}else start = carry[i-1];
			
			int end;
			if(i == len){
				end = arr.length;
			}else end = carry[i];
			int mm = end-start;
			int[] res = new int[mm];
			for(int j = 0; j < mm; j++){
				res[j] = arr[start+j];
			}
			arrays[i] = res;
		}
		
		int mse = 0; 
		for(int p = 0; p < arrays.length; p++){
			mse += MSE(arrays[p]);
		}
		return mse;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int bucket = scan.nextInt();
		
		int[] numbers = new int[input];
		
		for(int i = 0; i < input; i++){
			numbers[i] = scan.nextInt();
		}
		
		int[] items = new int[input-1];
		for(int i = 0; i < input-1; i++){
			items[i] = i+1;
		}
		
		quicksort(numbers, 0, input-1);
		int[] carry = new int[bucket-1];
		combination(numbers, items, bucket-1, carry);
		System.out.println(min);
		scan.close();
	}
}
