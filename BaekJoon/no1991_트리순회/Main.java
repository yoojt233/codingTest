package BaekJoon.no1991_트리순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static Node[] tree;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		tree = new Node[N + 1];

		for (int i = 1; i <= N; i++)
			tree[i] = new Node((char) ('A' + i - 1));

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char root = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			if (left != '.')
				tree[root - 64].left = tree[left - 64];
			if (right != '.')
				tree[root - 64].right = tree[right - 64];
		}

		preorder(tree[1]);
		sb.append("\n");

		inorder(tree[1]);
		sb.append("\n");

		postorder(tree[1]);
		sb.append("\n");

		System.out.print(sb.toString());
	}

	private static void preorder(Node node) {
		sb.append(node.data);
		if (node.left != null)
			preorder(node.left);
		if (node.right != null)
			preorder(node.right);
	}

	private static void inorder(Node node) {
		if (node.left != null)
			inorder(node.left);
		sb.append(node.data);
		if (node.right != null)
			inorder(node.right);
	}

	private static void postorder(Node node) {
		if (node.left != null)
			postorder(node.left);
		if (node.right != null)
			postorder(node.right);
		sb.append(node.data);
	}

}

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) {
		this.data = data;
	}
}