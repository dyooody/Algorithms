package algorithm07;

import java.util.HashMap;
import java.util.Scanner;

public class Clock {
	static int min = 0;
	static int cnt1 = 0, cnt2 = 0;
	
	public static boolean CheckClock(int[] clock_group){
		boolean result = false;
		int k = 0;
		
		for(int i = 0; i < clock_group.length; i++){
			if(clock_group[i] != 12) k++;
		}		
		if(k == 0) result = true;
		
		return result;
	}
	
	public static int[] ChangeClock(int[] bucket, int[] clock_group,
			HashMap<Integer, int[]> switches){
		int[] changed_clock = new int[clock_group.length];
		
		for(int p = 0; p < clock_group.length; p++){
			changed_clock[p] = clock_group[p];
		}
		
		for(int i = 0; i < bucket.length; i++){
			if(bucket[i] != 0){
				for(int j = 0; j < switches.get(i).length; j++){
					changed_clock[switches.get(i)[j]] += 3*bucket[i];
					if(changed_clock[switches.get(i)[j]] > 12){
						changed_clock[switches.get(i)[j]] -= 12;
					}
				}
			}
		}
		
		return changed_clock;
	}
	
	/*public static void ChangeClock(int[] bucket, int[] clock_group,
			HashMap<Integer, int[]> switches){
		cnt2++;
		for(int i = 0; i < bucket.length; i++){
			if(bucket[i] != 0){
				for(int j = 0; j < switches.get(i).length; j++){
					clock_group[switches.get(i)[j]] += 3*bucket[i];
					if(clock_group[switches.get(i)[j]] > 12){
						clock_group[switches.get(i)[j]] -= 12;
					}
				}
			}
		}
	}*/

	public static void ClockCalculate(int[] items, int[] bucket, int[] clock_group, 
			HashMap<Integer, int[]> switches, int num){
		
		if(num == 0){
			cnt1++;
			/*for(int i = 0; i < bucket.length; i++){
				System.out.print(bucket[i]+" ");
			}System.out.println();
			*/
			int[] change = ChangeClock(bucket, clock_group, switches);
			
			boolean test = CheckClock(change);
			
			if(test){
				int res = 0;
				//System.out.println("true!!!!!!!!!!!!!!!!!");
				for(int i = 0; i < bucket.length; i++){
					System.out.print(bucket[i]+ " ");
					res += bucket[i];
				}
				//System.out.println(": "+res);
				
				if(min == 0){
					min = res;
				}else if(min != 0 && min > res){
					min = res;
				}
			}
			return;
		}
		
		int lastIndex = bucket.length-num-1;
			
		for(int t = 0; t < items.length; t++){
			bucket[lastIndex+1] = items[t];
			ClockCalculate(items, bucket, clock_group, switches, num-1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		HashMap<Integer, int[]> switches = new HashMap<Integer, int[]>();
		switches.put(0, new int[] {0,1,2});
		switches.put(1, new int[] {3,7,9,11});
		switches.put(2, new int[] {4,10,14,15});
		switches.put(3, new int[] {0,4,5,6,7});
		switches.put(4, new int[] {6,7,8,10,12});
		switches.put(5, new int[] {0,2,14,15});
		switches.put(6, new int[] {3,14,15});
		switches.put(7, new int[] {4,5,7,14,15});	
		switches.put(8, new int[] {1,2,3,4,5});
		switches.put(9, new int[] {3,4,5,9,13});
		
		//System.out.println("input switches-----");		
		/*for(int i = 0; i <= 9; i++){
			//System.out.println("input key and vals");
			int key = scan.nextInt();
			int num = scan.nextInt();
			int[] vals = new int[num];
			//System.out.println(vals.length);
			for(int j = 0; j < num; j++){
				//System.out.println("");
				vals[j] = scan.nextInt();
			}
			switches.put(key, vals);
			//System.out.println(vals.toString().length());
		}*/
		
		//System.out.println("input clocks------------");
		int clock1 = scan.nextInt();
		int	clock2 = scan.nextInt();
		int clock3 = scan.nextInt();
		int clock4 = scan.nextInt();
		int clock5 = scan.nextInt();
		int clock6 = scan.nextInt();
		int clock7 = scan.nextInt();
		int clock8 = scan.nextInt();
		int clock9 = scan.nextInt();
		int clock10 = scan.nextInt();
		int clock11 = scan.nextInt();
		int clock12 = scan.nextInt();
		int clock13 = scan.nextInt();
		int clock14 = scan.nextInt();
		int clock15 = scan.nextInt();
		int clock16 = scan.nextInt();
		
		int[] clock_group = {clock1, clock2, clock3, clock4, clock5, clock6, clock7
				, clock8, clock9, clock10, clock11, clock12, clock13, clock14
				, clock15, clock16};

		int[] items = {0,1,2,3};
		int[] bucket = new int[switches.size()];
	
		ClockCalculate(items, bucket, clock_group, switches, bucket.length);
		
		System.out.println("final result: "+min+ " cnt1 :" + cnt1+ " cnt2: "+ cnt2);
		scan.close();
	}

}
