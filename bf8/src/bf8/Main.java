package bf8;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] A, B;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = st.nextToken().toCharArray();
			B = st.nextToken().toCharArray();
			
			if(A.length > B.length) {
				System.out.println(-1);
				return;
			}
			else if(A.length == 1) {
				if(compare(A, B)) {
					System.out.println(-1);
					return;
				}
				System.out.println(A[0]);
				return;
			}
			
			Arrays.sort(A);
			for(int i = 0; i < A.length / 2; i++) {
				char temp = A[i];
				A[i] = A[A.length - i - 1];
				A[A.length - i - 1] = temp;
			}
			
			while(compare(A, B)) {
				if(prev_permutation()) {
					;
				}
				else {
					System.out.println(-1);
					return;
				}
			}
			
			for(char ch : A) {
				sb.append(ch);
			}
			
			System.out.println(sb.toString());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean compare(char[] A, char[] B) {
		if(A.length < B.length) return false;
		else if(A.length > B.length) return true;
		else {
			int idx = 0;
			while(idx < A.length) {
				if(A[idx] > B[idx])
					return true;
				else if(A[idx] < B[idx])
					return false;
				idx++;
			}
		}
		return true;
	}
	
	public static boolean prev_permutation() {
		int idx = A.length - 1;
		while(A[idx] >= A[idx - 1]) {
			idx--;
			if(idx < 1) {
				return false;
			}
		}
		idx--;
		int idx2 = A.length - 1;
		while(idx2 > idx) {
			if(A[idx2] < A[idx]) {
				char temp = A[idx];
				A[idx] = A[idx2];
				A[idx2] = temp;
				break;
			}
			idx2--;
		}
		if(idx2 == idx) {
			return false;
		}
		int s = idx + 1;
		int e = A.length - 1;
		while(s < e) {
			char temp = A[s];
			A[s] = A[e];
			A[e] = temp;
			s++;
			e--;
		}
		
		if(A[0] == '0') {
			return false;
		}
		
		return true;
	}

}
