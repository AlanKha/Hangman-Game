import java.util.Scanner;
import java.util.ArrayList;

class hangman {

    public static void main(String[] args) {
        stats st = new stats();
        String input;
        Character guess;
        boolean playing = true;
        Scanner s = new Scanner(System.in);
        do {

            System.out.println("Welcome to hangman!");
            System.out.print("Player 1, enter a word: ");

            input = s.next();
            st.setWord(input);

            clearScreen();

            do {
                showStats(st.limbs, st.hiddenword, st.guessedwords);
                System.out.print("PLayer 2, guess a word: ");
                guess = s.next().toLowerCase().charAt(0);
                clearScreen();
                st.p2guess(guess);
                playing = st.gameOver();
            } while (playing);
        } while (playing);
        s.close();
    }

    private static void clearScreen() {
        for (int i = 0; i < 25; i++) {
            System.out.println();
        }
    }

    public static void showStats(int a, ArrayList c, ArrayList d) {
        System.out.println("Word: " + c);
        System.out.println("Guessed Words: " + d);
        System.out.printf("limbs remaining: %d%n", a);
    }

}
