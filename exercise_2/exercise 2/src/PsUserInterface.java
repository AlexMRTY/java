/*
 * Use scan.readLine() when reading menu alternatives. Use string.charAt(int index)
 * to get a specific character from the input string.
 */
import psmodel.PsLogic;
import utils.Card;
import utils.Pile;

import java.util.ArrayList;
import java.util.Scanner;
public class PsUserInterface {
    private Scanner scan;
    private PsLogic game;
    public PsUserInterface(PsLogic game) {
        this.game = game;
        scan = new Scanner(System.in);
    }
    // main loop
    public void run() {
        char choice = ' ';
        String answer;
        do {
            printPiles(game.getPiles());
            printMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choice = answer.charAt(0); // first character
            switch (choice) {
                case 'A' -> drawCard();
                case 'N' -> game.initNewGame();
                case 'X' -> System.out.println("Bye, bye!");
                default -> System.out.println("Unknown command");
            }
        } while(choice != 'X' && !game.isGameOver());

        if (choice == 'X') return;

        printResult(game.getPiles());
        int totalPoints = game.getPoints();
        System.out.printf("Congrats You have %d Points!!!%n", totalPoints);

    }
    public void drawCard() {
        Card card = game.pickNextCard();
        System.out.printf("You have picked card %s\n", card.toShortString());
        int choosenPile = askUserForPile();
        game.addCardToPile(choosenPile);
    }

    private int askUserForPile() {
        System.out.print("Choose pile 1-5 => ");
        return Integer.parseInt(scan.nextLine()) - 1;
    }
//    public void doThat() {
//        System.out.println("Doing that...");
//    }
    public void printMenu() {
        System.out.println("---Menu---");
        System.out.println("A) Draw next card.");
        System.out.println("B) New Game.");
        System.out.println("X) Exit.");
        System.out.println("----------");
    }

    private void printPiles(Pile[] piles) {
        System.out.println("------------------Solitaire----------------");
        for (Pile pile : piles) {
            System.out.println(pile);
        }
    }

    private void printResult(Pile[] piles) {
        System.out.println("------------------Result----------------");
        for (Pile pile : piles) {
            System.out.println(pile);
        }
    }


//    public static void main(String[] args) {
//        PsUserInterface menu = new PsUserInterface();
//        menu.run();
//    }
}
