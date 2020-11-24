package algorithm01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class HideSeek_1697 {
	
	public static int BFS(int N, int K, int[] arr, int[] visited){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N);
		arr[N] = 0;
		visited[N] = 1;
		
		int[] cal = {1, -1, 2};
		while(!q.isEmpty()){
			int a = q.peek();
			q.poll();
			int res = 0;
			
			for(int i = 0; i <3; i++){
				if(i==2){
					res = a * cal[i];
				}else{
					res = a + cal[i];
				}
				
				if(-1 < res && res <= 100000 && visited[res] == 0){
					visited[res] = 1;
					arr[res] = arr[a] +1;
					if(res == K) break;
					q.add(res);
 				}
			}
			
		}
		return arr[K];
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int K = scan.nextInt();
		
		int[] visited = new int[100001];
		int[] arr = new int[100001];
		for(int i = 0; i < visited.length; i++){
			arr[i] = i;
		}
		
		int result = BFS(N, K, arr, visited);
		System.out.println(result);
		
		scan.close();
	}

}
