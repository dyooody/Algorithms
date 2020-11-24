package algorithm02;

import java.util.Scanner;

public class Playing_Cards {	
	//card 도 입력받을 수 있게 만들어보기
	
	public static int[][] cards ={
			{1,2,3,4,5,6,7,8},
			{1,2,3,4,9,10,11,12},
			{1,2,5,6,9,10,13,14},
			{1,3,5,7,9,11,13,15}		
	};
	
	public static String[] answer ={
			"YYYY",
			"YYYN", //해서 string compare해서 간단하게 찾을 수 있다.
			"YYNY",
			"YYNN",
			"YNYY",
			"YNYN",
			"YNNY",
			"YNNN",
			"NYYY",
			"NYYN",
			"NYNY",
			"NYNN",
			"NNYY",
			"NNYN",
			"NNNY"
			
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String input_answer = scan.nextLine();
		scan.close();
		
		for(int i =0; i < 15; i++){
			if(input_answer.compareTo(answer[i])== 0){
				System.out.println(i+1);
			}
				
		}

	}

}
