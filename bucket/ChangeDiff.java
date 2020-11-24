package algorithm06;

public class ChangeDiff {

	 public static int solve(int[] items, int[] bucket, int k , int change) {
		  int last_index = bucket.length  -k -1;
		  int sum = 0;
		  for(int i = 0; i<= last_index; i++)
		   sum += bucket[i];
		  
		  if( sum == change) {
		   for(int i = 0; i <= last_index; i++)
		    System.out.print(bucket[i] + " ");
		   System.out.println();
		   return 1;
		  }
		  
		  if(k == 0) return 0;
		  int count = 0;
		  for(int i = 0; i < items.length; i++) {
		   if(last_index == -1 || bucket[last_index] <= items[i]) {
		    bucket[last_index+1] = items[i];
		    count += solve(items,bucket, k-1, change);
		    
		   }
		  }return count;
		 }
		 
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		int change = 170;
		int items[] = {10, 50, 100, 500};
		int bucket_size = change/10;
		  
		int bucket[] = new int[bucket_size];
		  
		System.out.println(solve(items, bucket, bucket_size, change));
		  
	}

}
