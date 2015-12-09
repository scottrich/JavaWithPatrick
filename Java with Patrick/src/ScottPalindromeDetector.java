
public class ScottPalindromeDetector implements IPalindromeDetector {

	public ScottPalindromeDetector() {
	}
	
	/* (non-Javadoc)
	 * @see IPalindromeDetector#isPalindrome(java.lang.String)
	 */
	@Override
	public boolean isPalindrome(String palindrome) {
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

}
