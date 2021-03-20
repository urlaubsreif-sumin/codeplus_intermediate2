package dp9;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][][] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			int N = Integer.parseInt(br.readLine());
			int[] scv = new int[3];
			d = new int[61][61][61];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				scv[i] = Integer.parseInt(st.nextToken());
			}
			
			int res = go(scv[0], scv[1], scv[2]);
			System.out.println(res);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int i, int j, int k) {
		//System.out.println(i + " " + j + " " + k);
		if(i < 0) i = 0;
		if(j < 0) j = 0;
		if(k < 0) k = 0;
		if(i == 0 && j == 0 && k == 0) {
			return 0;
		}
		if(d[i][j][k] != 0) {
			return d[i][j][k];
		}
		int[] attack = {9, 3, 1};
		for(int a = 0; a < 3; a++) {
			for(int b = 0; b < 3; b++) {
				if(a == b)
					continue;
				for(int c = 0; c < 3; c++) {
					if(a == c)
						continue;
					if(b == c)
						continue;
					int res = go(i - attack[a], j - attack[b], k - attack[c]) + 1;
					if(d[i][j][k] == 0 || d[i][j][k] > res) {
						d[i][j][k] = res;
					}
				}
			}
		}
		return d[i][j][k];
	}

}
