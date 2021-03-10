package bf28;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int B;
	static int min = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			go((long)A, 1);
			
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void go(long a, int cnt) {
		if(a == B) {
			if(min == -1 || min > cnt) {
				min = cnt;
			}
		}
		else if(a > B) {
			return;
		}
		go(a * 2, cnt + 1);
		go(a * 10 + 1, cnt + 1);
	}

}
