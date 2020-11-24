import java.util.Scanner;

public class Finding_Palindrome {

	public static char[] Basic_Palindrome(String words){
		String buffer = words;
		StringBuffer palin = new StringBuffer(words);
		
		int i = 0;
		while(!Is_It_Palindrome(palin.toString().toCharArray())){
			System.out.println("palin: "+palin);
			System.out.println("dd: "+buffer.charAt(i));
			palin.insert(words.length(), buffer.charAt(i++));
		}
		
		return palin.toString().toCharArray();
		
	}
	
	public static boolean Is_It_Palindrome(char[] char_words){
		char[] char_reverse = new char[char_words.length];
		int j = 0;
		for(int i = char_words.length-1; i >= 0 ; i--){
			char_reverse[j++] = char_words[i];
		}
		for(int i = 0; i < char_words.length; i++){
			if(char_reverse[i] != char_words[i])
				return false;
		}
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		String input_words = scan.nextLine();
		scan.close();
		
		char[] result = Basic_Palindrome(input_words);
		System.out.println("result: "+ String.valueOf(result));
	}

}
