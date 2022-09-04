package BaekJoon.no2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, sin, ssn, MIN;
	static material[] food;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sin = 1;
		MIN = Integer.MAX_VALUE;
		food = new material[N];

		// 음식의 신맛과 쓴맛을 배열에 저장
		for (int i = 0; i < N; i++) {
			String input[] = br.readLine().split(" ");
			food[i] = new material(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		subSet(0, 0, sin, ssn);

		System.out.print(MIN);
	}

	private static void subSet(int pick, int cnt, int sinmat, int ssnmat) {

		if (cnt == N) {
			int ans = Math.abs(ssnmat - sinmat);

			if (pick != 0)
				MIN = Math.min(ans, MIN);
			return;
		}
		subSet(pick + 1, cnt + 1, sinmat * food[cnt].x, ssnmat + food[cnt].y);
		subSet(pick, cnt + 1, sinmat, ssnmat);
	}
}

class material {
	int x, y;

	material(int x, int y) {
		this.x = x;
		this.y = y;
	}
}