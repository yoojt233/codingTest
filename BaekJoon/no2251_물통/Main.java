package BaekJoon.no2251_물통;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
	static HashSet<Integer> possible = new HashSet<Integer>(); // 가능한 c의 물 양
	static HashSet<String> exist = new HashSet<String>();
	static Queue<left> q = new LinkedList<>();
	static int[] water;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		water = new int[3]; // 각 물통에 담을 수 있는 물의 양
		for (int i = 0; i < 3; i++)
			water[i] = Integer.parseInt(st.nextToken());

		left first = new left(0, 0, water[2]);
		q.offer(first);
		exist.add(first.toString()); // A B C 물통에 남을 수 있는 경우
		bfs();

		// 출력
		Integer[] temp = possible.toArray(new Integer[0]); // set -> array
		Arrays.sort(temp);
		for (int i : temp)
			sb.append(i + " ");

		System.out.print(sb.toString());
		br.close();
	}

	static void bfs() {
		while (!q.isEmpty()) {
			left cur = q.poll();

			// A 물의 양이 0일 때, C 물의 양
			if (cur.in[0] == 0)
				possible.add(cur.in[2]);

			for (int i = 0; i < 3; i++) { // from
				if (cur.in[i] == 0) // 물이 없으면 이동 불가
					continue;
				for (int j = 0; j < 3; j++) { // to
					if (i == j) // 자기 자신으로 이동 불가
						continue;

					left next = move(cur, i, j);
					if (!exist.contains(next.toString())) {
						exist.add(next.toString());
						q.offer(next);
					}
				}
			}
		}
	}

	private static left move(left cur, int from, int to) {
		int[] in = cur.in.clone();

		// 물이 가득 찰 때까지
		if (in[from] + in[to] > water[to]) {
			in[from] -= (water[to] - in[to]);
			in[to] = water[to];
		} else { // 물을 모두 부을 때까지
			in[to] += in[from];
			in[from] = 0;
		}

		return new left(in[0], in[1], in[2]);
	}
}

// 각 통에 남아있는 물의 양
class left {
	int[] in = new int[3];

	public left(int a, int b, int c) {
		this.in[0] = a;
		this.in[1] = b;
		this.in[2] = c;
	}

	@Override
	public String toString() {
		String str = "";
		for (int i = 0; i < 3; i++)
			str += this.in[i];
		return str;
	}
}
