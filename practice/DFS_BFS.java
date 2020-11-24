import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS_BFS_1260 {
	
	public static void DFS(int node, int[][] arr, int[] visited){
		visited[node] = 1;
		System.out.print(node+" ");
		for(int i = 1; i < arr.length; i++){
			if(arr[node][i] == 1 && visited[i] == 0){
				DFS(i, arr, visited);
			}
		}
	}
	
	public static void BFS(int node, int[][] arr, int[] visited){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(node);
		visited[node] = 1;
		System.out.print(node+" ");
		
		while(!q.isEmpty()){
			int a = q.peek();
			q.poll();
			for(int i = 1; i < arr.length; i++){
				if(arr[a][i]==1 && visited[i] ==0){
					visited[i] = 1;
					q.add(i); 
					System.out.print(i+" ");
					
				}
			}
			
		}
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int vertex = scan.nextInt();
		int edge = scan.nextInt();
		int pivot = scan.nextInt();
		
		
		//vertex와 edge를 입력한 후에는 항상 행렬로 만들어야 하는 것 같다. 0,0이 생기니까 size-> vertex+1
		int[][] res = new int[vertex+1][vertex+1];
		for(int i = 0; i < edge; i++){
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			
			res[node1][node2] = 1;
			res[node2][node1] = 1;
		}
		
		for(int k = 0; k < vertex+1; k++){
			for(int q = 0; q < vertex+1; q++){
				System.out.print(res[k][q]+" ");
			}System.out.println();
		}
		
		//because of 0,0 size of visited array is vertex+1
		int[] visited = new int[vertex+1];
		System.out.println("visited's length: "+visited.length);
		
		DFS(pivot, res, visited);
		System.out.println();
		int[] visited2 = new int[vertex+1];
		BFS(pivot, res, visited2);
		
		scan.close();

	}

}
