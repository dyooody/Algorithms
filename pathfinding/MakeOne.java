package algorithm08;

import java.util.Scanner;

public class MakeOne {
	static int cnt = 0;
	
	public static int minop(int x){
		cnt++;
		//System.out.println("x: "+x);
		if(x==1) return 0;
		
		int min = x+1;
		if(x%3==0){
			int ret = minop(x/3)+1;
			min = (min>ret)?ret:min; 
		}
		if(x%2==0){
			int ret = minop(x/2)+1;
			min = (min>ret)?ret:min;
		}
		int ret = minop(x-1)+1;
		min = (min>ret)?ret:min;
		
		return min;
	}

	public static int minmemo(int x, int[] memo){
		cnt++;
		if(x==1) return 0;
		if(memo[x] != 0) return memo[x];
		
		int min = x+1;
		if(x%3==0){
			int ret = minmemo(x/3, memo)+1;
			min = (min>ret)?ret:min;
		}
		if(x%2==0){
			int ret = minmemo(x/2, memo)+1;
			min = (min>ret)?ret:min;
		}
		int ret = minmemo(x-1, memo)+1;
		min = (min>ret)?ret:min;
		
		memo[x] = min;
		return memo[x];
	}
	
	public static int mindp(int x){
		cnt++;
		int[] dp = new int[x+1];
		int ret = 0;
		
		for(int i = 2; i <= x; i++){
			int min = x+1;
			if(i%3==0){
				ret = dp[i/3]+1;
				min = (min>ret)?ret:min;
			}
			if(i%2==0){
				ret = dp[i/2]+1;
				min = (min>ret)?ret:min;
			}
			ret = dp[i-1]+1;
			min = (min>ret)?ret:min;
			dp[i] = min;
		}
		
		return dp[x];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		int res = minop(num);
		System.out.println(res + " cnt: " + cnt);
		
		cnt=0;
		int[] memo = new int[num+1];
		int tt = minmemo(num, memo);
		System.out.println(tt+ " cnt: " + cnt);
		
		cnt=0;
		int dp = mindp(num);
		System.out.println(dp+ " cnt: " + cnt);
		
		
		scan.close();
	}

}
