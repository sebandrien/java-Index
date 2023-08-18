import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

public class RockPaperScissor {
    private int userTally = 0;
    private int computerTally = 0;
    private int gameNum;
    private Random random;

    public RockPaperScissor(int game, int seed) {
        this.gameNum = game;
        this.random = new Random(seed);
    }

    public static void greeting() {
        System.out.println("Welcome to rock, paper, scissors.");
        System.out.println("You and I will get to choose rock, paper, or scissors.");
        System.out.println("After we made a decision, we will then reveal the choices we both made and decide a winner based on these rules.");
        System.out.println("Rock beats scissors!");
        System.out.println("Paper beats rock!");
        System.out.println("Scissors beats paper!");
        System.out.println("If we both pick the same option, then it is a tie.");
        System.out.println("Ready to play? Here we go!");
    }

    public void playRound() {
        while (userTally < 3 && computerTally < 3) {
            System.out.println("Game " + gameNum + " Tally");
            System.out.println("Player 1:     " + userTally);
            System.out.println("Player 2:     " + computerTally);

            int n = userChoice();
            int k = computerChoice();

            int result = choiceBattle(n, k);

            if (result == 1) {
                userTally++;
            } else if (result == 2) {
                computerTally++;
            }
        }
    }

    public int choiceBattle(int p1, int p2) {
        String[] choices = {"Rock", "Paper", "Scissor"};
        int[][] outcome = {
            {0, 2, 1},
            {1, 0, 2},
            {2, 1, 0}
        };

        System.out.println("You used " + choices[p1 - 1] + " and I used " + choices[p2 - 1] + "!");
        return outcome[p1 - 1][p2 - 1];
    }

    public int userChoice() {
        Scanner x = new Scanner(System.in);
        int n = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.println("1: Rock");
            System.out.println("2: Paper");
            System.out.println("3: Scissor");
            System.out.print("Enter your choice: ");

            try {
                n = x.nextInt();
                if (n >= 1 && n <= 3) {
                    validInput = true;
                } else {
                    System.out.println("That is an invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                x.next();  // Clear the invalid input
            }
        }

        return n;
    }

    public int computerChoice() {
        return random.nextInt(3) + 1;
    }

    public int getWinner() {
        if (userTally == 3) {
            return 1;
        }
        if (computerTally == 3) {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        RockPaperScissor.greeting();

        RockPaperScissor game1 = new RockPaperScissor(1, 0);
        game1.playRound();

        if (game1.getWinner() == 1) {
            System.out.println("Congratulations! You beat me!");
        } else {
            System.out.println("Sorry! You didn't win!");
        }

        RockPaperScissor game2 = new RockPaperScissor(2, 6);
        game2.playRound();

        if (game2.getWinner() == 1) {
            System.out.println("Congratulations! You beat me!");
        } else {
            System.out.println("Sorry! You didn't win!");
        }

        RockPaperScissor game3 = new RockPaperScissor(3, 1);
        game3.playRound();

        if (game3.getWinner() == 1) {
            System.out.println("Congratulations! You beat me!");
        } else {
            System.out.println("Sorry! You didn't win!");
        }

        System.out.println("Thank you for playing!");
    }
}
