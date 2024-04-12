import java.util.Scanner;

/**
 * Class representing a view for displaying symptom summary information.
 * Allows users to view symptom responses for a specific game and determine the risk indicator.
 */
public class SymptomSummaryView {

    /**
     * Method to display symptom summary information.
     * Prompts the user to enter the game number and displays symptom responses,
     * total symptoms, severity score, and risk indicator for the selected game.
     */
    public static void view() {
        Scanner scan = new Scanner(System.in);

        // Prompt for game number
        System.out.println("Please enter the game number you would like to see?");
        int gameNum = scan.nextInt();

        // Display symptom responses for the selected game
        for (int i = 0; i < 22; i++) {
            System.out.println(Athlete.symptomQuestions[i] + ": " + Athlete.symptoms2DArray[gameNum][i]);
        }

        // Display total symptoms and severity score for the selected game
        System.out.println("The total symptoms for this game is: " + Athlete.symptomCount[gameNum]);
        System.out.println("The severity score for this game is: " + Athlete.severity[gameNum]);

        // Prompt to view risk indicator
        System.out.println("Would you like to view the 'Am I At Risk' information? Type Y or N");
        String response = scan.next().toUpperCase();

        // Display risk indicator based on user response
        if (response.equals("Y")) {
            System.out.println(Athlete.getRiskIndicator());
            System.out.println("You will now be directed back to the start-up menu!\n");
        } else {
            System.out.println("Thanks for checking in! You will now be directed back to the start-up menu.\n");
        }
    }
}
