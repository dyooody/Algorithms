package algorithm06;

public class SalaryAllocation {
	static String org[] = {
			"NYYNN",
			"NNNNN",
			"NNNYY",
			"NYNNN",
			"NNNNN"
		};
			 
	public static int getSalary(int eid, int[] memo) {
		if(memo[eid] != 0) return memo[eid];
		System.out.println("EID " + eid);
		
		int ret = 0;
		char p[] = org[eid].toCharArray();
		for(int i = 0; i<p.length; i++) {
			if(i!= eid && p[i] == 'Y')
				ret = ret+getSalary(i, memo);
		}
		ret = ret == 0 ? 1 : ret; 
		memo[eid] = ret;
		
		return ret;
			  
	}

	public static int getSalary() throws Exception{
		int[] memo = new int[org.length];
		int total = 0;
		//for(int i = 0; i < memo.length; i++)
		// memo[i] = 0;
		for(int i = 0; i<org.length; i++)
			total = total + getSalary(i, memo);
		//Thread.currentThread().sleep(100);
		return total;
		}
			 
	public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub\
		long start_time = System.currentTimeMillis();
		int total = getSalary();
		long end_time = System.currentTimeMillis();
		System.out.println("Total Salary "+ total);
		System.out.println("Time for computation "+ (end_time - start_time) + "ms");
		
	}


}
