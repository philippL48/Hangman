import java.util.Random;
import java.util.Scanner;
public class HangMan {
    private  int MAX_WRONG_GUESSES = 10;
    private String usedCharacters;
    private String currentWord;
    private int wrongGuesses;

    public static void main(String[] args) {
        String test = "abcd";
        System.out.println(test.charAt(2));

    }

    public void HangMan() {
        String[] wordsSelection = {"Test", "Ausprobieren", "Herausfinden"};
        Random random = new Random();
        currentWord = wordsSelection[random.nextInt((wordsSelection.length-1) - 0) + 0].toLowerCase();


    }

    public void HangMan(String word) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bitte geben sie das zu erratende Wort ein:");
        currentWord = input.toString();
    }

    public boolean makeGuess(char character) {
        usedCharacters += character;
        for (int i = 0; i < currentWord.length(); i++) {    //iteriert über currentWord und
            if (currentWord.charAt(i) == character) {       //vergleicht mit character
                return true;
            }
        }
        wrongGuesses++;
        return false;
    }

    public int wrongTriesLeft() {
        return MAX_WRONG_GUESSES - wrongGuesses;
    }

    public  String solution() {
        return currentWord;

    }
    @Override
    public String toString() {
        String displayWord = currentWord;
        for (int i = 0; i < usedCharacters.length(); i++) {
            if(!currentWord.contains(Character.toString(usedCharacters.charAt(i)))) { //Wenn der guessedChar nicht im Wort enthalten ist
                    displayWord.replaceAll(Character.toString(usedCharacters.charAt(i)), "_"); //guessedChar wird mit "_" replaced
            }
        }
        System.out.println(displayWord);
        return displayWord;
    }

    public boolean isWon() {
        for (int i = 0; i < currentWord.length(); i++) {
            if (!usedCharacters.contains(Character.toString(currentWord.charAt(i))) ) { //checkt ob Buchstabe aus currentword schon geguessed wurde
                return false;
            }
        }
        return true;
    }

    public boolean isGameOver() {
        if (wrongGuesses == MAX_WRONG_GUESSES) {
            return true;
        } else return false;
    }


}
