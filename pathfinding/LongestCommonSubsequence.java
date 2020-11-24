package algorithm08;

public class LongestCommonSubsequence {
	
	public static int LCS(int[] one, int[] two, int a, int b){
		if(a == 0 || b == 0) return 0;
		else if(one[a-1] == two[b-1]){
			return LCS(one, two, a-1, b-1) + 1;
		}else{
			return Math.max(LCS(one, two, a-1, b), LCS(one, two, a, b-1));
		}
	}

	public static int LCS_dp(int[] one, int[] two, int a, int b){
		int dp[][] = new int[a+1][b+1];
		
		for(int i = 0; i <= a; i++){
			for(int j = 0; j <= b; j++){				
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}else if(one[i-1] == two[j-1]){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[a][b];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] one = {2,1,4,2};
		int[] two = {1,2,3,2,4,1,2};
		
		int ret = LCS(one, two, one.length, two.length);
		System.out.println(ret);
		int res = LCS_dp(one, two, one.length, two.length);
		System.out.println(res);
	}

}
