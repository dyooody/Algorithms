package algorithm07;

public class Max_Sum_Divide_Conquer {
	
	public static int max_sum_dc(int arr[], int l, int r){
		int mid = (l+r)/2;
		if( l == r ) return arr[l];
		
		int max = 0;
		int lv = max_sum_dc(arr, l, mid);
		int rv = max_sum_dc(arr, mid+1, r);
		
		max = lv>rv?lv:rv;
		
		int cv = 0;
		
		int local_max = arr[mid+1];
		int local_sum = 0;
		for(int i = mid+1; i <= r; i++){
			local_sum += arr[i];
			if(local_max < local_sum)
				local_max = local_sum;
		}
		
		cv += local_max;
		
		local_max = arr[mid];
		local_sum = 0;
		for(int i= mid; i>=l; i--){
			local_sum += arr[i];
			if(local_max < local_sum)
				local_max = local_sum;
		}
		
		cv += local_max;
		
		max = max>cv?max:cv;
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int result = max_sum_dc(arr, 0, 7);
		System.out.println(result);

	}

}
