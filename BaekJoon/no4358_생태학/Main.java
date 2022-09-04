package BaekJoon.no4358_생태학;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Map<String, Integer> tree = new HashMap<>();
		ArrayList<String> species = new ArrayList<>();
		int cnt = 0;

		while (sc.hasNextLine()) {
			String str = sc.nextLine();
			if (str.equals("") || str == null)
				break;

			if (!tree.containsKey(str)) {
				tree.put(str, 1);
				species.add(str);
			} else
				tree.put(str, tree.get(str) + 1);
			cnt++;
		}

		Collections.sort(species);
		for (String s : species) {
			double avg = (double) tree.get(s) * 100 / cnt;
			sb.append(s).append(" ").append(String.format("%.4f", avg)).append("\n");
		}

		System.out.print(sb.toString());
		sc.close();
	}
}