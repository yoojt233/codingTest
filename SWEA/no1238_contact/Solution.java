package SWEA.no1238_contact;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[] number;
	static int[][] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		int t = 1;

		// 다음 문장이 null일 때 까지
		while ((str = br.readLine()) != null) {
			sb.append("#").append(t++).append(" ");
			StringTokenizer st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			node = new int[N][N];
			number = new int[N + 1];
			int start = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			while (st.hasMoreTokens()) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				node[from][to] = 1;
			}

			bfs(start);

			// 답 찾기
			int idx = 0;
			int max = 0;
			for (int i = 1; i < number.length; i++) {
				if (number[i] >= max) {
					max = number[i];
					idx = i;
				}
			}
			sb.append(idx).append("\n");
		}
		System.out.print(sb.toString());
		br.close();
	}

	private static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		while (!q.isEmpty()) {
			int temp = q.poll();
			for (int i = 0; i < N; i++) {
				if (node[temp][i] == 1 && number[i] == 0) {
					q.offer(i);
					number[i] = number[temp] + 1;
				}
			}
		}
	}
}
