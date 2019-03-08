package Hangman;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HangmanFx extends Application {
	Image Image1 = new Image(getClass().getResourceAsStream("hang.png"));
	Image Image2 = new Image(getClass().getResourceAsStream("hang2.png"));
	Image Image3 = new Image(getClass().getResourceAsStream("hang3.png"));
	Image Image4 = new Image(getClass().getResourceAsStream("hang4.png"));
	Image Image5 = new Image(getClass().getResourceAsStream("hang5.png"));
	Image Image6 = new Image(getClass().getResourceAsStream("hang6.png"));
	Image Image7 = new Image(getClass().getResourceAsStream("hangmanThanks.png"));

	private TextField tfGuess = new TextField();

	private TextField tfLettersGuessed = new TextField();

	Countries word = new Countries();
	private Text[] text;

	private Label guessesRemaining;

	private int left;

	// This arrayList holds the individual parts of the body.
	private ArrayList<ImageView> body;
	private ArrayList<ImageView> thanks;
	private ArrayList<Label> lost;

	private ObservableList<Node> children;

	private StringBuilder guessedLetters;

	private String theWord;

	private void initBlanks(String word) {
		Line[] blanks = new Line[word.length()];
		int xStart = 320;
		int lineLength = 30;
		int lineSpacing = 35;
		for (int i = 0; i < blanks.length; i++) {
			// Calculate the starting point of the line segment
			int xcoord = xStart + (lineSpacing * i);
			// create the line
			blanks[i] = new Line(xcoord, 225, xcoord - lineLength, 225);
			blanks[i].setStroke(Color.BLACK);
			blanks[i].setStrokeWidth(3);
			children.add(blanks[i]);
		}
	}

	public Text[] initText(String word) {
		Text[] text = new Text[word.length()];
		int xStartw = 295;
		int lineSpacingw = 35;
		for (int i = 0; i < text.length; i++) {

			// Calculate the starting point of the line segment
			int xcoordw = xStartw + (lineSpacingw * i);
			text[i] = new Text(word.substring(i, i + 1));
			text[i].setFont(new Font(30));
			text[i].setX(xcoordw);
			text[i].setY(220);
			text[i].setVisible(false);
			children.add(text[i]);
		}
		return text;
	}

	private void initBody() {
		body = new ArrayList<ImageView>();

		// head
		ImageView mv6 = new ImageView(Image6);
		mv6.setFitWidth(350);
		mv6.setFitHeight(350);
		mv6.setLayoutX(0);
		mv6.setLayoutY(120);
		body.add(mv6);
		mv6.setVisible(false);
		children.add(mv6);

		// body
		ImageView mv5 = new ImageView(Image5);
		mv5.setFitWidth(350);
		mv5.setFitHeight(350);
		mv5.setLayoutX(0);
		mv5.setLayoutY(120);
		;
		body.add(mv5);
		mv5.setVisible(false);
		children.add(mv5);

		// right hand
		ImageView mv4 = new ImageView(Image4);
		mv4.setFitWidth(350);
		mv4.setFitHeight(350);
		mv4.setLayoutX(0);
		mv4.setLayoutY(120);
		body.add(mv4);
		mv4.setVisible(false);
		children.add(mv4);

		// left hand
		ImageView mv3 = new ImageView(Image3);
		mv3.setFitWidth(350);
		mv3.setFitHeight(350);
		mv3.setLayoutX(0);
		mv3.setLayoutY(120);
		body.add(mv3);
		mv3.setVisible(false);
		children.add(mv3);

		// left leg
		ImageView mv2 = new ImageView(Image2);
		mv2.setFitWidth(350);
		mv2.setFitHeight(350);
		mv2.setLayoutX(0);
		mv2.setLayoutY(120);
		body.add(mv2);
		mv2.setVisible(false);
		children.add(mv2);

		// dead
		ImageView mv1 = new ImageView(Image1);
		mv1.setFitWidth(350);
		mv1.setFitHeight(350);
		mv1.setLayoutX(0);
		mv1.setLayoutY(120);
		body.add(mv1);
		mv1.setVisible(false);
		children.add(mv1);
	}

	private void thanks() {

		thanks = new ArrayList<ImageView>();
		ImageView mvs7 = new ImageView(Image7);
		mvs7.setFitWidth(350);
		mvs7.setFitHeight(350);
		mvs7.setLayoutX(500);
		mvs7.setLayoutY(190);
		mvs7.setVisible(false);
		thanks.add(mvs7);
		children.add(mvs7);
	}
	
	private void lost() {
		lost = new ArrayList<Label>();
		Label win = new Label(theWord);
		win.setFont(new Font("Arial Nova", 30));
		win.setLayoutX(300);
		win.setLayoutY(130);
		win.setVisible(false);
		lost.add(win);
		children.add(win);
		
	}
	public String info(String info) {
		String str=info;
		return str;
	}

	public void start(Stage primaryStage) throws Exception {

		Pane pane = new Pane();

		// Store the children variable for easier access
		children = pane.getChildren();
		
		

		// initialize the body
		initBody();

		theWord = word.getRandomWord().toUpperCase();

		// Initialize the guessed Letters StringBuilder
		guessedLetters = new StringBuilder();

		// initialize the Blanks (lines)
		initBlanks(theWord);
		System.out.println(theWord);

		// initialize the word drawing
		text = initText(theWord);

		// initialize the remaining guesses
		left = 6;

		thanks();
		
		lost();
		
		

		Group root = new Group();
		Button start = new Button("PLAY");
		start.setLayoutX(380);
		start.setLayoutY(500);

		Button pause = new Button("Pause");
		pause.setLayoutX(70);
		pause.setLayoutY(550);

		Label wel = new Label("Welcome To");
		wel.setFont(new Font("Forte", 50));
		wel.setLayoutX(275);
		wel.setLayoutY(10);

		Label heading = new Label("Hangman");
		heading.setFont(new Font("Gang of three", 50));
		heading.setLayoutX(290);
		heading.setLayoutY(50);

		Image Image1 = new Image(getClass().getResourceAsStream("hangman.png"));
		Image Image2 = new Image(getClass().getResourceAsStream("hang1.png"));

		// Image reference -
		// https://www.kisspng.com/png-i-cannot-think-of-any-need-in-childhood-as-strong-3321490/
		ImageView mvs1 = new ImageView(Image1);
		ImageView mvs2 = new ImageView(Image2);

		mvs1.setFitWidth(350);
		mvs1.setFitHeight(350);
		mvs1.setLayoutX(220);
		mvs1.setLayoutY(120);

		mvs2.setFitWidth(350);
		mvs2.setFitHeight(350);
		mvs2.setLayoutX(0);
		mvs2.setLayoutY(120);

		Button exit = new Button("QUIT");
		exit.setLayoutX(700);
		exit.setLayoutY(550);

		exit.setOnAction(e -> Platform.exit()

		);

		root.getChildren().addAll(mvs1, start, wel, heading, exit);
		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("Hangman");
		scene.setFill(Color.ORANGE);
		primaryStage.setScene(scene);
		primaryStage.show();
		
		GridPane gridPane = new GridPane(); // Create UI
		gridPane.setLayoutX(380);
		gridPane.setLayoutY(350);
		gridPane.setHgap(5);
		gridPane.setVgap(5);
		// gridPane.add(new Label ("Enter a letter:"), 0, 0);
		Label gl = new Label("Guess  a  letter");
		gl.setFont(new Font("Arial Rounded MT", 16));
		gl.setLayoutX(400);
		gl.setLayoutY(280);

		
		//guess word pane
		gridPane.add(tfGuess, 1, 0);
		tfGuess.setLayoutX(380);
		tfGuess.setLayoutY(300);
		
		tfGuess.setOnKeyPressed(event -> {
			playGame();
		});
		
		
		Label gl1 = new Label("Letters Guessed");
		gl1.setFont(new Font("Arial Rounded MT", 16));
		gl1.setLayoutX(400);
		gl1.setLayoutY(340);
		// gridPane.add(new Label("Letters Guessed:"), 0, 1);
		gridPane.add(tfLettersGuessed, 1, 1);
		tfLettersGuessed.setLayoutX(380);
		tfLettersGuessed.setLayoutY(360);

		// gridPane.add(new Label("Guesses Remaining:"), 0, 2);
		Label gl2 = new Label("Guesses Remaining");
		gl2.setFont(new Font("Arial Rounded MT", 16));
		gl2.setLayoutX(400);
		gl2.setLayoutY(400);
		guessesRemaining = new Label(String.valueOf(left));
		guessesRemaining.setFont(new Font("Arial Rounded MT", 16));
		guessesRemaining.setLayoutX(445);
		guessesRemaining.setLayoutY(420);
		gridPane.add(guessesRemaining, 0, 3);

		BorderPane thing = new BorderPane();
		thing.setRight(gridPane);
		thing.setCenter(pane);

		Label heading1 = new Label("WELCOME");
		heading1.setFont(new Font("Gang of three", 50));
		heading1.setLayoutX(300);
		heading1.setLayoutY(30);

		Button exit2 = new Button("QUIT");
		exit2.setLayoutX(700);
		exit2.setLayoutY(550);

		exit2.setOnAction(e -> Platform.exit()

		);

		Button restart = new Button("RESTART");
		restart.setLayoutX(380);
		restart.setLayoutY(550);

		info("Guess a name of a country");
		


		Group root1 = new Group();
		root1.getChildren().addAll(mvs2, heading1, pause, exit2, gridPane, pane, thing, tfGuess, restart,
				guessesRemaining, gl2, tfLettersGuessed, gl1, gl);
		Scene scene1 = new Scene(root1, 800, 600);
		scene1.setFill(Color.AQUAMARINE);

		start.setOnAction(e -> {
			playGame();
			primaryStage.close();
			primaryStage.setScene(scene1);
			primaryStage.show();
			primaryStage.setTitle("Hangman");

		});

		pause.setOnAction(e -> {

			primaryStage.setScene(scene);
			primaryStage.close();
			primaryStage.show();
			primaryStage.setTitle("Hangman");

		});
		restart.setOnAction(e -> {
			tfGuess.setDisable(false);
			
			children.clear();
	       
			initBody();
			tfLettersGuessed.clear();

			theWord = word.getRandomWord().toUpperCase();

			// Initialize the guessed Letters StringBuilder
			guessedLetters = new StringBuilder();

			// initialize the Blanks (lines)
			initBlanks(theWord);
			System.out.println(theWord);

			// initialize the word drawing
			text = initText(theWord);

			// initialize the remaining guesses
			left = 6;
			guessesRemaining.setText(String.valueOf(left));
			
			thanks();
			
			lost();


		});

	}

	public static void main(String[] args) {
		launch(args);

	}

	private void playGame() {

		String guess = tfGuess.getText(); // first letter of user entered value
		if (guess.length() == 0) {
			return;
		}
		//HERE
		guess = getOnlyFirstLetter(guess);
		// reset the textbox for guessing the letter
		tfGuess.setText("");

		// Check if this is not the first guess
		if (guessedLetters.length() > 0) {
			// Check if letter has already been guessed
			if (guessedLetters.indexOf(guess) > -1) {

				return;
			} else {
				guessedLetters.append(guess);
			}
		} else { // is first guess
			guessedLetters.append(guess);
		}
		tfLettersGuessed.setText(guessedLetters.toString());


		if (!isGood(guess,text,theWord)) {
			//HERE
			// Draw the part of the hangman
			body.get(6 - left).setVisible(true);
			// Decrease number of guesses
			left--;
			// Update the Remaining Guesses Text
			guessesRemaining.setText(String.valueOf(left));
		}

		// No more guesses - GAME OVER
		
			tfGuess.setDisable(isOver(left));
			lost.get(0).setVisible(isOver(left));
			// GAME OVER
		
		
		
		
		if (isSolved(text)) {
			tfGuess.setDisable(true);
			for (int i = 0; i < body.size(); i++)
				body.get(i).setVisible(false);

			thanks.get(0).setVisible(true);
			// Winning message
		}

	}
	// If all text[] items are visible, the word is solved
	public boolean isSolved(Text[]textarray) {
		boolean solved = true;
		for (int i = 0; i < textarray.length; i++) {
			if (!textarray[i].isVisible()) {
				solved = false;
				break;
			}
		}
		return solved;
	}
	
	public String getOnlyFirstLetter(String str) {
		if (str.length() > 1) { // if more than one letter, take only the
		// first
			str = str.substring(0, 1);
		}
		str = str.toUpperCase();
		return str;
	}
	
	public boolean isGood(String guessss,Text[]t,String word) {
		boolean good = false;
		for (int i = 0; i < word.length(); i++) {
			// Check if guessed letter is at position(i) in the word to guess
			if (guessss.equalsIgnoreCase(word.substring(i, i + 1))) {
				// Letter found, make the respective text visible
				t[i].setVisible(true);
				// guess was good, the letter was in the word
				good = true;

			}
		}
		return good;
	}
	
	public boolean isOver(int tries) {
		if (tries == 0) {
			return true;
			// GAME OVER
		}else 
			return false;
	}

}
