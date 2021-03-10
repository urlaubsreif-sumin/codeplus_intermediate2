package bf27;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int[] magic = new int[9];
	static boolean[] check = new boolean[9];
	static int min = 45;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		try {
			for(int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 3; j++) {
					int n = Integer.parseInt(st.nextToken());
					magic[i * 3 + j] = n;
				}
			}
			
			go(0, 0);
			
			System.out.println(min);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void go(int i, int score) {
		if(score > min) {
			return;
		}
		if(check()) {
			min = min < score ? min : score;
			return;
		}
		for(int k = 1; k < 10; k++) {
			if(check[k - 1])
				continue;
			int tmp = magic[i];
			magic[i] = k;
			check[k - 1] = true;
			go(i + 1, score + Math.abs(magic[i] - tmp));
			check[k - 1] = false;
			magic[i] = tmp;
		}
	}
	
	public static boolean check() {
		for(int i = 0; i < 3; i++) {
			if(magic[i * 3] + magic[i * 3 + 1] + magic[i * 3 + 2] != 15) {
				return false;
			}
			if(magic[i] + magic[3 + i] + magic[2 * 3 + i] != 15) {
				return false;
			}
		}
		if(magic[0] + magic[4] + magic[8] != 15) {
			return false;
		}
		if(magic[2] + magic[4] + magic[6] != 15) {
			return false;
		}
		return true;
	}
}
