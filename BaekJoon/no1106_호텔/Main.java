package BaekJoon.no1106_호텔;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static pr[] city;
	static int[] people;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		city = new pr[N + 1];
		people = new int[C + 1];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int price = Integer.parseInt(st.nextToken());
			int person = Integer.parseInt(st.nextToken());

			city[i] = new pr(price, person);
		}

		System.out.print(recur(C, N));
		br.close();
	}

	private static int recur(int c, int N) {
		if (c <= 0)
			return 0;

		if (people[c] != 0)
			return people[c];

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++)
			min = Math.min(min, recur(c - city[i].person, N) + city[i].cost);

		people[c] = min;
		return people[c];
	}
}

class pr {
	int cost, person;

	public pr(int cost, int person) {
		super();
		this.cost = cost;
		this.person = person;
	}
}