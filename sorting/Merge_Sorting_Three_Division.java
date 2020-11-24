package practices;

import java.util.Arrays;
import java.util.Random;

public class Merge_Sorting_Three_Division {
	
	public static double before, after = 0;
	static int len = 100000;
	static int[] temp = new int[len];
	
	public static void mergeSort(int[] arr, int p, int r){
		if(p < r){
			int a = p + ((r-p)/3);
			int b = p + 2*((r-p)/3);
			mergeSort(arr, p, a);
			mergeSort(arr, a+1, b);
			mergeSort(arr, b+1, r);
			merge(arr, p, a, b, r);
		}
	}
	
	public static void merge(int[] arr, int p, int a, int b, int r){
		int i = p, j = a+1, k = b+1;
		int t = p;
		
		
		while(i<=a && j<=b && k<=r){
			if(arr[i]<arr[j]){ 
				if(arr[i]<arr[k]){
					temp[t++] = arr[i++];
				}else{
					temp[t++] = arr[k++];
				}
			}else{
				if(arr[j] < arr[k]){
					temp[t++] = arr[j++];
				}else{
					temp[t++] = arr[k++];
				}
			}				
		}
		
		
		while(i<=a && j<=b){
			if(arr[i]<arr[j]){
				temp[t++] = arr[i++];
			}else{
				temp[t++] = arr[j++];
			}
		}
		
		while(j<=b && k<=r){
			if(arr[j]<arr[k]){
				temp[t++] = arr[j++];
			}else{
				temp[t++] = arr[k++];
			}
		}
		
		while(i<=a && k<=r){
			if(arr[i]<arr[k]){
				temp[t++] = arr[i++];
			}else{
				temp[t++] = arr[k++];
			}
		}
		
		while(i <= a){
			temp[t++] = arr[i++];
		}
		while(j <= b){
			temp[t++] = arr[j++];
		}
		while(k <= r){
			temp[t++] = arr[k++];
		}
		
		for(int g=p; g<=r; g++){
			arr[g] = temp[g];
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
		
		/*int A[]={31, 3, 65, 73, 8, 11, 20, 29, 48, 15};
		printArray(A);
		mergeSort(A, 0, 9);
		printArray(A);*/
		
		Random r = new Random();
		
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = r.nextInt()+1;
		}
		System.out.println();
		System.out.println("------------------------");
		
		
		before = System.currentTimeMillis();
		
		mergeSort(arr, 0, len-1);
		//boolean is = isSorted(arr);
		
		after = System.currentTimeMillis();
		System.out.println(" time " + (after-before));
	}

}
