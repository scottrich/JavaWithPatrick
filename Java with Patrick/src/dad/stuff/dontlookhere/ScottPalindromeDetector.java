package dad.stuff.dontlookhere;
import palindromes.IPalindromeDetector;
public class ScottPalindromeDetector implements IPalindromeDetector {
	
	private static String whitespace = " .,'\"";

	public ScottPalindromeDetector() {
	}
	
	public boolean isPalindromeSlow(String palindrome) {
		if (palindrome == null || palindrome.length() == 0) 
			return false;
		
		// remove whitespace
		palindrome = palindrome.replaceAll("\\s", "").toLowerCase();

		char[] array = palindrome.toCharArray();
		for (int i = 0; i < (array.length / 2); i++) {
			if (array[i] != array[array.length-1-i])
				return false;
		}
		return true;  
	}

	/* (non-Javadoc)
	 * @see IPalindromeDetector#isPalindrome(java.lang.String)
	 */
	@Override
	public boolean isPalindrome(String palindrome) {
		if (palindrome == null || palindrome.length() == 0) 
			return false;
		
		char[] array = palindrome.toCharArray();
		int skipLeft=0, skipRight = 0;
		for (int i = 0; i < (array.length / 2); i++) {
			while(whitespace.indexOf(array[i+skipLeft]) != -1)
				skipLeft++;
			while(whitespace.indexOf(array[array.length-1-i-skipRight]) != -1)
				skipRight++;
			if (Character.toLowerCase(array[i+skipLeft]) != Character.toLowerCase(array[array.length-1-i-skipRight]))
				return false;
		}
		return true;  
	}
	
}
