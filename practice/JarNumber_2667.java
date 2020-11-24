package algorithm01;

import java.util.Arrays;
import java.util.Scanner;

public class JarNumber_2667 {	

	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	//the value of cnt means already searched -> value of cnt will be number of jar group
	static int cnt = 1;
	static int[] count;

	public static void Calculate(int[][] jar, int N){
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(jar[i][j] == 1){
					DFS(i, j, jar, ++cnt);
				}
			}
		}
		
		count = new int[cnt];
		for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				if(jar[i][j] > 1){ 
					count[jar[i][j]-2]++;
				}
			}
		}
	}
	
	
	
	public static void DFS(int x, int y, int jar[][], int k){
		jar[x][y] = k;
		for(int i = 0; i < 4; i++){
			int ix = x + dx[i];
			int iy = y + dy[i];
			
			if((-1 < ix && ix < jar.length) && (-1 < iy && iy < jar.length)
					&& jar[ix][iy]==1){
				DFS(ix, iy, jar, k);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[][] jar = new int[N][N];		
		
		for(int i = 0; i < N; i++){
			String num = scan.next();
			char[] chars = num.toCharArray();
			for(int j = 0; j < N; j++){
				jar[i][j] = Character.getNumericValue(chars[j]);
			}
		}
		
		/*for(int k = 0; k < N; k++){
			for(int q = 0; q < N; q++){
				System.out.print(jar[k][q]+" ");
			}System.out.println();
		}*/
		
		Calculate(jar, N);
		
		System.out.println(cnt-1);
		Arrays.sort(count);
		
		for(int p=0; p<count.length; p++){
			if(count[p] != 0){
				System.out.println(count[p]);
			}
		}
		
		scan.close();

	}

}
