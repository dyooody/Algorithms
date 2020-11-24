package algorithm07;

public class Max_Sum_Brute_Force_Algorithm {
	
	public static int max_sum_brute(int arr[], int n){
		int max = arr[0];
		for(int i = 0; i < n; i++){
			int local_max = arr[i];
			int sum = arr[i];
			for(int j = i+1; j < n; j++){
				sum += arr[j];
				if(local_max < sum)
					local_max = sum;
			}
			if(max < local_max)
				max = local_max;
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int len = arr.length;
		int result = max_sum_brute(arr, len);
		System.out.println(result);

	}

}
