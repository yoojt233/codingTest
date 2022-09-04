package BaekJoon.no16935_배열돌리기3_unsolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R; // 행 열 시행횟수
	static int size; // 행과 열 중 큰 수
	static char[][] arr;
	static char[] rotation;

	public static void main(String[] args) throws IOException {
		input();
		for (int i = 0; i < R; i++) {
			switch (rotation[i]) {
			case '1':
				f1();
				break;
			case '2':
				f2();
				break;
			case '3':
				f3();
				break;
			case '4':
				f4();
				break;
			case '5':
				f5();
				break;
			case '6':
				f6();
				break;
			}
		}
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != ' ')
					sb.append(arr[i][j]).append(" ");
				else
					continue;
			}
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	private static char[][] f1() {
		// 상하 반전
		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				char temp = arr[i][j];
				arr[i][j] = arr[arr.length - i - 1][j];
				arr[arr.length - i - 1][j] = temp;
			}
		}
		return arr;
	}

	private static char[][] f2() {
		// 좌우 반전
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length / 2; j++) {
				char temp = arr[i][j];
				arr[i][j] = arr[i][arr[0].length - j - 1];
				arr[i][arr[0].length - j - 1] = temp;
			}
		}
		return arr;
	}

	private static void f3() {
		// 우향 우

	}

	private static void f4() {
		// 좌향 좌

	}

	private static void f5() {

	}

	private static void f6() {

	}

	// 파일 읽어오기
	private static void input() throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer nmr = new StringTokenizer(br.readLine());
		N = Integer.parseInt(nmr.nextToken());
		M = Integer.parseInt(nmr.nextToken());
		R = Integer.parseInt(nmr.nextToken());

		size = Math.max(N, M);

		arr = new char[size][size];
		rotation = new char[R];

		// 배열 data 입력
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
				arr[i][j] = st.nextToken().charAt(0);
		}

		// 연산 실행 순서
		StringTokenizer rot = new StringTokenizer(br.readLine());
		for (int i = 0; i < R; i++)
			rotation[i] = rot.nextToken().charAt(0);
	}

}
