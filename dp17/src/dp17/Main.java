package dp17;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][][][] d;
	static boolean find = false;
	static char[] ans;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); //±Ê¿Ã
			int K = Integer.parseInt(st.nextToken()); //Ω÷
			d = new int[N + 1][N + 1][N + 1][K + 1];
			ans = new char[N];
			
			for(int a = 0; a <= N; a++) {
				for(int b = 0; b <= N - a; b++) {
					if(go(N, a, b, K) == 1) {
						break;
					}
				}
				if(find) {
					break;
				}
			}
			
			if(!find) {
				sb.append(-1);
			}
			else {
				for(int i = 0; i < N; i++) {
					sb.append(ans[i]);
				}
			}
			
			System.out.println(sb.toString());
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int l, int a, int b, int p) {
		//System.out.println(l + " " + a + " " + b + " " + p);
		if(find)
			return -1;
		if(a < 0 || b < 0 || p < 0)
			return -1;
		if(d[l][a][b][p] != 0) {
			return d[l][a][b][p];
		}
		if(l == 0) {
			if(a == 0 && b == 0 && p == 0) {
				find = true;
				return 1;
			}
			return -1;
		}
		if(go(l - 1, a - 1, b, p) == 1) {
			d[l][a][b][p] = 1;
			ans[l - 1] = 'A';
		}
		else if(go(l - 1, a, b - 1, p - a) == 1) {
			d[l][a][b][p] = 1;
			ans[l - 1] = 'B';
		}
		else if(go(l - 1, a, b, p - a - b) == 1) {
			d[l][a][b][p] = 1;
			ans[l - 1] = 'C';
		}
		else {
			d[l][a][b][p] = -1;
		}
		return d[l][a][b][p];
	}

}
