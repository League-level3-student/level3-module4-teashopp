package _01_TestMatchingBrackets;

import java.util.Stack;

public class TestMatchingBrackets {
	/*
	 * Use a Stack to complete the method for checking if every opening bracket has
	 * a matching closing bracket
	 */
	public static boolean doBracketsMatch(String b) {

		Stack<Character> check = new Stack<Character>();

		// add {} to stack
		for (int i = b.length() - 1; i >= 0; i--) {
			check.push(b.charAt(i));
		}
		
		System.out.println(check);
		
		int total = 0;

		// even total
		if (check.size() % 2 == 0) {

			while (check.size() > 0) {
				
				char poppedchar = check.pop();
				System.out.println(poppedchar);
				
				if(poppedchar == '{') {
					total = total + 1;
				}
				
				else {
					total = total - 1;
				}
				
				if(total < 0) {
					return false;
				}
				
			}
			
			
			if(total == 0) {
				return true;
			}
			
			else {
				return false;
			}
		
		}

		// odd total
		else {
			return false;
		}
		
	}
}