package dp18;
import java.io.*;

public class Main {
	static int[][][][][] d;
	static StringBuilder sb = new StringBuilder();
	static boolean find = false;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String S = br.readLine();
			int a = 0, b = 0, c = 0;
			for(int i = 0; i < S.length(); i++) {
				if(S.charAt(i) == 'A') {
					a++;
				}
				else if(S.charAt(i) == 'B') {
					b++;
				}
				else if(S.charAt(i) == 'C') {
					c++;
				}
			}
			
			d = new int[a + 1][b + 1][c + 1][3][3];
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(i == 1 && j == 1) continue;
					if(i == 2 && j == 2) continue;
					if(go(a, b, c, i, j) == 1) {
						System.out.println(sb.toString());
						return;
					}
				}
			}
			
			System.out.println(-1);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	
	public static int go(int a, int b, int c, int p1, int p2) {
		if(find)
			return -1;
		if(a == 0 && b == 0 && c == 0)
			return 1;
		if(a < 0 || b < 0 || c < 0)
			return -1;
		if(d[a][b][c][p1][p2] != 0) {
			return d[a][b][c][p1][p2];
		}
		int res = -1;
		if(p1 == 0 && p2 == 0) {
			if(go(a - 1, b, c, 0, 0) == 1 || go(a - 1, b, c, 1, 0) == 1 || go(a - 1, b, c, 2, 0) == 1 ) {
				sb.append('A');
				res = 1;
			}
		}
		else if(p1 == 0 && p2 == 1) {
			if(go(a, b - 1, c, 0, 0) == 1 || go(a, b - 1, c, 1, 0) == 1 || go(a, b - 1, c, 2, 0) == 1) {
				sb.append('B');
				res = 1;
			}
		}
		else if(p1 == 0 && p2 == 2) {
			if(go(a, b, c - 1, 0, 0) == 1 || go(a, b, c - 1, 1, 0) == 1) {
				sb.append('C');
				res = 1;
			}
		}
		else if(p1 == 1 && p2 == 0) {
			if(go(a - 1, b, c, 0, 1) == 1 || go(a - 1, b, c, 2, 1) == 1) {
				sb.append('A');
				res = 1;
			}
		}
		else if(p1 == 1 && p2 == 2) {
			if(go(a, b, c - 1, 0, 1) == 1) {
				sb.append('C');
				res = 1;
			}
		}
		else if(p1 == 2 && p2 == 0) {
			if(go(a - 1, b, c, 0, 2) == 1 || go(a - 1, b, c, 1, 2) == 1) {
				sb.append('A');
				res = 1;
			}
		}
		else if(p1 == 2 && p2 == 1) {
			if(go(a, b - 1, c, 0, 2) == 1 || go(a, b - 1, c, 1, 2) == 1) {
				sb.append('B');
				res = 1;
			}
		}
		
		if(res == 1) {
			d[a][b][c][p1][p2] = 1;
			find = true;
		}
		else {
			d[a][b][c][p1][p2] = -1;
		}
		return d[a][b][c][p1][p2];
	}

}
