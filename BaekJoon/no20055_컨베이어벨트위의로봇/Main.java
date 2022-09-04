package BaekJoon.no20055_컨베이어벨트위의로봇;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, zero;
	static int[][] belt;
	static boolean[] robot;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		zero = 0; // 내구도가 0인 칸
		belt = new int[2][N];
		robot = new boolean[N]; // 로봇은 윗 줄에만 존재할 수 있다.

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) // 윗 줄 채우기
			belt[0][i] = Integer.parseInt(st.nextToken());
		for (int i = N - 1; i >= 0; i--) // 아랫 줄 채우기
			belt[1][i] = Integer.parseInt(st.nextToken());

		int cnt = 1;
		while (true) {
			moveBelt(); // 벨트 회전
			moveRobot(); // 로봇 이동
			setRobot(); // 로봇 올리기
			if (zero >= K) {
				System.out.print(cnt);
				break;
			}
			cnt++;
		}

		br.close();
	}

	// 칸의 내구도가 0이 되면 1 증가
	private static void zeroCheck(int remain) {
		if (remain == 0)
			zero++;
	}

	// 올리는 위치 belt[0][0]에 올릴 수 있다면
	private static void setRobot() {
		if (belt[0][0] > 0) {
			robot[0] = true;
			zeroCheck(--belt[0][0]);
		}
	}

	// 다음 칸으로 로봇이 움직일 수 있다면
	private static void moveRobot() {
		for (int i = N - 1; i >= 0; i--) {
			if (robot[i] && !robot[i + 1] && belt[0][i + 1] > 0) {
				robot[i] = false;
				robot[i + 1] = true;
				zeroCheck(--belt[0][i + 1]);
			}
		}
	}

	private static void moveBelt() {
		int temp = belt[1][0];
		for (int i = 1; i < N; i++)
			belt[1][i - 1] = belt[1][i];

		belt[1][N - 1] = belt[0][N - 1];

		for (int i = N - 1; i >= 1; i--)
			belt[0][i] = belt[0][i - 1];

		belt[0][0] = temp;

		// 벨트가 움직이면, 로봇도 같이 움직여진다.
		for (int i = N - 2; i >= 0; i--) {
			if (robot[i]) {
				robot[i + 1] = true;
				robot[i] = false;
			}
		}
		robot[N - 1] = false;
	}
}
