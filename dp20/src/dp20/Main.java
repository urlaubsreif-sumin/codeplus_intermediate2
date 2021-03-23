package dp20;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][][][] d;
	static int cnt = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int dot = Integer.parseInt(st.nextToken());
			int kes = Integer.parseInt(st.nextToken());
			int hong = Integer.parseInt(st.nextToken());
			
			d = new int[S + 1][dot + 1][kes + 1][hong + 1];
			
			for(int i = 0; i < S + 1; i++) {
				for(int j = 0; j < dot + 1; j++) {
					for(int k = 0; k < kes + 1; k++) {
						for(int q = 0; q < hong + 1; q++) {
							d[i][j][k][q] = -1;
						}
					}
				}
			}
			
			int res = go(S, dot, kes, hong);
			System.out.println(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int t, int dot, int k, int h) {
		//System.out.println(t + " " + dot + " " + k + " " + h);
		if(t == 0) {
			if(dot == 0 && k == 0 && h == 0) {
				return 1;
			}
			else {
				return 0;
			}
		}
		if(dot < 0 || k < 0 || h < 0) {
			return 0;
		}
		if(d[t][dot][k][h] != -1) {
			return d[t][dot][k][h];
		}
		
		d[t][dot][k][h] = 0;
		
		if(t < dot + k + h) {
			d[t][dot][k][h] = (d[t][dot][k][h] + (go(t - 1, dot - 1, k - 1, h) % 1000000007)) % 1000000007;
			d[t][dot][k][h] = (d[t][dot][k][h] + (go(t - 1, dot - 1, k, h - 1) % 1000000007)) % 1000000007;
			d[t][dot][k][h] = (d[t][dot][k][h] + (go(t - 1, dot, k - 1, h - 1) % 1000000007)) % 1000000007;
			d[t][dot][k][h] = (d[t][dot][k][h] + (go(t - 1, dot - 1, k - 1, h - 1) % 1000000007)) % 1000000007;
		}
		
		d[t][dot][k][h] = (d[t][dot][k][h] + (go(t - 1, dot - 1, k, h) % 1000000007)) % 1000000007;
		d[t][dot][k][h] = (d[t][dot][k][h] + (go(t - 1, dot, k - 1, h) % 1000000007)) % 1000000007;
		d[t][dot][k][h] = (d[t][dot][k][h] + (go(t - 1, dot, k, h - 1) % 1000000007)) % 1000000007;
		
		return d[t][dot][k][h] % 1000000007;
	}
}
