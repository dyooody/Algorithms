package practices;

import java.util.Arrays;

public class Comparison_Sorting {

	public static int[] CountingSort(int[] a, int[] b, int k){
		int[] c = new int[k];
		for(int i = 0; i < k; i++){
			c[i] = 0;
		}
		for(int j = 0; j<a.length; j++){
			c[a[j]-1] = c[a[j]-1]+1;
		}
		for(int i = 1; i < k; i++){
			c[i] = c[i]+c[i-1];
		}
		for(int j = a.length-1; j>=0; j--){
			b[c[a[j]-1]-1] = a[j];
			c[a[j]-1]--;
		}
		
		return b;
	}
	
	public static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {4, 1, 3, 4, 3};
		int[] b = new int[a.length];
		
		printArray(a);
		int[] c = CountingSort(a, b, 4);
		printArray(c);

	}

}
