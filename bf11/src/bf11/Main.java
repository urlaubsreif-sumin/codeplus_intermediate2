package bf11;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] seq;
	static int[] init;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			N = Integer.parseInt(br.readLine());
			seq = new int[N];
			init = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
				init[i] = seq[i];
			}
			if(N == 1) {
				System.out.println(0);
				return;
			}
			int change = -1;
			//a0와 a1을 결정하면 공차가 구해진다.
			//각 숫자별로 최대 한 번 연산할 수 있으므로, 가능한 a0, a1 조합은 9가지 뿐이다.
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					seq[0] += i;
					seq[1] += j;
					int res = go(seq[0], seq[1], Math.abs(i) + Math.abs(j));
					//System.out.println(i + " " + j + " " + res);
					if(change == -1 || (res != -1 && change > res)) {
						change = res;
					}
					copy();
				}
				
			}
			System.out.println(change);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int a0, int a1, int c) {
		int d = a0 - a1;
		int cnt = c;
		for(int i = 1; i < N - 1; i++) {
			if(seq[i] - seq[i + 1] == d) {
				;
			}
			else if(seq[i] - (seq[i + 1] + 1) == d) {
				seq[i + 1] += 1;
				cnt++;
			}
			else if(seq[i] - (seq[i + 1] - 1) == d) {
				seq[i + 1] -= 1;
				cnt++;
			}
			else {
				return -1;
			}
		}
		return cnt;
	}
	
	public static void copy() {
		for(int i = 0; i < N; i++) {
			seq[i] = init[i];
		}
	}

}
