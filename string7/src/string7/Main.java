package string7;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		try {
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			Trie t = new Trie();
			int[] arr = new int[N];
			int max = 0;
			for(int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			int len = Integer.toBinaryString(arr[arr.length - 1]).length();
			t.add(decToBin(arr[0], len));
			for(int i = 1; i < N; i++) {
				String s = decToBin(arr[i], len);
				int res = t.calc(s);
				//System.out.println(s + " " + res);
				max = max > res ? max : res;
				t.add(s);
			}
			
			System.out.println(max);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
	public static String decToBin(int d, int len) {
		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toBinaryString(d));
		while(sb.length() < len) {
			sb.insert(0, "0");
		}
		return sb.toString();
	}
}

class Trie {
	class Node {
		int[] children;
		boolean valid;
		Node() {
			children = new int[2];
			Arrays.fill(children, -1);
			valid = false;
		}
	}
	ArrayList<Node> trie;
	int root;
	int init() {
		Node n = new Node();
		trie.add(n);
		return trie.size() - 1;
	}
	Trie() {
		trie = new ArrayList<>();
		root = init();
	}
	void add(int node, String s, int idx) {
		if(idx == s.length()) {
			return;
		}
		int ch = s.charAt(idx) - '0';
		if(trie.get(node).children[ch] == -1) {
			int next = init();
			trie.get(node).children[ch] = next;
		}
		int child = trie.get(node).children[ch];
		add(child, s, idx + 1);
	}
	void add(String s) {
		add(root, s, 0);
	}
	int calc(int node, String s, int idx, int ans) {
		if(idx == s.length()) {
			return ans;
		}
		int ch = s.charAt(idx) - '0';
		int a = ans * 2;
		int child = trie.get(node).children[(ch + 1) % 2];
		
		if(child == -1) {
			child = trie.get(node).children[ch];
		}
		else {
			a += 1;
		}
		return calc(child, s, idx + 1, a);
	}
	int calc(String s) {
		return calc(root, s, 0, 0);
	}
}