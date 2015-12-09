
public class BogusPalindromeDetector implements IPalindromeDetector {

	public BogusPalindromeDetector() {
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see IPalindromeDetector#isPalindrome(java.lang.String)
	 */
	@Override
	public boolean isPalindrome(String palindrome) {
		return false;  // you're gonna be right most of the time
	}

}
