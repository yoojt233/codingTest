package BaekJoon.no1911_흙길보수하기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 물웅덩이 갯수
		int size = Integer.parseInt(st.nextToken()); // 박스 크기
		loc[] pos = new loc[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pos[i] = new loc(st.nextToken(), st.nextToken());
		}

		Arrays.sort(pos);

		int now = 0, cnt = 0; // now : 마지막으로 박스가 덮고 있는 위치, cnt : 박스 갯수
		for (int i = 0; i < N; i++) {

			// 마지막 박스 위치가 시작 지점보다 작으면 시작 지점 -1
			// 시작 지점부터 size 만큼 깔면 1 크게 깔린다. ex) 1부터 3크기 깔면 4가 나오게 된다.
			if (now < pos[i].start) {
				now = pos[i].start - 1;
			}

			// 끝 지점 - 1인 이유 : 문제에서 주어진 물웅덩이의 위치가 (1 6) 이면 1 ~ 5까지가 물웅덩이
			// cnt 1 증가 당 now는 size 만큼 증가
			while (now < pos[i].end - 1) {
				cnt++;
				now += size;
			}
		}

		System.out.print(cnt);
		br.close();
	}
}

// 시작 지점과 끝 지점
class loc implements Comparable<loc> {
	int start, end;

	public loc(String start, String end) {
		super();
		this.start = Integer.parseInt(start);
		this.end = Integer.parseInt(end);
	}

	// 시작 지점 기준 정렬
	@Override
	public int compareTo(loc o) {
		return this.start - o.start;
	}
}