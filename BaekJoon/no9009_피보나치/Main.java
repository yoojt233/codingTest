package BaekJoon.no9009_피보나치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	static ArrayList<Integer> numbers;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(br.readLine());
		numbers = new ArrayList<>();
		numbers.add(0);
		numbers.add(1);
		while (tc-- > 0) {
			int target = Integer.parseInt(br.readLine());
			int last = numbers.size() - 1;
			while (numbers.get(last) <= target) {
				numbers.add(numbers.get(last) + numbers.get(last - 1));
				++last;
			}

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			while (target > 0) {
				pq.add(getLast(target));
				target -= pq.peek();
			}

			while (!pq.isEmpty())
				sb.append(pq.poll() + " ");
			sb.append("\n");
		}

		System.out.print(sb);
		br.close();
	}

	private static Integer getLast(int target) {
		int idx = 0;
		while (numbers.get(idx) <= target)
			++idx;
		return numbers.get(idx - 1);
	}
}
