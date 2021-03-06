package bf14;
import java.io.*;
import java.util.StringTokenizer;
public class Main {
	static int[] arr;
	static int R;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			
			arr = new int[R];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < R; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int res = 0;
			for(int i = 0; i < R; i++) {
				switch(P) {
				case 1:
					res += go(i, "0") + go(i, "0000");
					break;
				case 2:
					res += go(i, "00");
					break;
				case 3:
					res += go(i, "110") + go(i, "01");
					break;
				case 4:
					res += go(i, "011") + go(i, "10");
					break;
				case 5:
					res += go(i, "000") + go(i, "10") + go(i, "010") + go(i, "01");
					break;
				case 6:
					res += go(i, "000") + go(i, "00") + go(i, "100") + go(i, "02");
					break;
				case 7:
					res += go(i, "000") + go(i, "20") + go(i, "001") + go(i, "00");
					break;
				}
			}
			System.out.println(res);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int go(int i, String next) {
		for(int k = 0; k < next.length(); k++) {
			if(i + k >= R) {
				return 0;
			}
			if(arr[i] + next.charAt(0) != arr[i + k] + next.charAt(k)) {
				return 0;
			}
		}
		return 1;
	}
	
}
