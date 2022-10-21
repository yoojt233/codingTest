package BaekJoon.no6416_트리인가;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		boolean flag = true;

		int num = 1;
		while (true) {
			boolean isTree = true;
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			HashSet<Integer> node = new HashSet<>();
			HashSet<Integer> end = new HashSet<>();

			st = new StringTokenizer(br.readLine());
			while (true) {
				while (!st.hasMoreTokens())
					st = new StringTokenizer(br.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				if (from == 0 && to == 0)
					break;
				if (from == -1 && to == -1) {
					flag = false;
					break;
				}

				node.add(from);
				node.add(to);
				end.add(to);

				ArrayList<Integer> list = map.getOrDefault(from, new ArrayList<>());
				list.add(to);
				map.put(from, list);
			}

			if (!flag)
				break;

			if (isTree) {
				HashMap<Integer, Boolean> visited = new HashMap<>();
				int op = 0;
				for (int i : node) {
					visited.put(i, false);
					if (!end.contains(i))
						op = i;
				}

				Queue<Integer> q = new LinkedList<>();
				q.offer(op);
				visited.put(op, true);
				out: while (!q.isEmpty()) {
					int cur = q.poll();
					ArrayList<Integer> list = map.getOrDefault(cur, new ArrayList<>());

					for (int next : list) {
						if (visited.get(next)) {
							isTree = false;
							break out;
						}

						visited.put(next, true);
						q.offer(next);
					}
				}

				for (int i : visited.keySet()) {
					if (!visited.get(i))
						isTree = false;
				}
			}

			if (isTree)
				sb.append("Case " + (num++) + " is a tree.\n");
			else
				sb.append("Case " + (num++) + " is not a tree.\n");
		}

		System.out.print(sb);
		br.close();
	}
}
