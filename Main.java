import java.util.Scanner;

// created and abstract class
abstract class MatchScoring{

    Scanner in = new Scanner(System.in);

    String Striker, nonStriker, bowler;
    int batterScore, totalScore = 0, overs, tossInput, overOutCount = 0, overScore = 0, totalWickets = 0;
    int totalScore2 = 0, totalWickets2 = 0, overCounter = 0;
    String team1, team2, tossWonTeam, tossLoseTeam;
    char condCheck;
    //polymorphism
    void teamNames(){
        System.out.print("Enter the name of team 1 = ");
        team1 = in.nextLine();

        System.out.print("Enter the name of team 2 = ");
        team2 = in.nextLine();

        System.out.println();
    }
    void totalOvers(){

        System.out.print("How many overs you want to play = ");
        overs = in.nextInt();

        System.out.println();
    }
    void toss() {

        int randomTeam = (int) (Math.random() * 2) + 1;
        int randomToss = (int) (Math.random() * 2) + 1;

        if(randomTeam == 1) {

            System.out.println(team1+" Please select any one from following:");
            System.out.print("Press 1 for Heads\nPress 2 for Tails\n");
            tossInput = in.nextInt();

            if (tossInput == randomToss){
                System.out.println(team1+" Won the toss");
                tossWonTeam = team1;
                tossLoseTeam = team2;
            }
            else{
                System.out.println(team2+" Won the toss");
                tossWonTeam = team2;
                tossLoseTeam = team1;
            }
        }

        else{

            System.out.println(team2+" Please select any one from following:");
            System.out.print("Press 1 for Heads\nPress 2 for Tails\n");
            tossInput = in.nextInt();

            if (tossInput == randomToss){
                System.out.println(team2+" Won the toss");
                tossWonTeam = team2;
                tossLoseTeam = team1;
            }
            else{
                System.out.println(team1+" Won the toss");
                tossWonTeam = team1;
                tossLoseTeam = team2;
            }
        }

        System.out.println();
    }
    // abstraction
    public abstract void bowlerAndBatterName();

    public abstract void batsmanAndBowlerRuns();
}

//first inning
class FirstInning extends MatchScoring{

    void output(){
        System.out.println("\n_-_-First Inning-_-_\n\n");
    }

    String battingTeam, bowlingTeam;
    int batOrBowlSelect;
    void batOrBowl(){
        System.out.print(tossWonTeam+" Please Select any one\n");
        System.out.print("Press 1 to Bat first\nPress 2 to Bowl first");
        batOrBowlSelect = in.nextInt();

        if (batOrBowlSelect == 1){
            System.out.println(tossWonTeam+ " is doing batting first");
            battingTeam = tossWonTeam;
            System.out.println(tossLoseTeam+ " is given bowling first");
            bowlingTeam = tossLoseTeam;
        }
        else{
            System.out.println(tossWonTeam+ " is doing bowling first");
            bowlingTeam = tossWonTeam;
            System.out.println(tossLoseTeam+ " is given batting first");
            battingTeam = tossLoseTeam;

            System.out.println();
        }

    }

    @Override
    public void bowlerAndBatterName() {

        in.nextLine(); //for solving error

        System.out.print("Enter the Striker side batter name = ");
        Striker = in.nextLine();

        System.out.print("Enter the Non-Striker side batter name = ");
        nonStriker = in.nextLine();

        System.out.print("Enter the Bowler name = ");
        bowler = in.nextLine();
    }

    @Override
    public void batsmanAndBowlerRuns(){

        for (int i = 0; i < overs; i++) {
            System.out.println("\nOver # "+ overCounter+1);
            for (int j = 1; j<=6; j++) {

               if (totalWickets == 10){
                   System.out.println("All Out!!!");
                   System.out.println("First Inning ended!");
                   System.out.println("First Inning has scored "+ totalScore);

                   return;
               }
               else {
                System.out.print("Press o for out! else press any to key to enter score =");
                condCheck = in.next().charAt(0);


                if (condCheck == 'o'){

                    batterScore = 0;
                    overOutCount +=1;
                    totalWickets = totalWickets + 1;

                    System.out.println("Out!!!\n");

                    in.nextLine(); // used for error handling in output---
                    if(totalWickets < 10){
                    System.out.print("Enter new batsman name = ");
                    Striker = in.nextLine();
                    }
                    System.out.println();
                }
                else {
                    System.out.print("Enter the score for " + Striker + " = ");
                    batterScore = in.nextInt();
                }


                totalScore = totalScore + batterScore;
                overScore = overScore+batterScore;

                if ((batterScore % 2) != 0) {
                    String swapBatter = Striker;
                    Striker = nonStriker;
                    nonStriker = swapBatter;
                }
               }
            }// end of over---

            System.out.print(bowler+" has taken "+overOutCount+" wickets");
            System.out.print(" And conceded "+overScore+" runs\n\n");

            overOutCount = 0;
            overScore = 0;
            //swap the batter after an over-----

            if(i<(overs-1)){
                in.nextLine();//for error handling in output
                System.out.print("Enter the new bowler name = ");
                bowler = in.nextLine();
                System.out.println();
            }

            String swapBatter = Striker;
            Striker = nonStriker;
            nonStriker = swapBatter;
            overCounter++;
        }
        System.out.println("Total Score of first inning = "+totalScore);
    }

}



//second Inning

class SecondInning extends MatchScoring{

    void Output(){
        System.out.println("\n-_-_-Second Inning-_-_-");
    }

    @Override
    public void bowlerAndBatterName() {
        in.nextLine(); //for solving error

        System.out.print("Enter the Striker side batter name = ");
        Striker = in.nextLine();

        System.out.print("Enter the Non-Striker side batter name = ");
        nonStriker = in.nextLine();

        System.out.print("Enter the Bowler name = ");
        bowler = in.nextLine();
    }

    @Override
    public void batsmanAndBowlerRuns() {
        overOutCount = 0;
        overScore = 0;
        totalScore2 = 0;
        totalWickets = 0;
        overCounter = 0;

        for (int i = 0; i < overs; i++) {

            System.out.println("\nOver # "+ overCounter+1);

            for (int j = 1; j<=6; j++) {

               if (totalWickets == 10 ){
                    System.out.println("All Out!!!");
                    System.out.println("First Inning ended!");
                    System.out.println("First Inning has scored "+ totalScore2);

                    return;
                }
                else if (totalScore2>=totalScore) {
                    System.out.println("Second Inning Batter won the match = ");
                    System.out.println("Second Inning ended!");
                    System.out.println("Second Inning has scored "+ totalScore2 + " and Won by "+(totalScore2-totalScore));

                    return;
                }
                else {
                    System.out.print("Press o for out! else press any to key to enter score =");
                    condCheck = in.next().charAt(0);


                    if (condCheck == 'o'){

                        batterScore = 0;
                        overOutCount +=1;
                        totalWickets = totalWickets + 1;

                        System.out.println("Out!!!\n");

                        in.nextLine(); // used for error handling in output---
                        if(totalWickets < 10){
                            System.out.print("Enter new batsman name = ");
                            Striker = in.nextLine();
                        }
                        System.out.println();
                    }

                    else {
                        System.out.print("Enter the score for " + Striker + " = ");
                        batterScore = in.nextInt();
                    }


                    totalScore2 = totalScore2 + batterScore;
                    overScore = overScore+batterScore;

                    if ((batterScore % 2) != 0) {
                        String swapBatter = Striker;
                        Striker = nonStriker;
                        nonStriker = swapBatter;
                    }
                }
            }// end of over---

            System.out.print(bowler+" has taken "+overOutCount+" wickets");
            System.out.print(" And conceded "+overScore+" runs\n\n");

            overOutCount = 0;
            overScore = 0;
            //swap the batter after an over-----

            if(i<(overs-1)){
                in.nextLine();//for error handling in output
                System.out.print("Enter the new bowler name = ");
                bowler = in.nextLine();
                System.out.println();
            }

            String swapBatter = Striker;
            Striker = nonStriker;
            nonStriker = swapBatter;

            overCounter++;
        }
        System.out.println("Total Score of Second Inning = "+ totalScore2);
    }
}


public class Main {
    public static void main(String[] args) {

                FirstInning f = new FirstInning();

                f.output();
                f.teamNames();
                f.totalOvers();
                f.toss();
                f.batOrBowl();
                f.bowlerAndBatterName();
                f.batsmanAndBowlerRuns();


                SecondInning s = new SecondInning();
                s.Output();
                s.bowlerAndBatterName();
                s.batsmanAndBowlerRuns();

    }
}