
import java.util.Arrays;

public class Quick_Sorting {

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
	
	public static int partitionReverse(int[] arr, int p, int r){
		int i = p+1, j = p+1;
		int pivot = arr[p];
		
		while(j<= r){
			if(arr[j] < pivot){
				swap(arr, i, j);
				j++;
				i++;
			}else{
				j++;
			}
		}
		
		swap(arr, i-1, p);
		return i-1;
	}
	
	public static void quicksort(int[] arr, int p, int r){
		if(p < r){
			//int q = partition(arr, p, r);
			int q = partitionReverse(arr, p, r);
			quicksort(arr, p, q-1);
			quicksort(arr, q+1, r);
		}
	}
	
	public static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[]={31, 3, 65, 73, 8, 11, 20, 29, 48, 15};
		printArray(A);
		quicksort(A, 0, 9);
		printArray(A);
	}

}
