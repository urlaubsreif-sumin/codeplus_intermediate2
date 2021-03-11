package bf32;
import java.io.*;

public class Main {
	static boolean[] pn = new boolean[4000001];
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int N = Integer.parseInt(br.readLine());
			
			get_pn();
			int L = 2;
			int R = 2;
			int sum = 2;
			int n = 0;
			while(L >= 0 && R < 4000000) {
				if(sum == N) {
					//System.out.println(L + " " + R + " " + sum);
					n++;
				}
				if(sum <= N) {
					R++;
					while(pn[R]) {
						R++;
						if(R > 4000000) {
							break;
						}
					}
					sum += R;
				}
				else if(sum > N) {
					sum -= L;
					L++;
					while(pn[L]) {
						L++;
						if(L > N) {
							L = -1;
							break;
						}
					}
				}
			}
			
			System.out.println(n);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void get_pn() {
		pn[0] = true;
		pn[1] = true;
		for(int i = 2; i < 4000001; i++) {
			if(!pn[i]) {
				for(int j = i + i; j < 4000001; j += i) {
					pn[j] = true;
				}
			}
		}
	}

}
