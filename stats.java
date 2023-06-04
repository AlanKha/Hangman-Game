import java.util.ArrayList;

public class stats {
    public int limbs = 10;
    public int lettersRemaining = 0;
    ArrayList<Character> wordArray = new ArrayList<>();
    ArrayList<Character> hiddenWordArray = new ArrayList<>();
    ArrayList<Character> lettersGuessed = new ArrayList<>();

    public void showStats(){
        System.out.printf("Limbs remaining: %d%nLetters remaining: %d%nLetters guessed: ", limbs,
        lettersRemaining);
        for(int i = 0; i < wordArray.size(); i++){
            System.out.print(hiddenWordArray.get(i) + " ");
        }
        System.out.println();
    }

    public void p2guess(Character a) {
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

    public void removeLimb() {
        limbs -= 1;
    }

    public void setWord(String a) {
        lettersRemaining = a.length();
        for (int i = 0; i < a.length(); i++) {
            wordArray.add(a.toLowerCase().charAt(i));
            hiddenWordArray.add('-');
        }
    }

    public void reset() {
        limbs = 10;
        lettersGuessed.clear();
        wordArray.clear();
        hiddenWordArray.clear();
    }

    public boolean gameOver() {
        if (limbs == 0) {
            System.out.println("Player 1 Wins!");
            return false;
        }
        if (lettersRemaining == 0) {
            System.out.println("Player 2 Wins!");
            return false;
        } else {
            return true;
        }
    }
}
