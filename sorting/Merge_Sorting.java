package practices;

import java.util.Arrays;
import java.util.Random;

public class Merge_Sorting {
	
	public static long before, after = 0;
	public static int cnt = 0;
	
	public static void mergeSort(int[] array, int p, int r){
		if( p < r ){
			int q = (p+r)/2;
			mergeSort(array, p, q);
			mergeSort(array, q+1, r);
			merge(array, p, q, r);
		}
	}
	
	public static void merge(int[] arr, int p, int q, int r){
	
		int i = p, j = q+1;
		int t = p;
		int[] temp = new int[arr.length];
		
		while(i<=q && j<=r){
			if(arr[i] < arr[j]){
				temp[t++] = arr[i++];
			}else{
				temp[t++] = arr[j++];
			}
		}
		
		//if second part of the array is left after sorting -> put left elements to temp
		while(j <= r){
			temp[t++] = arr[j++];
		}
		
		while(i <= q){
			temp[t++] = arr[i++];
		}
		
		for(int k = p; k <= r; k++){
			arr[k] = temp[k];
		}
	}
	
	public static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++)
            if(arr[i] > arr[i + 1])
                return false;
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int len = 1600000;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = r.nextInt(100)+1;
		}
		System.out.println();
		
		before = System.currentTimeMillis();
		
		mergeSort(arr, 0, len-1);
		//boolean is = isSorted(arr);
		
		after = System.currentTimeMillis();
		System.out.println( " time " + (after-before));

	}

}
