package algorithm05;

import java.util.Random;

public class Dual_Example {
	
	static double before, after = 0;
	
	/*public static void quicksort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }
    */
	
	public static void swap(int[] arr, int a, int b){
		int temp;
		temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	private static void insertionSort(int[] arr, int p, int r){
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
	
    private static void quicksort(int[] arr, int p, int r, int small_length) { 
    	if (r <= p)
            return;
    	
    	int len = r-p;
    	if (len < small_length) {
			insertionSort(arr, p, r);
			return;
		}
    	
        if (arr[r] < arr[p])
            swap(arr, p, r);

        int lt = p + 1;
        int gt = r - 1;
        int i  = p + 1;
        
        while (i <= gt) {
            if (arr[i] < arr[p])
                swap(arr, lt++, i++);
            else if (arr[i] > arr[r])
                swap(arr, i, gt--);
            else
                i++;
        }
               
        swap(arr, p, --lt);
        swap(arr, r, ++gt);

        quicksort(arr, p, lt - 1, small_length);
        quicksort(arr, lt + 1, gt - 1, small_length);
        quicksort(arr, gt+1, r, small_length);
    }
    
    public static boolean isSorted(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++)
            if(arr[i] > arr[i + 1])
                return false;
        return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Random r = new Random();
		//int len = r.nextInt(25)+1;
		int len = 500;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = r.nextInt(200)+1;
			//System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("------------------------");
		quicksort(arr, 0, arr.length-1);
		boolean is = isSorted(arr);
		System.out.println(is);
		for(int i = 0; i < len; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();*/
		
		
		Random r = new Random();
		int len = 400000;
		int[] arr = new int[len];
		for(int i = 0; i < len; i++){
			arr[i] = r.nextInt(500)+1;
		}
		
		before = System.currentTimeMillis();
		
		int sub = 513;
		quicksort(arr, 0, len-1, sub);
		boolean is = isSorted(arr);
		
		after = System.currentTimeMillis();
		System.out.println(is + " time " + (after-before));
	}

}
