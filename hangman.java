import java.util.Scanner;

class hangman {

    public static void main(String[] args) {
        stats st = new stats();
        String word;
        boolean playing = true;
        Scanner s = new Scanner(System.in);
        do {
            st.reset();

            System.out.print("Welcome to hangman!\nPlayer 1, enter a word: ");

            word = s.next();
            st.setWord(word);

            clearScreen();

            do {

                st.showStats();
                System.out.print("PLayer 2, guess a letter: ");
                st.p2guess(s.next().toLowerCase().charAt(0));
                clearScreen();
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

}
