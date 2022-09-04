package BaekJoon.no2477_참외밭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 1m^2의 넓이에 자라는 참외의 개수
		int area = 0; // 참외밭 넓이
		int max_x = 0, max_y = 0, idx_x = 0, idx_y = 0;
		int[][] side = new int[6][2];

		// 방향과 길이 저장
		for (int i = 0; i < 6; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			side[i][0] = Integer.parseInt(st.nextToken());
			side[i][1] = Integer.parseInt(st.nextToken());
		}

		// 최대 x 길이와 인덱스, 최대 y 길이와 인덱스
		for (int i = 0; i < 6; i++) {
			if (side[i][0] == 1 || side[i][0] == 2) {
				if (max_x < side[i][1]) {
					max_x = side[i][1];
					idx_x = i;
				}
			}

			if (side[i][0] == 3 || side[i][0] == 4) {
				if (max_y < side[i][1]) {
					max_y = side[i][1];
					idx_y = i;
				}
			}
		}

		int sub_x = 0, sub_y = 0;

		// 0 일 때 side[-1]이 될 수 있으므로 경우를 나누어준다.
		if (idx_y != 0) {
			sub_x = Math.abs(side[(idx_y + 1) % 6][1] - side[(idx_y - 1) % 6][1]);
		} else {
			sub_x = Math.abs(side[(idx_y + 1) % 6][1] - side[5][1]);
		}

		if (idx_x != 0) {
			sub_y = Math.abs(side[(idx_x + 1) % 6][1] - side[(idx_x - 1) % 6][1]);
		} else {
			sub_y = Math.abs(side[(idx_x + 1) % 6][1] - side[5][1]);
		}

		area = (max_x * max_y) - (sub_x * sub_y);
		System.out.print(area * N);
		br.close();
	}
}
