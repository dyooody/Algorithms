package algorithm01;

import java.util.Scanner;

public class Worm_1012 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int cnt = 1;
	
	public static void calculate(int[][] land, int N, int M){
		for(int p=0; p<M; p++){
			for(int q=0; q<N; q++){
				if(land[p][q]==1){
					cnt++;
					dfs(land, N, M, p, q);
				}
			}
		}
	}
	
	public static void dfs(int[][] land, int N, int M, int a, int b){
		land[a][b]++;
		
		for(int i=0; i<4; i++){
			int ix = a+dx[i];
			int iy = b+dy[i];
			
			if((-1<ix && ix<M) && (-1<iy && iy<N) && (land[ix][iy]==1)){
				dfs(land, N, M, ix, iy);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int test_case = scan.nextInt();
		
		for(int i=0; i<test_case; i++){
			cnt = 1;
			int M = scan.nextInt();
			int N = scan.nextInt();
			int K = scan.nextInt();
			
			int[][] land = new int[M][N];
			
			for(int k=0; k<K; k++){
				int a = scan.nextInt();
				int b = scan.nextInt();
				land[a][b] = 1;
			}
			
			calculate(land, N, M);
			System.out.println(cnt-1);

		}
		
		scan.close();
	}

}
