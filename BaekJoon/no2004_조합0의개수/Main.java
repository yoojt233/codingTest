package BaekJoon.no2004_조합0의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long n = Long.parseLong(st.nextToken());
		long r = Long.parseLong(st.nextToken());

		int[] front = getNum(n); // n!에서 2와 5의 갯수
		int[] end = getNum(r); // r!에서 2와 5의 갯수
		int[] middle = getNum(n - r); // (n-r)!에서 2와 5의 갯수

		System.out.print(Math.min(front[0] - middle[0] - end[0], front[1] - middle[1] - end[1]));

		br.close();
	}

	private static int[] getNum(long num) {
		int two = 0, five = 0;
		long start = 2;
		// 2로 나눠지면 증가, 다음 기준값 x2
		while (start <= num) {
			two += num / start;
			start *= 2;
		}
		start = 5;
		// 5로 나눠지면 증가, 다음 기준값 x5
		while (start <= num) {
			five += num / start;
			start *= 5;
		}
		return new int[] { two, five };
	}
}
