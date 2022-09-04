package BaekJoon.no20361_일우는야바위꾼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, where, count; // 컵의 수, 첫 공의 위치, 횟수
	static int[] cup; // 번호가 적힌 컵

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int where = Integer.parseInt(st.nextToken());
		int count = Integer.parseInt(st.nextToken());

		cup = new int[N + 1];
		for (int i = 0; i <= N; i++)
			cup[i] = i;

		// 입력 받은 번호끼리 교환
		String[] input;
		for (int i = 0; i < count; i++) {
			input = br.readLine().split(" ");
			swap(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		}

		for (int i = 1; i <= N; i++) {
			if (cup[i] == where) {
				sb.append(i).append("\n");
				break;
			}
		}

		System.out.print(sb.toString());
		br.close();
	}

	private static void swap(int x, int y) {
		int temp = cup[x];
		cup[x] = cup[y];
		cup[y] = temp;
	}
}