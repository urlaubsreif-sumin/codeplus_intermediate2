package bf25;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N, M, H;
	static int[][] arr;
	static int min = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			arr = new int[H][N];
			
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int pos = Integer.parseInt(st.nextToken()) - 1;
				int from = Integer.parseInt(st.nextToken()) - 1;
				arr[pos][from] = 1;
				arr[pos][from + 1] = 2;
			}
			
			if(!go()) {
				add(0);
			}
			else {
				System.out.println(0);
				return;
			}
			
			System.out.println(min);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean go() {
		for(int i = 0; i < N; i++) {
			int cur = i;
			for(int h = 0; h < H; h++) {
				if(arr[h][cur] == 1) {
					cur++;
				}
				else if(arr[h][cur] == 2) {
					cur--;
				}
			}
			if(cur != i) {
				return false;
			}
		}
		return true;
	}
	
	public static void add(int cnt) {
		if(cnt == 3) {
			return;
		}
		for(int i = 0; i < N - 1; i++) {
			for(int h = 0; h < H; h++) {
				if(arr[h][i] == 0 && arr[h][i + 1] == 0) {
					arr[h][i] = 1;
					arr[h][i + 1] = 2;
					if(go()) {
						if(min == -1 || min > cnt + 1) {
							min = cnt + 1;
						}
						arr[h][i] = 0;
						arr[h][i + 1] = 0;
						return;
					}
					add(cnt + 1);
					
					arr[h][i] = 0;
					arr[h][i + 1] = 0;
				}
			}
		}
		return;
	}

}
