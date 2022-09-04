package BaekJoon.no18352_특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K, X;
	static ArrayList<Node>[] city;
	static int[] dis;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 원하는 최단 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시 번호

		// 인접 리스트
		city = new ArrayList[N + 1];
		for (int i = 0; i < N + 1; i++)
			city[i] = new ArrayList<Node>();

		// 간선 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			// 거리는 무조건 1
			city[from].add(new Node(to, 1));
		}

		dijk();

		// 최단 거리가 K인 도시
		for (int i = 1; i < N + 1; i++) {
			if (dis[i] == K)
				sb.append(i + "\n");
		}

		// 최단 거리 K인 도시가 존재x
		if (sb.length() == 0)
			sb.append(-1);

		System.out.print(sb.toString());
		br.close();
	}

	// 다익스트라
	private static void dijk() {
		boolean[] visited = new boolean[N + 1]; // 방문 여부
		dis = new int[N + 1]; // 시작 지점으로부터의 최단 경로 거리를 저장할 거리 배열

		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[X] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>(); // 최소 거리를 보장
		pq.add(new Node(X, 0));

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (dis[cur.num] < cur.dis)
				continue;

			for (int i = 0; i < city[cur.num].size(); i++) {

				// 다음 목적지
				Node next = city[cur.num].get(i);

				// 현재에서 next까지의 거리의 합이 이미 저장된 next 거리 값보다 작으면 갱신
				if (dis[next.num] > next.dis + cur.dis) {
					dis[next.num] = next.dis + cur.dis;
					pq.add(new Node(next.num, next.dis + cur.dis));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int num, dis;

	public Node(int num, int dis) {
		super();
		this.num = num;
		this.dis = dis;
	}

	// pq에서 거리 기준, 오름차순으로 뽑기 위해
	@Override
	public int compareTo(Node o) {
		return this.dis - o.dis;
	}
}
