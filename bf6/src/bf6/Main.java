package bf6;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int W, H;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(br.readLine());
			int[][] stickers = new int[N][2];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				stickers[i][0] = Integer.parseInt(st.nextToken());
				stickers[i][1] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			if(N == 1) {
				System.out.println(0);
				return;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					int size = stickers[i][0] * stickers[i][1] + stickers[j][0] * stickers[j][1];
					if(go(stickers[i][0], stickers[i][1], stickers[j][0], stickers[j][1])) {
						;
					}
					else if(go(stickers[i][1], stickers[i][0], stickers[j][0], stickers[j][1])) {
						;
					}
					else if(go(stickers[i][0], stickers[i][1], stickers[j][1], stickers[j][0])) {
						;
					}
					else if(go(stickers[i][1], stickers[i][0], stickers[j][1], stickers[j][0])) {
						;
					}
					else {
						continue;
					}
					max = size > max ? size : max;
				}
			}
			
			System.out.println(max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean go(int r1, int c1, int r2, int c2) {
		if(Math.max(r1, r2) <= W && c1 + c2 <= H)
			return true;
		else if(r1 + r2 <= W && Math.max(c1, c2) <= H)
			return true;
		else if(Math.max(r1, r2) <= H && c1 + c2 <= W)
			return true;
		else if(r1 + r2 <= H && Math.max(c1, c2) <= W)
			return true;
		return false;
	}

}
