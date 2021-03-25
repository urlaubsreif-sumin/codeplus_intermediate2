package math4;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		try {
			n = Integer.parseInt(br.readLine());
			long prev = 0;
			long cur = 0;
			for(int i = 0; i < n; i++) {
				if(cur == 0) {
					cur = 1;
				}
				else {
					long tmp = cur;
					cur = cur + prev;
					prev = tmp;
				}
			}
			
			System.out.println(cur);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

}
