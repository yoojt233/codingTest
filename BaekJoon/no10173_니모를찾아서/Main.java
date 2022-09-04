package BaekJoon.no10173_니모를찾아서;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		String pattern = ".*(nemo).*";

		while (!s.equals("EOI")) {
			if (s.toLowerCase().matches(pattern))
				sb.append("Found" + "\n");
			else
				sb.append("Missing" + "\n");

			s = br.readLine();
		}

		System.out.print(sb.toString());
		br.close();
	}
}
