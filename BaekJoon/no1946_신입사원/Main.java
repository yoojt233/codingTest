package BaekJoon.no1946_신입사원;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int tc = Integer.parseInt(br.readLine());
		for (int t = 0; t < tc; t++) {
			int N = Integer.parseInt(br.readLine());

			emp[] arr = new emp[N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new emp(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(arr);
			
			int std = arr[0].interview;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				int temp = arr[i].interview;
				if (temp <= std)
					cnt++;
				std = Math.min(std, temp);
			}

			sb.append(cnt + "\n");
		}

		System.out.print(sb.toString());
		br.close();
	}
}

class emp implements Comparable<emp> {
	int doc, interview;

	public emp(int doc, int interview) {
		super();
		this.doc = doc;
		this.interview = interview;
	}

	@Override
	public int compareTo(emp o) {
		return this.doc - o.doc;
	}
}