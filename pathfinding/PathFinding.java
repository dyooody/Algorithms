public class PathFinding {
	
	 /*static int[][] graph = 
	   {{1,1,1,1,1,1,1,1},
	   {1,1,1,1,1,1,1,1},
	   {1,1,1,1,1,1,1,1},
	   {1,1,1,1,1,1,1,1},
	   {1,1,1,1,1,1,1,1},
	   {1,1,1,1,1,1,1,1},
	   {1,1,1,1,1,1,1,2},
	   {1,1,1,1,1,1,2,0}};*/
	 
	 static int[][] graph = 
	    {{2, 5, 1, 6, 1, 3, 1},
	    {6, 7, 1, 2, 4, 3, 7},
	    {7, 2, 3, 2, 1, 3, 2},
	    {2, 5, 3, 1, 8, 1, 4},
	    {3, 1, 2, 3, 4, 2, 2},
	    {2, 2, 3, 4, 1, 2, 1},
	    {1, 9, 5, 2, 8, 7, 0}};
	 
	 
	 //moveTrough using memo
	 public static boolean moveThrough(int[][] memo, int x, int y) {
		 if(x >= graph.length) return false;
		 if(y >= graph.length) return false;
		  
		 if(memo[x][y] != -1) return memo[x][y] == 1;
		 
		 if(x == graph.length-1 && y == graph.length-1)
		   return true;
		  
		 memo[x][y] = 0;
		  
		 if(moveThrough(memo, x+graph[x][y], y)) memo[x][y] = 1;
		 if(moveThrough(memo, x, y+graph[x][y])) memo[x][y] = 1;
		  
		 return memo[x][y] == 1;
	 }

	 
	 //moveThrough using DP 
	 //loop 돌릴 때 dependency를 확인해주어야 한다. 
	 //한 줄 (오른쪽 방향으로) array의 값을 살펴본다. 
	 //1: path가 존재한다는 뜻 -> 그러면 path를 확장한다. 0,0 -> i,j 까지의 경로가 있따. 
	 public static boolean moveDP() {
		  int[][] dp = new int[graph.length][graph.length];
		  /*for(int i = 0 ; i < graph.length; i++) {
			  for(int j = 0; j < graph.length; j++) {
		      dp[i][j] = 0;
		      }
		  }*/
		  
		  dp[0][0] = 1;
		  
		  for(int i = 0; i < graph.length; i++) {
		   for(int j = 0; j < graph.length; j++) {
		    if(dp[i][j] == 1) {
		     if(i + graph[i][j] < graph.length)
		      dp[i+graph[i][j]][j] = 1;
		     if(j + graph[i][j] < graph.length) 
		      dp[i][j+graph[i][j]] = 1;
		    }
		   }
		  }
		  
		  return dp[graph.length-1][graph.length-1] == 1;
	 }


	// 최초에 메모 값이 없으면 recursion으로 계산을 해서 memo에 넣고, memo값이 있으면 메모값을 return 해준다. 
	 public static void main(String[] args) {
	  // TODO Auto-generated method stub
	  
	  int memo[][] = new int[graph.length][graph.length];
	  for(int i = 0 ; i < graph.length; i++) {
	   for(int j = 0; j < graph.length; j++) {
	    memo[i][j] = -1;
	   }
	  }
	  
	  for(int i = 0 ; i < graph.length; i++) {
		   for(int j = 0; j < graph.length; j++) {
		    System.out.print(memo[i][j]+" ");
		   }System.out.println();
	 }
	  
	  System.out.println(moveThrough(memo, 0,0));
	  //System.out.println(graph.length);
	  for(int i = 0 ; i < graph.length; i++) {
		   for(int j = 0; j < graph.length; j++) {
		    System.out.print(memo[i][j]+" ");
		   }System.out.println();
	 }
	  
	  //System.out.println(moveDP());

	}

}
