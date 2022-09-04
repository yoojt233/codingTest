package BaekJoon.no12015_가장긴증가하는부분수열2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		List<Integer> LIS = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			if (LIS.isEmpty())
				LIS.add(cur);
			else {
				if (LIS.get(LIS.size() - 1) < cur)
					LIS.add(cur);
				else {
					int where = Collections.binarySearch(LIS, cur);
					if (where < 0)
						LIS.set(-where - 1, cur);
				}
			}
		}

		System.out.println(LIS.size());
		br.close();
	}
}