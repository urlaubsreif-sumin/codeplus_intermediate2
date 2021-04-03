package string4;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String S = br.readLine();
			int max = 0;
			for(int s = 0; s < S.length(); s++) {
				int val = preprocessing(S, s);
				max = max > val ? max : val;
			}
			
			System.out.println(max);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static int preprocessing(String S, int s) {
		int m = S.length() - s;
		int[] fail = new int[m];
		int j = 0;
		int max = 0;
		for(int i = 1; i < m; i++) {
			while(j > 0 && S.charAt(s + i) != S.charAt(s + j)) j = fail[j - 1];
			if(S.charAt(s + i) == S.charAt(s + j)) {
				j++;
				fail[i] = j;
				max = max > fail[i] ? max : fail[i];
			}
		}
		return max;
	}

}
