package practices;

public class PowerSet {
	
	private static char data[] = {'a','b','c','d','e','f'};
	private static int len = data.length;
	private static boolean[] include = new boolean[len];
	
	static int cnt = 0;
	
	public static void powerSet(int k){
		cnt++;
		if(k == len){
			for(int i = 0; i < len; i++){
				if(include[i]) System.out.print(data[i]+" ");
			}System.out.println();
			return;
		}
		include[k] = false;
		powerSet(k+1);
		include[k] = true;
		powerSet(k+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		powerSet(2);
		System.out.println("cnt : "+ cnt);
	}

}
