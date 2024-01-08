import java.util.Scanner;
public class SymptomSummaryView {
    public static void view() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the game number you would like to see?");
        int gameNum = scan.nextInt();
        for (int i = 0; i < 22; i++) {
            System.out.println(Athlete.symptomQuestions[i] + ": " + Athlete.symptoms2DArray[gameNum][i]);
        }
        System.out.println("The total symptoms for this game is: " + Athlete.symptomCount[gameNum]);
        System.out.println("The severity score for this game is: " + Athlete.severity[gameNum]);
        System.out.println("Would you like to view the 'Am I At Risk' information? Type Y or N");
        String response = scan.next().toUpperCase();

        if (response.equals("Y")) {
            System.out.println(Athlete.getRiskIndicator());
            System.out.println("You will now be directed back to the start-up menu!\n");
        } else {
            System.out.println("Thanks for checking in! You will now be directed back to the start-up menu.\n");
        }
    }
}
