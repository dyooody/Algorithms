package algorithm06;

import java.util.Scanner;

public class CalPPL {

	 public static void solution(int[] players, int[] bucket, int k) {
		  if(k==0) {
		   int[] oppteam = new int[bucket.length];
		   int j =0, i = 0, l = 0;
		   for(i= 0; i < players.length; i++) {
		    if(j < bucket.length && players[i] < bucket[j])
		     oppteam[l++] = players[i];
		    else if (j == bucket.length)
		     oppteam[l++] = players[i];
		    else
		     j++;
		   }
		   return;
		  }
		  int lastIndex = bucket.length-k-1;
		  
		  for(int i = 0; i < players.length; i++){
			  if(lastIndex == -1)
				  bucket[lastIndex+1] = i;
			  else if(bucket[lastIndex] < players[i])
				  bucket[lastIndex+1] = i;
			  else 
				  continue;
			  solution(players, bucket, k-1);
		  }
		  
		  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		  
		  int num = scan.nextInt();
		  int[][] ppl = new int[num][num];
		  
		  for(int i = 0; i < num; i++) {
		   for(int j = 0; j < num; j++) {
		    int qwe = scan.nextInt();
		    ppl[i][j] = qwe;
		   }
		  }
		  
		  int[] players = new int[num];
		  for(int i = 0; i < num; i++)
		   players[i] = i;
		  int[] bucket = new int[num/2];
		  bucket[0] = 0;
		  solution(players, bucket, num/2-1);
		  
		  scan.close();
	}

}
