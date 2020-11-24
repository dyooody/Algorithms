package algorithm03;

import java.util.Scanner;

public class Automobile {
	
	public static int [][] path = new int[21][21];
	
	public static double visit(int num, double east, double west, double south, 
			double north, int x, int y){
		
		//if non-promising, return 0;
		if(path[x][y] == 1){ 
			return 0;
		}
		
		//base condition
		if(num == 0) return 1;
		
		path[x][y] = 1;
		
		double ret = visit(num-1, east, west, south, north, x+1, y)*east;
		ret = ret + visit(num-1, east, west, south, north, x-1, y)*west;
		ret = ret + visit(num-1, east, west, south, north, x, y-1)*north;
		ret = ret + visit(num-1, east, west, south, north, x, y+1)*south;
		
		path[x][y] = 0; //한쪽으로 쭉 갔을 때 겹치지 않아야 하기 때문에, 동쪽 10 과 동쪽9,서쪽1은 다르기 때문에 
		return ret;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < 21; i++){
			for (int j = 0; j < 21; j++){
				path[i][j] = 0;
				//System.out.print(path[i][j]);
			}
		}
		
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		double east = scan.nextDouble();
		double west = scan.nextDouble();
		double south = scan.nextDouble();
		double north = scan.nextDouble();
		scan.close();
		int x = 10; int y = 10;
		
		double result = visit(num, east, west, south, north, x, y);
		System.out.println(result);

	}

}
