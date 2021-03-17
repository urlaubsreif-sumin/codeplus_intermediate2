package stack4;
import java.io.*;

public class Main {
	static char[] A, T;
	static char[] l, r;
	static int left, right;
	static int rn = 0;
	static int ln = 0;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		try {
			A = br.readLine().toCharArray();
			T = br.readLine().toCharArray();
			l = new char[T.length];
			r = new char[T.length];
			left = 0;
			right = T.length - 1;
			
			boolean state = true;
			while(left <= right) {
				if(state) {
					l[ln] = T[left];
					ln++;
					left++;
				}
				else {
					r[rn] = T[right];
					rn++;
					right--;
				}
				if(go(state)) {
					state = !state;
				}
			}
			for(int i = ln - 1; i >= 0; i--) {
				r[rn++] = l[i];
				go(false);
			}
			for(int i = rn - 1; i >= 0; i--) {
				sb.append(r[i]);
			}
			
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static boolean go(boolean state) {
		char[] stack;
		int len;
		if(state) {
			stack = l;
			len = ln;
		}
		else {
			stack = r;
			len = rn;
		}
		if(len - A.length < 0)
			return false;
		for(int i = 0; i < A.length; i++) {
			if(state && stack[len - i - 1] != A[A.length - i - 1]) {
				return false;
			}
			else if(!state && stack[len - i - 1] != A[i]) {
				return false;
			}
		}
		if(state) {
			ln -= A.length;
		}
		else {
			rn -= A.length;
		}
		return true;
	}

}
