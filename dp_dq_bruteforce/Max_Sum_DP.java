package algorithm07;

public class Max_Sum_DP {

	public static int max_sum_dp(int arr[]){
		int maxEndsAt[] = new int[arr.length+1];
		int max = maxEndsAt[0];
		for(int i = 1; i < arr.length; i++){
			maxEndsAt[i] = Math.max(maxEndsAt[i-1] + arr[i], arr[i]);
			if(maxEndsAt[i] > max)
				max = maxEndsAt[i];
		}
		return max;
	}
	public static void main(String[] args) { 
		// TODO Auto-generated method stub
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int ret = max_sum_dp(arr);
		System.out.println(ret);
	}

}
