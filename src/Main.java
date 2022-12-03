package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            int points = 0;
            System.out.println(loadData(points));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int loadData(int points) throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("CheatSheet.txt");
        Scanner scan = new Scanner(fis);
        while (scan.hasNextLine()) {
            char[] results = new char[3];
            String line = scan.nextLine();
            for (int i = 0; i < 3; i++) {
                results[i] = line.charAt(i);
            }
            //points are awarded to user IF
            //they play Rock(x) = 1, Paper(y) = 2, Scissors(z) = 3
            //and IF
            //they Win = 6, Draw = 3

            int myPoints = 0;
            String opponentChoice = null;
            String myChoice = null;
            if (line.charAt(0) == 'A') {
                opponentChoice = "Rock";
            }
            if (line.charAt(0) == 'B') {
                opponentChoice = "Paper";
            }
            if (line.charAt(0) == 'C') {
                opponentChoice = "Scissors";
            }

            if (line.charAt(2) == 'X') {
                myChoice = "Rock";
                myPoints = 1;
            }
            if (line.charAt(2) == 'Y') {
                myChoice = "Paper";
                myPoints = 2;
            }
            if (line.charAt(2) == 'Z') {
                myChoice = "Scissors";
                myPoints = 3;
            }

            if (opponentChoice.equalsIgnoreCase(myChoice)) {
                myPoints = myPoints + 3;
            }
            if (opponentChoice.equalsIgnoreCase("Rock") && myChoice.equalsIgnoreCase("Paper")) {
                myPoints = myPoints + 6;
            }
            if (opponentChoice.equalsIgnoreCase("Paper") && myChoice.equalsIgnoreCase("Scissors")) {
                myPoints = myPoints + 6;
            }
            if (opponentChoice.equalsIgnoreCase("Scissors") && myChoice.equalsIgnoreCase("Rock")) {
                myPoints = myPoints + 6;
            }
            points = points + myPoints;
        }
        return points;

    }
}


/*
if (results[0] == 'A') {
                opponentPoints += 1;
            } else if (results[0] == 'B') {
                opponentPoints += 2;
            } else if (results[0] == 'C') {
                opponentPoints += 3;
            }
            if (results[2] == 'X') {
                myPoints += 1;
            } else if (results[2] == 'Y') {
                myPoints += 2;
            } else if (results[2] == 'Z'){
                myPoints += 3;
            }

            if (myPoints > opponentPoints) {
                myPoints += 6;
            } else if (myPoints == opponentPoints) {
                myPoints += 3;
            }
            points += myPoints;
 */