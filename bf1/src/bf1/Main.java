package bf1;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();
			
			int ans = 1;
			for(int i = 0; i < input.length(); i++) {
				if(i == 0 || input.charAt(i - 1) != input.charAt(i)) {
					ans *= input.charAt(i) == 'c' ? 26 : 10;
				}
				else if(input.charAt(i) == 'c') {
					ans *= 25;
				}
				else if(input.charAt(i) == 'd') {
					ans *= 9;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
