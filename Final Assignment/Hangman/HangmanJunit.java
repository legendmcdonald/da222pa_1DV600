package Hangman;




import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class HangmanJunit {
     public H2 e= new H2(); 
   
    
    @BeforeEach
    public void start() {
    	e= new H2();
    }
    
	
	@Test
	public void shouldReturnTrueIfItsLetterisInWord() {
		String str = "hello";
		String expected ="H";
		String actual = e.getOnlyFirstLetter(str);
		
		assertEquals(expected, actual);
	}
	@Test
	public void shouldReturnTrueIfGameIsOver() {
		int tries=6;
		boolean expected =false;
		
		boolean actual = e.isOver(tries);
		assertEquals(expected, actual);
		
	}
	@Test
	public void shouldReturnTrueIfItsInfo() {
		String str="Guess a name of a country";
		String expected="";
		String actual = e.info(str);
		assertEquals(expected, actual);
	}


}
