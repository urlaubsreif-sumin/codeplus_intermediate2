package string3;
import java.io.*;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int L = Integer.parseInt(br.readLine());
			String S = br.readLine();
			
			int[] fail = preprocessing(S);
			System.out.println(L - fail[L - 1]);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int[] preprocessing(String S) {
		int[] fail = new int[S.length()];
		int m = S.length();
		int j = 0;
		for(int i = 1; i < m; i++) {
			while(j > 0 && S.charAt(i) != S.charAt(j)) j = fail[j - 1];
			if(S.charAt(i) == S.charAt(j)) {
				j++;
				fail[i] = j;
			}
		}
		return fail;
	}

}
