package math1;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static long C;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			C = Long.parseLong(st.nextToken());
			
			long ans = go(A, B);
			System.out.println(ans);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static long go(int a, int b) {
		if(b == 0) {
			return 1;
		}
		if(b % 2 == 0) {
			long tmp = go(a, b / 2);
			return (tmp * tmp) % C;
		}
		else {
			return (a * go(a, b - 1)) % C;
		}
	}

}
