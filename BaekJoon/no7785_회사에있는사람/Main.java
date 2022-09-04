package BaekJoon.no7785_회사에있는사람;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		Set<String> emp = new HashSet<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();

			// HashSet에 회사원이 이미 있다는건 출근 했다는 뜻
			if (emp.contains(str))
				emp.remove(str);
			else
				emp.add(str);
		}

		// 리스트에 넣어서
		List<String> temp = new ArrayList<>();
		for (String s : emp)
			temp.add(s);

		// 역으로 정렬
		Collections.sort(temp, Collections.reverseOrder());
		for (String s : temp)
			sb.append(s + "\n");

		System.out.print(sb.toString());
		br.close();
	}
}
