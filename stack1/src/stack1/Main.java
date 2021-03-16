package stack1;
import java.io.*;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Stack<Integer> index = new Stack<>();
		Stack<Integer> candi = new Stack<>();
		StringBuilder sb = new StringBuilder();
		try {
			String input = br.readLine();
			String exp = br.readLine();
			boolean[] check = new boolean[input.length()];
			
			if(exp.length() == 1) {
				for(int i = 0; i < input.length(); i++) {
					if(input.charAt(i) == exp.charAt(0)) {
						check[i] = true;
					}
				}
			}
			else {
				for(int i = 0; i < input.length(); i++) {
					if(input.charAt(i) == exp.charAt(0)) {
						index.push(i);
						candi.push(0);
					}
					else {
						if(candi.isEmpty())
							continue;
						//System.out.println(input.charAt(i) + " " + exp.charAt(candi.peek() + 1));
						int p = candi.peek();
						if(input.charAt(i) == exp.charAt(p + 1)) {
							index.push(i);
							candi.push(p + 1);
							if(p + 1 == exp.length() - 1) {
								for(int k = 0; k < exp.length(); k++) {
									check[index.pop()] = true;
									candi.pop();
								}
							}
						}
						else {
							while(!index.isEmpty()) {
								index.pop();
								candi.pop();
							}
						}
					}
				}
				
			}
			for(int i = 0; i < input.length(); i++) {
				if(!check[i]) {
					sb.append(input.charAt(i));
				}
			}
			
			if(sb.toString().isEmpty()) {
				sb.append("FRULA");
			}
			
			bw.write(sb.toString());
			bw.close();
			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
