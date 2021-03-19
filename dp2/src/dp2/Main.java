package dp2;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] d;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			d = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				d[i] = -1;
			}
			
			d[0] = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 1; j <= arr[i]; j++) {
					if(d[i] == -1 || i + j >= N)
						break;
					if(d[i + j] == -1 || d[i + j] > d[i] + 1) {
						d[i + j] = d[i] + 1;
					}
				}
			}
			
			System.out.println(d[N - 1]);
			
			
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}
	public static int go(int cur, int cnt) {
		if(cur >= N) {
			return - 1;
		}
		if(cur == N - 1) {
			return cnt;
		}
		if(d[cur] != -1 && d[cur] < cnt) {
			return d[cur];
		}
		int min = 1500;
		for(int i = 1; i <= arr[cur]; i++) {
			int tmp = go(cur + i, cnt + 1);
			if(tmp < 0) {
				continue;
			}
			min = Math.min(min, tmp);
		}
		d[cur] = min;
		return min;
	}
}
