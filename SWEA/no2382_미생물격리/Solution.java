package SWEA.no2382_미생물격리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int N, M, K;
	static Micro map[][];
	static int[] dr = { 0, -1, 1, 0, 0 }; // 사용x, 상, 하, 좌, 우
	static int[] dc = { 0, 0, 0, -1, 1 };
	static PriorityQueue<Micro> pQueue;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new Micro[N][N]; // 매 시간마다 각 셀에 이동한 미생물 정보
			pQueue = new PriorityQueue<Micro>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				pQueue.add(new Micro(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			sb.append("#").append(t).append(" ").append(move()).append("\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	// 주어진 M 시간동안 미생물 이동 처리
	private static int move() {
		int time = M, nr, nc, remainCnt = 0;
		while (time-- > 0) {

			// 군집리스트에서 군집들을 하나씩 모두 꺼내어 처리
			Micro m;
			while (!pQueue.isEmpty()) {
				m = pQueue.poll();

				nr = m.r + dr[m.dir];
				nc = m.c + dr[m.dir];

				// 가장자리
				if (nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {
					if ((m.cnt = m.cnt / 2) == 0)
						continue;
					if (m.dir % 2 == 1)
						m.dir++;
					else
						m.dir--;
				}

				// 빈 자리거나 아니거나
				if (map[nr][nc] == null)
					map[nr][nc] = m;
				else
					map[nr][nc].cnt += m.cnt;
			}

			// 1시간 처리
			remainCnt = reset();
		}
		
		return remainCnt;
	}

	// 매 시간마다 필요한 정리, 초기화 작업
	private static int reset() {
		int total = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (map[r][c] != null) {
					pQueue.offer(map[r][c]);
					total += map[r][c].cnt; // 살아있는 미생물 군집의 크기
					map[r][c] = null;
				}
			}
		}
		return total;
	}
}

class Micro implements Comparable<Micro> {
	int r, c, cnt, dir; // 행, 열, 군집크기, 이동방향

	public Micro(int r, int c, int cnt, int dir) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.dir = dir;
	}

	@Override
	public int compareTo(Micro o) {
		return o.cnt - this.cnt;
	}
}