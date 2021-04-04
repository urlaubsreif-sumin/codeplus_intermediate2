package string6;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int ans = 0;
			Trie t = new Trie();
			
			while(N --> 0) {
				t.add(br.readLine());
			}
			
			while(M --> 0) {
				boolean res = t.search(br.readLine());
				if(res) {
					ans++;
				}
			}
			
			System.out.println(ans);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}

class Trie {
	class Node {
		int[] children;
		Node(){
			children = new int[26];
			Arrays.fill(children, -1);
		}
	}
	ArrayList<Node> trie;
	int root;
	int init() {
		Node n = new Node();
		trie.add(n);
		return trie.size() - 1;
	}
	Trie(){
		trie = new ArrayList<>();
		root = init();
	}
	void add(int node, String s, int idx) {
		if(idx == s.length()) {
			return;
		}
		int ch = s.charAt(idx) - 'a';
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
	boolean search(int node, String s, int idx) {
		if(idx == s.length()) {
			return true;
		}
		int ch = s.charAt(idx) - 'a';
		int next = trie.get(node).children[ch];
		if(next == -1) {
			return false;
		}
		return search(next, s, idx + 1);
	}
	boolean search(String s) {
		return search(root, s, 0);
	}
}