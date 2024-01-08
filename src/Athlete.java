import java.util.Scanner;

public class Athlete {

    static int[][] symptoms2DArray = new int[5][22];
    static String[] symptomQuestions = new String[22];
    static int gameNum;
    static int[] symptomCount = new int [5];
    static int symptomNum;
    static int[] severity = new int[5];
    static int severityNum;
    public Athlete() {
       //if multiple athletes were to be created. Then could utilize
       //constructor here to initialize names for different athletes.
    }
    public static void symptomResponse() {
        Scanner scan = new Scanner(System.in);
        System.out.println("What game are you entering responses for? Please enter a value starting from 1.");
        gameNum = scan.nextInt();
        if (gameNum < 1 || gameNum > 5) {
            System.out.println("Please enter a game number from 1 to 5. If you are entering a game number greater than" +
                    " 5 then please repeat the game count after multiples of 5, i.e. game # 6 will be 1, game # 7 will be 2 and so forth.");
        }
        System.out.println("Please answer the following questions by rating each response from 0 to 6 with 0" +
                " being no pain, 1-2 being mild pain, 3-4 being moderate pain, and 5-6 being severe pain.");

        symptomQuestions[0] = "Headache";
        symptomQuestions[1] = "Pressure in head";
        symptomQuestions[2] = "Neck pain";
        symptomQuestions[3] = "Nausea or vomiting";
        symptomQuestions[4] = "Dizziness";
        symptomQuestions[5] = "Blurred vision";
        symptomQuestions[6] = "Balance problems";
        symptomQuestions[7] = "Sensitivity to light";
        symptomQuestions[8] = "Sensitivity to noise";
        symptomQuestions[9] = "Feeling slowed down";
        symptomQuestions[10] = "Feeling like 'in a fog'";
        symptomQuestions[11] = "Don't feel right";
        symptomQuestions[12] = "Difficulty concentrating";
        symptomQuestions[13] = "Difficulty remembering";
        symptomQuestions[14] = "Fatigue or low energy";
        symptomQuestions[15] = "Confusion";
        symptomQuestions[16] = "Drowsiness";
        symptomQuestions[17] = "Trouble falling asleep";
        symptomQuestions[18] = "More emotional";
        symptomQuestions[19] = "Irritability";
        symptomQuestions[20] = "Sadness";
        symptomQuestions[21] = "Nervous or anxious";


        for (int i = 0; i < 22; i++) {
            System.out.println(symptomQuestions[i]);
            int value = scan.nextInt();
            if (value < 0 || value > 6) {
                System.out.println("Please enter a value between 0 and 6.");
            }
            if (value > 0) {
                symptomNum++;
            }
            symptoms2DArray[gameNum][i] = value;
            severityNum += value;
        }

        symptomCount[gameNum] = symptomNum;
        severity[gameNum] = severityNum;
        symptomNum = 0;
        severityNum = 0;
        System.out.println("Thanks for inputting that information! You will now be directed back to the start-up menu\n");
    }


    public static String getRiskIndicator() {
        String result = null;
        Scanner scan = new Scanner(System.in);
        System.out.println("Please select the game you would like to determine for 'Am I At Risk' information.");
        gameNum = scan.nextInt();
        if (gameNum == 1) {
            return "Can't provide 'Am I At Risk' information for game 1." ;
        } else {
            int tempCount;
            String redText = "\u001B[31m";
            String greenText = "\u001B[32m";
            String yellowText = "\u001B[33m";
            String reset = "\u001B[0m";
            tempCount = symptomCount[gameNum] - symptomCount[gameNum - 1];
            if (tempCount < 3 && severity[gameNum] < 10) {
                result = (greenText + "No difference" + reset);
            } else if (tempCount < 3 && severity[gameNum] >= 10) {
                result = (yellowText + "Unsure" + reset);
            } else if (tempCount >= 3 || severity[gameNum] >= 15) {
                result = (redText + "Very different" + reset);
            }
        }
        return result;
    }

}
