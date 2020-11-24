package algorithm08;

public class LongestIncreasingSubsequence {
	 
	 public static int LIS(int[] arr, int idx) {
	  if(idx == 0) return 1;
	  
	  int max = 1;
	  for(int i = 0; i < idx; i++) {
	   if(arr[i] < arr[idx]) {
	    int ret = LIS(arr, i)+1;
	    if(max < ret) max = ret;
	   }
	  }
	  
	  return max;
	  
	 }
	 
	 public static int LIS_memo(int[] arr, int idx, int[] memo) {
	  if(idx == 0) return 1;
	  if(memo[idx] != 0) return memo[idx];
	  
	  int max = 1;
	  for(int i = 0; i < idx; i++) {
	   if(arr[i] < arr[idx]) {
	    int ret = LIS_memo(arr, i, memo)+1;
	    if(max < ret) max = ret;
	   }
	  }
	  
	  memo[idx] = max;
	  return memo[idx];
	  
	 }
	 
	 public static int LISDriver(int[] arr) {
	  int max = 1;
	  for(int i =0; i < arr.length; i++) {
	   int ret = LIS(arr, i);
	   if(max < ret) max= ret;
	  }
	  return max;
	 }
	 
	 public static int LISDriver_memo(int[] arr, int[] memo) {
	  int max = 1;
	  for(int i =0; i < arr.length; i++) {
	   int ret = LIS_memo(arr, i, memo);
	   if(max < ret) max=ret;
	  }
	  return max;
	 }
	 
	 public static int LIS_dp(int[] arr) {
		  int dp[] = new int[arr.length];
		  for(int i = 0; i < dp.length; i++)
		   dp[i] = 0;
		  //first index -> ������ ������ count�� �ϸ鼭 �����ؾ� �ϴϱ�. 
		  dp[0] = 1;
		  int max = dp[0];
		  
		  //�ð� ���⵵: O(n^2);
		  //outer loop�� dp�� ���� array�� idx i ���� longest ���� ��Ÿ��
		  //inner loop �� idx i �� ������ ���� logest �� ??? ���ϴ� �� ���� i��9v ������ �Ǿ� �տ��� ���� ���鼭 Ȯ���� �ϴ� loop�� j - variable
		  for(int i = 1; i<arr.length; i++) {
		   int local_max = 0;
		   for(int j = 0; j<i; j++) {
			   //memo�� normal ������� for(int i = 0; i < idx; i++) �� ���� �κ�.  
		    if(arr[j] < arr[i]) {
		     int ret = dp[j]+1;
		     if(local_max < ret) local_max = ret;
		    }
		   }
		   
		   dp[i] = local_max;
		   if(max < dp[i]) max = dp[i];
		  }
		 return max;
	} 

	 public static void main(String[] args) {
	  // TODO Auto-generated method stub

	  int[] arr1 = {3, 2, 7, 5, 6, 1};
	  int[] memo = new int[arr1.length];
	  
	  int[] arr2 = {1,10,5,20,15,10,30,49,25,35,66,75,44};
	  int[] memo2 = new int[arr2.length];
	  //int asdf = LISDriver(arr);
	  int asdf = LISDriver_memo(arr1, memo);
	  int wwww = LISDriver_memo(arr2, memo2);
	  
	  int gggg = LIS_dp(arr1);
	  int aaaa = LIS_dp(arr2);
	  System.out.println(asdf);
	  System.out.println(wwww);
	  System.out.println("-------------------");
	  
	  System.out.println(gggg);
	  System.out.println(aaaa);
	  
	 }

	}
