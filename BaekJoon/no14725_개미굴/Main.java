package BaekJoon.no14725_개미굴;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Node node = new Node("start");

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			ArrayList<Node> list = node.list;

			for (int k = 0; k < K; k++) {
				String root = st.nextToken();
				int idx = exist(list, root);
				if (idx == -1) {
					Node temp = new Node(root);
					list.add(temp);
					list = temp.list;
				} else
					list = list.get(idx).list;
			}
		}

		sort(node.list);
		dfs(node.list, 0, sb);

		System.out.print(sb.toString());
		br.close();
	}

	private static void dfs(ArrayList<Node> list, int cnt, StringBuilder sb) {
		for (Node n : list) {
			for (int i = 0; i < cnt; i++)
				sb.append("--");
			sb.append(n.parent + "\n");
			dfs(n.list, cnt + 1, sb);
		}
	}

	private static void sort(ArrayList<Node> list) {
		Collections.sort(list);
		for (Node n : list)
			sort(n.list);
	}

	private static int exist(ArrayList<Node> list, String root) {
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).parent.equals(root))
					return i;
			}
		}
		return -1;
	}
}

class Node implements Comparable<Node> {
	String parent;
	ArrayList<Node> list;

	public Node(String root) {
		this.parent = root;
		this.list = new ArrayList<Node>();
	}

	@Override
	public int compareTo(Node o) {
		return this.parent.compareTo(o.parent);
	}
}