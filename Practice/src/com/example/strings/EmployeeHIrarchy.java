package com.example.strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/***
 * 
 * @author vkukkar CEO\n\t VP1 \n\t\t DIR1 \n\t\t\t MG1 \n\t\t\t\t EP1
 *         \n\t\t\t\t EP2 \n\t\t DIR2 \n\t\t\t MG2 \n\t\t\t\t EP3 \n\t\t\t\t EP4
 * 
 *         CEO VP1 DIR1 MG1 EP1 EP2 DIR2 MG2 EP3 EP4
 * 
 *         EMP3 Output : Heirarchy of employee EMP3
 * 
 *         // CEO VP1,DIR1 // VP1 DIR1
 * 
 *         // 1 CEO // 2 VP1 // 3 DIR2 // 4 MG2 // 5 EP3
 * 
 */
public class EmployeeHIrarchy {

	public static void main(String[] args) {

		String input = "CEO\n\tVP1\n\t\tDIR1\n\t\t\tMG1\n\t\t\t\tEP1\n\t\t\t\tEP2\n\t\tDIR2\n\t\t\tMG2\n\t\t\t\tEP3\n\t\t\t\tEP4";
		System.out.println(new EmployeeHIrarchy().findHirarchy(input, "EP2"));
		System.out.println(new EmployeeHIrarchy().find(input, "EP2"));

	}

	public List<String> find(String s, String t) {
		StringTokenizer tok = new StringTokenizer(s, "\n");
		List<String> stk = new ArrayList<>();

		while (tok.hasMoreTokens()) {
			String w = tok.nextToken();
			int i = 0;
			for (; i < w.length(); i++) {
				if (w.charAt(i) != '\t')
					break;
			}
			w = w.substring(i);
			while (stk.size() > i)
				stk.remove(stk.size() - 1);
			stk.add(w);
			if (w.equalsIgnoreCase(t))
				break;
		}

		return stk;
	}

	private Collection<String> findHirarchy(String input, String emp) {

		StringTokenizer token = new StringTokenizer(input, "\n");
		Map<Integer, String> map = new HashMap<>();
		while (token.hasMoreTokens()) {

			int count = 0;
			String temp = token.nextToken();

			while (Character.isWhitespace(temp.charAt(count)))
				count++;

			map.put(count, temp.trim());

			if (temp.trim().equals(emp))
				break;
		}
		return map.values();
	}

}
