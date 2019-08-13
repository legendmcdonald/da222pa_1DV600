package Hangman;

public class H2 {
	
	public boolean isOver(int tries) {
		if (tries == 0) {
			return true;
			// GAME OVER
		}else 
			return false;
	}
	
	public String getOnlyFirstLetter(String str) {
		if (str.length() > 1) { // if more than one letter, take only the
		// first
			str = str.substring(0, 1);
		}
		str = str.toUpperCase();
		return str;
	}
	
	public String info(String info) {
		String str=info;
		//str+=str.length;//BUG
		return str;
	}
	

}
