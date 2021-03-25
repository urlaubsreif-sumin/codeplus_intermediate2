package math3;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine()) + 1;
			
			int prev = 0;
			int cur = 0;
			for(int i = 1; i < n; i++) {
				if(cur == 0) {
					cur = 1;
				}
				else {
					int tmp = cur;
					cur = cur + prev;
					prev = tmp;
				}
			}
			
			System.out.println(cur);

			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
