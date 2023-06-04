import java.util.Scanner;

class hangman {

    public static void main(String[] args) {
        stats st = new stats(); //Constructor for my stats.java class

        String word; 
        boolean playing = true;

        Scanner s = new Scanner(System.in); //declared a scanner to get user input

        do {
            st.reset(); //reset all values so they would not interupt the game.

            System.out.print("Welcome to hangman!\nPlayer 1, enter a word: ");

            word = s.next();
            st.setWord(word); //sent the word to the stats class

            clearScreen(); //put 25 blank lines

            do {
                st.showStats(); //showed all of the stats for the game like the limbs remaining, lettersguessed, etc.

                System.out.print("PLayer 2, guess a letter: ");
                st.p2guess(s.next().toLowerCase().charAt(0)); //got input from player 2

                clearScreen();

                playing = st.gameOver();

            } while (playing);

        } while (playing);

        s.close(); //closed scanner
    }

    private static void clearScreen() {

        for (int i = 0; i < 25; i++) {

            System.out.println();
            
        }
    }

}
