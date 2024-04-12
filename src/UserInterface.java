import java.util.Scanner;

/**
 * Class representing the user interface for the Sport Concussion Assessment System.
 * Provides a menu-driven interface for users to interact with the system.
 */
public class UserInterface {
    private Athlete actor;

    /**
     * Main method to start the user interface.
     * Displays the menu and prompts users for actions until they choose to exit.
     * Allows users to enter symptom responses, view symptom summary information, or exit the application.
     * Utilizes the Athlete and SymptomSummaryView classes for functionality.
     * Makes use of a loop to continuously display the menu until the user chooses to exit.
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Loop to display the menu and prompt for user response
        do {
            displayMenu();
            String response = scan.next().toUpperCase();

            // Handle user response
            if (response.equals("Y")) {
                // Prompt for action choice
                System.out.println("Please choose from the following options:");
                System.out.println("Enter 1 to enter symptom response after a game.");
                System.out.println("Enter 2 to view symptom summary information.");
                System.out.println("Enter 3 to exit the application.");

                // Read user's action choice
                int resp = scan.nextInt();
                switch (resp) {
                    case 1:
                        Athlete.symptomResponse(); // Enter symptom response
                        break;
                    case 2:
                        SymptomSummaryView.view(); // View symptom summary information
                        break;
                    case 3:
                        System.out.println("Thanks! Goodbye now!"); // Exit the application
                        quit();
                        break;
                    default:
                        System.out.println("Unknown action. Redirecting you to the main menu."); // Invalid action
                        break;
                }
            } else if (response.equals("N")) {
                System.out.println("Thanks for checking in. Goodbye!"); // Exit if not an athlete
                quit();
            } else {
                System.out.println("Not a valid response."); // Handle invalid input
            }
        } while (true); // Continue loop until user chooses to exit
    }

    /**
     * Method to display the main menu.
     * Prompts users whether they are an athlete or not.
     */
    public static void displayMenu() {
        System.out.println("Welcome to the Sport Concussion Assessment System");
        System.out.println("Are you an Athlete? Type Y or N");
    }

    /**
     * Method to exit the application.
     * Terminates the program when called.
     */
    public static void quit() {
        System.exit(0);
    }
}
