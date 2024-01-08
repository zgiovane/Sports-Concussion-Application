import java.nio.channels.GatheringByteChannel;
import java.util.Scanner;

public class UserInterface {
    private Athlete actor;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        do {
            displayMenu();
            String response = scan.next().toUpperCase();

            if (response.equals("Y")) {
                System.out.println("Please choose from the following options:");
                System.out.println("Enter 1 to enter symptom response after a game.");
                System.out.println("Enter 2 to view symptom summary information.");
                System.out.println("Enter 3 to exit the application.");

                int resp = scan.nextInt();
                switch(resp) {
                    case 1: Athlete.symptomResponse();
                    break;
                    case 2: SymptomSummaryView.view();
                    break;
                    case 3: System.out.println("Thanks! Goodbye now!");
                    quit();
                    break;
                    default: System.out.println("Unknown action. Redirecting you to the main menu.");
                    break;
                }
            } else if (response.equals("N")){
                System.out.println("Thanks for checking in. Goodbye!");
                quit();
            } else {
                System.out.println("Not a valid response.");
            }
        } while(true);
    }
    public static void displayMenu() {
        System.out.println("Welcome to the Sport Concussion Assessment System");
        System.out.println("Are you an Athlete? Type Y or N");
    }

    public static void quit() {
        System.exit(0);
    }
}
