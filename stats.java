import java.util.ArrayList;
public class stats {
        public int limbs = 10;
        public int wordsremaining = 0;
        ArrayList<Character> word = new ArrayList<>();
        ArrayList<Character> hiddenword = new ArrayList<>();
        ArrayList<Character> guessedwords = new ArrayList<>();
    
        public void p2guess(Character a){
            if(guessedwords.contains(a)){
                System.out.println("You already guessed that.");
            }
            else if(word.contains(a)){
                System.out.println("Correct!");
                guessedwords.add(a);
                hiddenword.set(word.indexOf(a), a);
                word.set(word.indexOf(a), '-');
                --wordsremaining;
            }
            else{
                --limbs;
                guessedwords.add(a);
                System.out.println("Incorrect Guess");
            }
        }
    
        public void removeLimb() {
            limbs -= 1;
        }
    
        public void setWord(String a) {
            wordsremaining = a.length();
            for (int i = 0; i < a.length(); i++) {
                word.add(a.toLowerCase().charAt(i));
                hiddenword.add('-');
            }
        }
    
        public void reset() {
            limbs = 10;
            guessedwords.clear();
            word.clear();
            hiddenword.clear();
        }
        public boolean gameOver(){
            if(limbs == 0){
                System.out.println("Player 1 Wins!");
                return false;
            }
            if(wordsremaining == 0){
                System.out.println("Player 2 Wins!");
                return false;
            }
            else{
                return true;
            }
        }
}
