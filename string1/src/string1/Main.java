package string1;
import java.io.*;

public class Main {
	static char[] s, p;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			s = br.readLine().toCharArray();
			p = br.readLine().toCharArray();
			int s_hash = 0;
			int p_hash = 0;
			int max = 1;
			if(s.length < p.length) {
				System.out.println(0);
				return;
			}
			for(int i = 1; i < p.length; i++) {
				max = max * 26 % 127;
			}
			
			for(int i = 0; i < p.length; i++) {
				s_hash = s_hash * 26 % 127;
				s_hash = (s_hash + s[i] - 'a') % 127;
				p_hash = p_hash * 26 % 127;
				p_hash = (p_hash + p[i] - 'a') % 127;
			}
			
			for(int i = p.length; i <= s.length; i++) {
				if(s_hash == p_hash) {
					if(isSame(i - p.length, i - 1)) {
						System.out.println(1);
						return;
					}
				}
				if(i >= s.length) {
					break;
				}
				s_hash = s_hash - ((s[i - p.length] - 'a') * max % 127);
				s_hash = (s_hash + 127) % 127;
				s_hash = s_hash * 26 % 127;
				s_hash = (s_hash + s[i] - 'a') % 127;
				
			}
			
			System.out.println(0);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isSame(int from, int to) {
		for(int i = from; i <= to; i++) {
			if(s[i] != p[i - from]) {
				return false;
			}
		}
		return true;
	}
}
