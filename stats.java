import java.util.ArrayList;

public class stats {
    public int limbs = 10;
    public int lettersRemaining = 0;

    ArrayList<Character> wordArray = new ArrayList<>();
    ArrayList<Character> hiddenWordArray = new ArrayList<>();
    ArrayList<Character> lettersGuessed = new ArrayList<>();


    public void showStats(){ //here is my first method it shows the stats as stated in hangman.java

        System.out.printf("Limbs remaining: %d%nLetters remaining: %d%nLetters guessed: ", limbs,
        lettersRemaining);

        for(int i = 0; i < lettersGuessed.size(); i++){
            
            System.out.print(lettersGuessed.get(i) + " ");

        }

        System.out.println();

        for(int i = 0; i < wordArray.size(); i++){
            
            System.out.print(hiddenWordArray.get(i) + " ");

        }

        System.out.println();
    }


    public void p2guess(Character a) { //here is my second method. It takes player 2's guess and sees if it was right, wrong, or duplicate.

        if(wordArray.contains(a)){
            
            do{

                --lettersRemaining;

                hiddenWordArray.set(wordArray.indexOf(a), a);
                wordArray.set(wordArray.indexOf(a), '-');

            }while(wordArray.contains(a));

            lettersGuessed.add(a);
        }

        else if(lettersGuessed.contains(a)){

            System.out.println("You already guessed that letter.");
            
        }

        else{

            --limbs;
            lettersGuessed.add(a);

        }
    }


    public void setWord(String a) { //here is my third method. It gets the word from the scanner and sets adds it to the arraylists.

        lettersRemaining = a.length();

        for (int i = 0; i < a.length(); i++) {

            wordArray.add(a.toLowerCase().charAt(i));
            hiddenWordArray.add('-');

        }
    }

    
    public void reset() { //here it just resets the info.
        limbs = 10;
        lettersGuessed.clear();
        wordArray.clear();
        hiddenWordArray.clear();
    }

    public boolean gameOver() { //here is my last method in stats.java. it just checks the info to see if the game is over or not.

        if (limbs == 0) {

            System.out.println("Player 1 Wins!");
            return false;

        }

        if (lettersRemaining == 0) {

            System.out.println("Player 2 Wins!");
            return false;
        } 
        
        else {

            return true;

        }
    }
}
