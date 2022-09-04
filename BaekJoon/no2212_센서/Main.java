package BaekJoon.no2212_센서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());

		int ans = 0;

		int[] sensor = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			sensor[i] = Integer.parseInt(st.nextToken());

		if (K < N) {
			Arrays.sort(sensor);
			PriorityQueue<dif> pq = new PriorityQueue<>();
			for (int i = 0; i < N - 1; ++i)
				pq.add(new dif(i, i + 1, sensor[i + 1] - sensor[i]));

			int[] cut = new int[K];
			for (int i = 0; i < K - 1; ++i) {
				dif cur = pq.poll();
				cut[i] = cur.op;
			}
			cut[K - 1] = N - 1;

			Arrays.sort(cut);

			int start = 0;
			for (int i = 0; i < K; ++i) {
				ans += (sensor[cut[i]] - sensor[start]);
				start = cut[i] + 1;
			}
		}

		System.out.print(ans);
		br.close();
	}
}

class dif implements Comparable<dif> {
	int op, ed, gap;

	public dif(int op, int ed, int gap) {
		this.op = op;
		this.ed = ed;
		this.gap = gap;
	}

	@Override
	public int compareTo(dif o) {
		return o.gap - this.gap;
	}
}