package com.khutso.scorekeeper;
//Created by Khutso Matlala,south Africa
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();
    int random = 0;
    int random_B = 0;
    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    int finalScore_teamA = 0;
    int finalScore_teamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    //method for adding points to team A
    public void add1_for_a(View view) {

        finalScore_teamA = scoreTeamA + finalScore_teamA + 1;
        displayA(finalScore_teamA);
        add_1_teamA();

    }

    //displaying points for team A
    public void displayA(int score) {
        TextView textView = (TextView) findViewById(R.id.txt_score_a_team);
        textView.setText(String.valueOf(score));
    }

    public void subtract_for_a(View view) {

        if (finalScore_teamA > 0) {

            finalScore_teamA -= 1;
            take_1_teamA();
            displayA(finalScore_teamA);

        } else {
            Toast.makeText(this, "can't subtract from a score of zero!!", Toast.LENGTH_SHORT).show();
        }
    }

    //Clearing the score for both teams
    public void clear(View view) {

        scoreTeamA = 0;
        TextView teamA = (TextView) findViewById(R.id.txt_score_a_team);
        teamA.setText(String.valueOf(scoreTeamA));


        scoreTeamB = 0;
        TextView teamB = (TextView) findViewById(R.id.txt_score_b_team);
        teamB.setText(String.valueOf(scoreTeamB));


        TextView infor = (TextView) findViewById(R.id.txt_match_details);
        infor.setText("MATCH DETAILS:\n\n \t\t cleared");

        TextView match_results = (TextView) findViewById(R.id.match_results);
        match_results.setText(" upcoming games \n\n  TEAM A vs TEAM D \n TEAM C vs TEAM U \n TEAM E vs TEAM T ");


        random = 0; //For team A
        random_B = 0; //B
        finalScore_teamA = 0;
        finalScore_teamB = 0;

    }

    //adding points to team B
    public void add1_for_b(View view) {
        finalScore_teamB = finalScore_teamB + scoreTeamB + 1;
        displayB(finalScore_teamB);
        add_1_teamB();
    }


    //displaying points for team B
    public void displayB(int score) {
        TextView textView = (TextView) findViewById(R.id.txt_score_b_team);
        textView.setText(String.valueOf(score));
    }

    //Subtracting points for Team B
    public void subtract_for_b(View view) {

        if (finalScore_teamB > 0) {
            finalScore_teamB -= 1;
            displayB(finalScore_teamB);
            take_1_teamB();
        } else

            Toast.makeText(this, "can't subtract from a score of zero!!", Toast.LENGTH_SHORT).show();
    }

    // +1 point updating the match details for Team A
    public void add_1_teamA() {

        TextClock textClock = (TextClock) findViewById(R.id.time);
        TextView infor = (TextView) findViewById(R.id.txt_match_details);

        infor.setText("MATCH DETAILS:\n" + "Team A\nscored a goal with one point at " + textClock.getFormat24Hour().toString());
    }


    // +1 point updating the match details for Team B
    public void add_1_teamB() {

        TextClock textClock = (TextClock) findViewById(R.id.time);
        TextView infor = (TextView) findViewById(R.id.txt_match_details);

        infor.setText("MATCH DETAILS:\nTeam B\nscored a goal with one point at " + textClock.getFormat24Hour().toString());
    }


    //checks the score difference between Team A and Team B
    public void final_score(View view) {
        String score = winner(scoreTeamA, scoreTeamB);
        Toast.makeText(this, "" + score, Toast.LENGTH_SHORT).show();

        TextView match_results = (TextView) findViewById(R.id.match_results);
        match_results.setText("final match score \n\n" + score);
    }


    public String winner(int scoreA, int scoreB) {

        String results = " ";
        TextView txt_score_a_team = (TextView) findViewById(R.id.txt_score_a_team);
        scoreA = Integer.parseInt(txt_score_a_team.getText().toString());

        TextView txt_score_b_team = (TextView) findViewById(R.id.txt_score_b_team);
        scoreB = Integer.parseInt(txt_score_b_team.getText().toString());

        if (scoreA > scoreB) {
            results = "Team A won by " + (scoreA - scoreB) + "\tpoint(s)";
        } else if (scoreA < scoreB) {
            results = "Team B won by " + (scoreB - scoreA + "\tpoint(s)");
        } else {
            results = "Played a draw match by " + scoreA + "-" + scoreB + "\tpoint(s)";
        }
        return results;
    }

    // minus a point, updating the match details for Team A
    public void take_1_teamA() {

        TextClock textClock = (TextClock) findViewById(R.id.time);
        TextView infor = (TextView) findViewById(R.id.txt_match_details);

        infor.setText("MATCH DETAILS:\nTeam A\nOne point taken away for foul play at " + textClock.getFormat24Hour().toString());
    }

    // minus a point, updating the match details for Team B
    public void take_1_teamB() {

        TextClock textClock = (TextClock) findViewById(R.id.time);
        TextView infor = (TextView) findViewById(R.id.txt_match_details);

        infor.setText("MATCH DETAILS:\nTeam B\nOne point taken away for foul play at " + textClock.getFormat24Hour().toString());
    }


    //Bonus button for Team A
    public void bonus_teamA(View view) {

        int old = 0;

        old = rand.nextInt(6 - 1) + 1;
        random += old;

        finalScore_teamA = random + scoreTeamA;

        displayA(finalScore_teamA);

        Toast.makeText(this, old + " bonus points added to Team A", Toast.LENGTH_SHORT).show();


    }

    //Bonus button for Team B
    public void bonus_teamB(View view) {

        int old = 0;
        old = rand.nextInt(6 - 1) + 1;
        random_B = random_B + old;

        finalScore_teamB = random_B + scoreTeamB;
        displayB(finalScore_teamB);

        Toast.makeText(this, old + " bonus points addedd to Team B", Toast.LENGTH_SHORT).show();

    }

    //Shows the message when the Rating bar is touched  //TODO not working for now
    public void rateService(View view) {

        Toast.makeText(this, " Thank you for rating the score keeper app ", Toast.LENGTH_SHORT).show();
    }

}
