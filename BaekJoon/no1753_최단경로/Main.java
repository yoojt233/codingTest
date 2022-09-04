package BaekJoon.no1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 노드 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수
		int[][] map = new int[V + 1][V + 1];

		// 시작 지점
		int first = Integer.parseInt(br.readLine());

		// 인접 행렬 생성
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			makeArr(map, st.nextToken(), st.nextToken(), st.nextToken());
		}

		int[] distance = new int[V + 1]; // 노드에서 노드까지의 거리(간선의 가중치)
		boolean[] visited = new boolean[V + 1]; // 방문 체크

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[first] = 0;

		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE, current = 0;
			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;

			for (int j = 1; j < V + 1; j++) {
				if (!visited[j] && map[current][j] != 0 && distance[j] > distance[current] + map[current][j]) {
					distance[j] = distance[current] + map[current][j];
				}
			}
		}

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(distance[i]).append("\n");
		}
		System.out.print(sb);
		br.close();
	}

	private static void makeArr(int[][] map, String start, String end, String value) {
		map[Integer.parseInt(start)][Integer.parseInt(end)] = Integer.parseInt(value);
	}

	static class Node {
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}
	}
}
