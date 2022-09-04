package BaekJoon.no1158_요세푸스문제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int n = Integer.parseInt(st.nextToken());
		int mark = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new ArrayDeque<>();

		for (int i = 1; i <= n; i++)
			q.offer(i);

		int cnt = 1;
		sb.append("<");
		while (!q.isEmpty()) {
			if (q.size() == 1)
				break;
			if (cnt % mark == 0)
				sb.append(q.poll()).append(", ");
			else
				q.offer(q.poll());
			cnt++;
		}
		sb.append(q.poll()).append(">");
		System.out.println(sb.toString());

		br.close();
		bw.close();
	}
}
