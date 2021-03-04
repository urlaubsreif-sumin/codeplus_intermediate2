package bf5;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		try {
			int N = Integer.parseInt(br.readLine());
			Num[] seq = new Num[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				seq[i] = new Num(Long.parseLong(st.nextToken()));
			}
			
			Arrays.sort(seq);
			
			for(Num num : seq) {
				sb.append(num.n).append(' ');
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

class Num implements Comparable<Num> {
	int three;
	long n;
	Num(long n){
		this.n = n;
		this.three = this.get_three(n);
	}
	
	public int get_three(long n) {
		long tmp = n;
		int res = 0;
		while(true) {
			if(tmp % 3 == 0) {
				tmp /= 3;
				res++;
			}
			else {
				break;
			}
		}
		return res;
	}

	@Override
	public int compareTo(Num that) {
		if(this.three > that.three) {
			return -1;
		}
		else if(this.three < that.three) {
			return 1;
		}
		else {
			if(this.n > that.n) {
				return 1;
			}
			else if(this.n < that.n) {
				return -1;
			}
		}
		return 0;
	}

}