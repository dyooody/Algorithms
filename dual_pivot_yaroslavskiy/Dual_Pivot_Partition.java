package algorithm05;

import java.util.Random;

public class Dual_Pivot_Partition {
	
	static double before, after = 0;
	static int cnt1, cnt2 = 0;
	
	private static void swap(int[] a, int i, int j) {
		 int temp = a[i];
		 a[i] = a[j];
		 a[j] = temp;
	}
		
	private static void insertionSort(int[] arr, int p, int r){
		cnt1++;
		int j;
		for(int i = p+1; i <= r; i++){
			for(j = 0; j<i; j++){
				if(arr[j] > arr[i])
					break;
			}
			int temp = arr[i];
			for(int z = i; z>j; z--){
				arr[z] = arr[z-1];
			}
			arr[j] = temp;
		}
		return;
	}
	
	private static void dualPivot(int[] arr, int p, int r, int small_length) {
		cnt2++;
		int len = r - p;
		if (len < small_length) {
			insertionSort(arr, p, r);
			return;
		}
		 
		int parts = len / 3;
		int l = p + parts;
		int g = r - parts;
		
		if (arr[l] >= arr[g]) {
			swap(arr, l, r);
			swap(arr, g, p);
		}
		else {
			swap(arr, l, p);
			swap(arr, g, r);
		}
		
		int pivot1 = arr[p];
		int pivot2 = arr[r];
		
		//pivot1 must be less than pivot2
		if(pivot1 > pivot2){
			int temp = pivot1;
			pivot1 = pivot2;
			pivot2 = temp;
		}
		
		int i = p+1;
		int j = r-1;
		
		for(int k = i; k <=j; k++){
			if(arr[k]< pivot1){
				swap(arr, k , i);
				i++;
			}else if(arr[k]> pivot2){
				while (k < j && arr[j] > pivot2) {
					 j--;
				 }
				 swap(arr, k, j--);
			
				 if (arr[k] < pivot1) {
					 swap(arr, k, i++);
				 }
			}
		}
		 
		swap(arr, i - 1, p);
		swap(arr, j + 1, r);
		
		dualPivot(arr, p, i - 2, small_length);
		dualPivot(arr, j + 2, r, small_length);
		
		if (pivot1 < pivot2) {
			dualPivot(arr, i, j, small_length);
		}
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
		int len = 200000;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = r.nextInt(5000)+1;
		}
		
		before = System.currentTimeMillis();
		
		int sub = 33;
		dualPivot(arr, 0, len-1, sub);
		boolean is = isSorted(arr);
		
		after = System.currentTimeMillis();
		System.out.println(is + " time " + (after-before));
		
	}

}
