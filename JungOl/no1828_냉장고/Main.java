package JungOl.no1828_냉장고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 화학물질 수
		int ref = 1; // 냉장고 수
		chemical[] U = new chemical[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			U[i] = new chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(U);
		int limit = U[0].y; // 초기 최고보관온도 설정

		// 최고보관온도보다 높을 경우 다른 냉장고를 써야함. 따라서 냉장고를 1개 늘리고 limit를 갱신.
		for (int i = 0; i < N; i++) {
			if (U[i].x > limit) {
				limit = U[i].y;
				ref++;
			}
		}

		System.out.print(ref);
		br.close();
	}
}

class chemical implements Comparable<chemical> {
	// x : 최저보관온도 y : 최고보관온도
	int x, y;

	public chemical(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	// 오름차순 정렬
	@Override
	public int compareTo(chemical o) {
		return this.y != o.y ? this.y - o.y : this.x - o.x;
	}
}