package Hangman;




import static org.junit.Assert.assertEquals;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javafx.scene.text.Text;

class HangmanJunit {
     public HangmanFx e= new HangmanFx(); 
    
    @BeforeEach
    public void start() {
    	e= new HangmanFx();
    }
    
	
	@Test
	public void shouldReturnTrueIfLetterisInWord() {
		String word = "hello";
		Text[] text =new Text[5];
		String guess = "o";
		boolean expected =true;
		
		boolean actual = e.isGood(guess, text, word);
		
		assertEquals(expected, actual);
	}
	@Test
	public void shouldReturnTrueIfGameIsOver() {
		int tries=6;
		boolean expected =true;
		
		boolean actual = e.isOver(tries);
		assertEquals(expected, actual);
		
		
	}

}
