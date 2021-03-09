package bf21;
import java.io.*;
import java.util.ArrayList;

public class Main {
	static ArrayList<Integer> num = new ArrayList<>();
	static ArrayList<Character> op = new ArrayList<>();
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			for(int i = 0; i < N; i++) {
				char ch = input.charAt(i);
				if(ch >= '0' && ch <= '9') {
					num.add(ch - '0');
				}
				else {
					op.add(ch);
				}
			}
			
			go(op.size());
			
			System.out.println(max);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void go(int sz) {
		for(int i = 0; i < (1 << sz); i++) {
			boolean state = true;
			for(int j = 0; j < sz; j++) {
				if((i & (1 << j)) != 0 && ((i & (1 << (j + 1))) != 0)) {
					state = false;
					break;
				}
			}
			if(!state) {
				continue;
			}
			
			//°ýÈ£ ¿¬»ê
			ArrayList<Integer> n = new ArrayList<>();
			ArrayList<Character> o = new ArrayList<>();
			n.add(num.get(0));
			for(int j = 0; j < sz; j++) {
				if((i & (1 << j)) != 0) {
					int res = n.remove(n.size() - 1);
					res = oper(res, num.get(j + 1), op.get(j));
					n.add(res);					
				}
				else {
					n.add(num.get(j + 1));
					o.add(op.get(j));
				}
			}
			
			ArrayList<Integer> n2 = new ArrayList<>();
			ArrayList<Character> o2 = new ArrayList<>();
			n2.add(n.get(0));
			//°ö¼À ¿¬»ê
			for(int j = 0; j < o.size(); j++) {
				if(o.get(j) == '*') {
					int res = n2.remove(n2.size() - 1);
					res *= n.get(j + 1);
					n2.add(res);
				}
				else {
					n2.add(n.get(j + 1));
					o2.add(o.get(j));
				}
			}
			
			int res = n2.get(0);
			for(int j = 0; j < o2.size(); j++) {
				res = oper(res, n2.get(j + 1), o2.get(j));
			}
			
			max = max > res ? max : res;
		}
	}
	
	public static int oper(int n1, int n2, char op) {
		switch(op) {
		case '+':
			return n1 + n2;
		case '-':
			return n1 - n2;
		case '*':
			return n1 * n2;
		}
		return -1;
	}

}
