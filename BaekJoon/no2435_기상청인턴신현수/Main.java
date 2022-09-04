package BaekJoon.no2435_기상청인턴신현수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] tem = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; ++i)
			tem[i] = Integer.parseInt(st.nextToken());

		int max = 0, sum = 0;
		for (int i = 0; i < K; ++i)
			sum += tem[i];
		max = sum;

		for (int i = K; i < N; ++i) {
			sum += tem[i];
			sum -= tem[i - K];

			max = Math.max(max, sum);
		}
		
		System.out.print(max);
		br.close();
	}
}
