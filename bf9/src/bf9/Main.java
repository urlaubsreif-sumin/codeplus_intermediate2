package bf9;
import java.io.*;
import java.util.ArrayList;

public class Main {
	static int N;
	static ArrayList<Integer> num;
	static ArrayList<Character> op;
	static ArrayList<Integer> init_num;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			N = Integer.parseInt(br.readLine());
			num = new ArrayList<>();
			init_num = new ArrayList<>();
			op = new ArrayList<>();
			String input = br.readLine();
			for(int i = 0; i < input.length(); i++) {
				char ch = input.charAt(i);
				if(ch >= '0' && ch <= '9') {
					num.add(ch - '0');
					init_num.add(ch - '0');
				}
				else
					op.add(ch);
			}
			
			int max = -(int)Math.pow(2, 31);
			
			for(int i = 0; i < (1 << N / 2); i++) {
				boolean pass = false;
				copy();
				for(int j = 0; j < N / 2; j++) {
					int pos = N / 2 - j - 1;
					if(pos != 0) {
						if((i & (1 << j)) != 0 && (i & (1 << (j + 1))) != 0) {
							pass = true;
							continue;
						}
					}
					if((i & (1 << j)) != 0) {
						num.set(pos, calc(num.get(pos), num.get(pos + 1), op.get(pos)));
						num.set(pos + 1, op.get(pos) == '*' ? 1 : 0);
					}
				}
				if(pass) {
					continue;
				}
				int res = calc_seq();
				max = max > res ? max : res;
			}
			
			System.out.println(max);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int calc(int n1, int n2, char op) {
		int res = 0;
		switch(op) {
		case '+':
			res = n1 + n2;
			break;
		case '*':
			res = n1 * n2;
			break;
		case '-':
			res = n1 - n2;
			break;
		}
		return res;
	}
	
	public static int calc_seq() {
		int res = num.get(0);
		for(int i = 0; i < op.size(); i++) {
			res = calc(res, num.get(i + 1), op.get(i));
		}
		return res;
	}
	
	public static void copy() {
		for(int i = 0; i < N / 2 + 1; i++) {
			num.set(i, init_num.get(i));
		}
	}
}