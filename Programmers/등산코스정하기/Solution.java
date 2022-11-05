package Programmers.등산코스정하기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {
	static ArrayList<node>[] list;
	static HashSet<Integer> top;
	static PriorityQueue<node> pq;

	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		Arrays.sort(summits); // 산봉우리 정렬
		init(n, paths, gates, summits);

		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 출입구는 0
		pq = new PriorityQueue<>();
		for (int i : gates) {
			pq.offer(new node(i - 1, 0));
			dist[i - 1] = 0;
		}

		while (!pq.isEmpty()) {
			node cur = pq.poll(); // 현재 위치

			// 산봉우리 도착, 더 빠른 길 존재
			if (top.contains(cur.index) || dist[cur.index] < cur.val)
				continue;

			for (node nd : list[cur.index]) {

				// 이전까지 온 길과 이번에 움직인 길 중 최댓값
				int temp = Math.max(nd.val, cur.val);

				// 최소 거리 갱신
				if (dist[nd.index] > temp) {
					dist[nd.index] = temp;
					pq.offer(new node(nd.index, temp));
				}
			}
		}

		// 정답
		int[] ans = new int[2];
		ans[0] = Integer.MAX_VALUE;
		ans[1] = Integer.MAX_VALUE;
		for (int i : summits) {
			if (dist[i - 1] < ans[1]) {
				ans[0] = i;
				ans[1] = dist[i - 1];
			}
		}

		return ans;
	}

	private static void init(int n, int[][] paths, int[] gates, int[] summits) {

		// 간선리스트 초기화
		list = new ArrayList[n];
		for (int i = 0; i < n; ++i)
			list[i] = new ArrayList<node>();

		// 경로 저장
		for (int[] arr : paths) {
			int cur = arr[0] - 1;
			int next = arr[1] - 1;
			int val = arr[2];

			// 양방향
			list[cur].add(new node(next, val));
			list[next].add(new node(cur, val));
		}

		// 산봉우리
		top = new HashSet<>();
		for (int i : summits)
			top.add(i - 1);
	}
}

class node implements Comparable<node> {
	int index, val;

	public node(int index, int val) {
		this.index = index;
		this.val = val;
	}

	// PriorityQueue 우선순위
	public int compareTo(node o) {
		return this.val - o.val;
	}
}