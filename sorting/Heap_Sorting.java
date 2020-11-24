package practices;

import java.util.Arrays;

public class Heap_Sorting {
	
	public static void Min_Heapify(int[] arr, int n, int i){
		if(2*i > arr.length) return;
		
		int l = 2*i+1;
		int r = 2*i+2;
		int smallest = i;
		
		if(l < n && arr[l] < arr[smallest])
			smallest = l;
		if(r < n && arr[r] < arr[smallest])
			smallest = r;
		if(smallest != i){
			int swap = arr[i];
	        arr[i] = arr[smallest];
	        arr[smallest] = swap;
	          
	        Min_Heapify(arr, n, smallest);
		}
	}

	public static void Max_Heapify(int[] arr, int n, int i){
		if(2*i > arr.length){
			return;
		}
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i;
		
		if (l < n && arr[l] > arr[largest])
		     largest = l;

		if (r < n && arr[r] > arr[largest])
		     largest = r;

		if (largest != i)
		{
			int swap = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = swap;
	          
	        Max_Heapify(arr, n, largest);
		}
	}
	
	public static void BuildMaxHeap(int[] arr){
		//int size = arr.length;
		int len = arr.length;
		for(int i = len/2 -1; i>=0; i--){
			Max_Heapify(arr, len, i);
		}		
	}
	
	public static void BuildMinHeap(int[] arr){
		int len = arr.length;
		for(int i = len/2-1; i>=0; i--){
			Min_Heapify(arr, len, i);
		}
	}
	
	public static void MinHeapSort(int[] arr){
		BuildMinHeap(arr);
		for(int i = arr.length-1; i>=0; i--){
			int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
			Min_Heapify(arr, i, 0);
		}
	}
	
	public static void HeapSort(int[] arr){
		BuildMaxHeap(arr);
		for(int i = arr.length-1; i>=0; i--){
			int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
			Max_Heapify(arr, i, 0);
		}
	}
	
	public static void printArray(int[] arr){
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]={31, 3, 65, 73, 8, 11, 20, 29, 48, 15};
		printArray(A);
		
		/*Heap_Sorting heap = new Heap_Sorting();
		heap.HeapSort(A);*/
		HeapSort(A);
		printArray(A);
		MinHeapSort(A);
		printArray(A);

	}

}
