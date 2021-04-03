package string2;
import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			String T = br.readLine();
			String P = br.readLine();
			ArrayList<Integer> ans = new ArrayList<>();
			int[] fail = preprocessing(P);
			int n = T.length();
			int m = P.length();
			int j = 0;
			for(int i = 0; i < n; i++) {
				while(j > 0 && T.charAt(i) != P.charAt(j)) j = fail[j - 1];
				if(T.charAt(i) == P.charAt(j)) {
					if(j == m - 1) {
						ans.add(i - m + 1);
						j = fail[j];
					}
					else {
						j++;
					}
				}
			}
			
			sb.append(ans.size()).append('\n');
			for(int i = 0; i < ans.size(); i++) {
				sb.append(ans.get(i) + 1).append(' ');
			}
			
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static int[] preprocessing(String P) {
		int m = P.length();
		int[] fail = new int[m];
		int j = 0;
		for(int i = 1; i < m; i++) {
			while(j > 0 && P.charAt(i) != P.charAt(j)) j = fail[j - 1];
			if(P.charAt(i) == P.charAt(j)) {
				j++;
				fail[i] = j;
			}
		}
		return fail;
	}

}
