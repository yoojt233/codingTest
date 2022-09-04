package SWEA.no4013_특이한자석;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static char[][] gear;
	static possible[] roll;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			gear = new char[4][8];

			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++)
					gear[i][j] = st.nextToken().charAt(0);
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int std = Integer.parseInt(st.nextToken()) - 1; // 기준
				int dir = Integer.parseInt(st.nextToken()); // 방향

				roll = new possible[4];
				for (int j = 0; j < 4; j++)
					roll[j] = new possible(false, 1);

				check(std, dir);
				for (int j = 0; j < 4; j++) {
					if (roll[j].a) {
						if (roll[j].dir == 1)
							turn_right(gear[j]);
						else
							turn_left(gear[j]);
					}
				}
			}

			// 점수 계산
			int ans = 0;
			for (int i = 0; i < 4; i++) {
				if (gear[i][0] == '1')
					ans += Math.pow(2, i);
			}

			sb.append("#" + t + " " + ans + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}

	// 회전가능여부, 방향
	private static void check(int std, int dir) {
		roll[std].a = true;
		roll[std].dir = dir;
		if (std - 1 >= 0 && gear[std][6] != gear[std - 1][2] && !roll[std - 1].a) {
			check(std - 1, dir * (-1));
		}

		if (std + 1 < 4 && gear[std][2] != gear[std + 1][6] && !roll[std + 1].a) {
			check(std + 1, dir * (-1));
		}
	}

	// 왼쪽 회전
	public static void turn_left(char[] gear) {
		char temp = gear[0];
		for (int i = 1; i <= 7; i++)
			gear[i - 1] = gear[i];
		gear[7] = temp;
	}

	// 오른쪽 회전
	public static void turn_right(char[] gear) {
		char temp = gear[7];
		for (int i = 7; i > 0; i--)
			gear[i] = gear[i - 1];
		gear[0] = temp;
	}
}

// 회전? 방향?
class possible {
	boolean a;
	int dir;

	public possible(boolean a, int dir) {
		super();
		this.a = a;
		this.dir = dir;
	}
}