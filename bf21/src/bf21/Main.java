package bf21;
import java.io.*;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer> num;
	static ArrayList<Character> op;
	static ArrayList<Integer> init_num;
	static ArrayList<Character> init_op;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			num = new ArrayList<>();
			op = new ArrayList<>();
			init_num = new ArrayList<>();
			init_op = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				char ch = input.charAt(i);
				if(ch >= '0' && ch <= '9') {
					num.add(ch - '0');
					init_num.add(ch - '0');
				}
				else {
					op.add(ch);
					init_op.add(ch);
				}
			}
			
			int res = go(op.size());
			System.out.println(res);
			
			
;		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int go(int sz) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < (1 << sz); i++) {
			boolean state = true;
			for(int j = 0; j < sz; j++) {
				if((i & (1 << j)) != 0 && (i & (1 << (j + 1))) == 0) {
					int tmp = oper(num.get(j), num.get(j + 1), op.get(j));
					num.set(j, tmp);
					num.set(j + 1, tmp);
					op.set(j, '?');
				}
				else if((i & (1 << j)) != 0 && (i & (1 << (j + 1))) != 0){
					state = false;
					break;
				}
			}
			if(!state) {
				init();
				continue;
			}
			System.out.println(Integer.toBinaryString(i));
			int res = calc();
			max = max > res ? max : res;
			init();
		}
		return max;
	}
	
	public static int oper(int n1, int n2, char op) {
		switch(op) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		case '?':
			return n2;
		}
		
		return -1;
	}
	
	public static int calc() {
		ArrayList<Integer> n = new ArrayList<>();
		n.add(num.get(0));
		for(int i = 0; i < op.size(); i++) {
			if(op.get(i) == '?') {
				op.remove(i);
				i--;
			}
			else if(op.get(i) == '*') {
				int tmp = n.get(n.size() - 1);
				tmp *= num.get(i + 1);
				n.add(tmp);
			}
			else {
				n.add(num.get(i + 1));
			}
		}
		
		int res = n.get(0);
		for(int i = 0; i < op.size(); i++) {
			res = oper(res, n.get(i + 1), op.get(i));
		}
		return res;
	}
	
	public static void init() {
		op = new ArrayList<Character>(init_op.size());
		for(int i = 0; i < num.size(); i++) {
			if(i < op.size())
				op.set(i, init_op.get(i));
			num.set(i, init_num.get(i));
		}
	}

}
