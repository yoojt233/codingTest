package BaekJoon.no2641_다각형그리기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] ans_case;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		ans_case = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			ans_case[0][i] = Integer.parseInt(st.nextToken());

		for (int i = 1; i < N; i++) {
			ans_case[i] = turn_left(ans_case[i - 1]);
		}

		int cnt = 0;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] input = new int[N];
			for (int j = 0; j < N; j++)
				input[j] = Integer.parseInt(st.nextToken());
			if (check(input) || check(flip(reverse(input)))) {
				cnt++;
				for (int j = 0; j < N; j++)
					sb.append(input[j]).append(" ");
				sb.append("\n");
			}
		}

		System.out.printf("%d\n", cnt);
		System.out.print(sb.toString());
	}

	private static int[] flip(int[] is) {
		int[] arr = Arrays.copyOf(is, N);
		for (int i = 0; i < N / 2; i++) {
			int temp = arr[i];
			arr[i] = arr[N - i - 1];
			arr[N - i - 1] = temp;
		}

		return arr;
	}

	private static int[] reverse(int[] input) {
		int[] arr = Arrays.copyOf(input, N);
		for (int i = 0; i < N; i++) {
			switch (arr[i]) {
			case 1:
				arr[i] = 3;
				break;
			case 2:
				arr[i] = 4;
				break;
			case 3:
				arr[i] = 1;
				break;
			case 4:
				arr[i] = 2;
				break;
			}
		}
		return arr;
	}

	private static boolean check(int[] input) {
		OUTER: for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (ans_case[i][j] != input[j])
					continue OUTER;
			}
			return true;
		}
		return false;
	}

	private static int[] turn_left(int[] before) {
		int[] arr = Arrays.copyOf(before, N);
		int temp = arr[0];
		for (int i = 0; i < N - 1; i++)
			arr[i] = arr[i + 1];
		arr[N - 1] = temp;
		return arr;
	}
}
