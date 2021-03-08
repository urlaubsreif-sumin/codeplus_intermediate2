package bf18;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static boolean[] check;
	static int[][] calc;
	static int N, M, K;
	static int min = -1;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			arr = new int[N][M];
			calc = new int[K][3];
			check = new boolean[K];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				calc[i][0] = Integer.parseInt(st.nextToken()) - 1;
				calc[i][1] = Integer.parseInt(st.nextToken()) - 1;
				calc[i][2] = Integer.parseInt(st.nextToken());
			}
			
			go(-1, 0);
			
			System.out.println(min);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void go(int n, int cnt) {
		if(cnt == K) {
			int res = minsum();
			if(min == -1 || min > res) {
				min = res;
			}
			return;
		}
		for(int i = 0; i < K; i++) {
			if(check[i]) {
				continue;
			}
			check[i] = true;
			rotate(calc[i][0], calc[i][1], calc[i][2]);
			go(n, cnt + 1);
			reverse_rotate(calc[i][0], calc[i][1], calc[i][2]);
			check[i] = false;
		}
	}
	
	public static void rotate(int r, int c, int k) {
		for(int s = 1; s <= k; s++) {
			int temp = arr[r - s][c - s];
			for(int i = -s; i < s; i++) {
				arr[r + i][c - s] = arr[r + i + 1][c - s];
			}
			for(int i = -s; i < s; i++) {
				arr[r + s][c + i] = arr[r + s][c + i + 1];
			}
			for(int i = s; i > -s; i--) {
				arr[r + i][c + s] = arr[r + i - 1][c + s];
			}
			for(int i = s; i > -s; i--) {
				arr[r - s][c + i] = arr[r - s][c + i - 1];
			}
			arr[r - s][c - s + 1] = temp;
		}
	}
	
	public static void reverse_rotate(int r, int c, int k) {
		for(int s = 1; s <= k; s++) {
			int temp = arr[r - s][c - s];
			for(int i = -s; i < s; i++) {
				arr[r - s][c + i] = arr[r - s][c + i + 1];
			}
			for(int i = -s; i < s; i++) {
				arr[r + i][c + s] = arr[r + i + 1][c + s];
			}
			for(int i = s; i > -s; i--) {
				arr[r + s][c + i] = arr[r + s][c + i - 1];
			}
			for(int i = s; i > -s; i--) {
				arr[r + i][c - s] = arr[r + i - 1][c - s];
			}
			arr[r - s + 1][c - s] = temp;
		}
	}
	
	public static int minsum() {
		int mn = 0;
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += arr[i][j];
			}
			if(mn == 0 || mn > sum) {
				mn = sum;
			}
		}
		return mn;
	}

}
