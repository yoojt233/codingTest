package BaekJoon.no6986_절사평균;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		double[] jumsu = new double[N];
		for (int i = 0; i < N; i++)
			jumsu[i] = Double.parseDouble(br.readLine());

		Arrays.sort(jumsu);
		a(jumsu, K);
		b(jumsu, K);

		System.out.print(sb.toString());
		br.close();
	}

	private static void b(double[] jumsu, int k) {
		double[] bojung = jumsu.clone();
		for (int i = 0; i < k; i++) {
			bojung[i] = bojung[k];
			bojung[bojung.length - 1 - i] = bojung[bojung.length - 1 - k];
		}

		double total = 0;
		for (double d : bojung)
			total += d;
		String str = String.format("%.2f", total / N);
		sb.append(str);
	}

	private static void a(double[] jumsu, int k) {
		double[] julsa = jumsu.clone();
		for (int i = 0; i < k; i++) {
			julsa[i] = 0;
			julsa[julsa.length - 1 - i] = 0;
		}

		double total = 0;
		for (double d : julsa)
			total += d;
		String str = String.format("%.2f", total / (N - 2 * k));
		sb.append(str).append("\n");
	}
}
