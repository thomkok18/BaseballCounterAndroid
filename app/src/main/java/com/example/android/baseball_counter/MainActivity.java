package com.example.android.baseball_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0, scoreTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for Team A by 4 points.
     */
    public void addFourForTeam(View view) {
        TextView team = (TextView) findViewById(R.id.teamAanSlag);
        if(team.getText().toString().equals("Team A")) {
            scoreTeamA += 4;
            displayForTeamA(scoreTeamA);
        } else if(team.getText().toString().equals("Team B")) {
            scoreTeamB += 4;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeam(View view) {
        TextView team = (TextView) findViewById(R.id.teamAanSlag);
        if(team.getText().toString().equals("Team A")) {
            scoreTeamA += 3;
            displayForTeamA(scoreTeamA);
        } else if(team.getText().toString().equals("Team B")) {
            scoreTeamB += 3;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeam(View view) {
        TextView team = (TextView) findViewById(R.id.teamAanSlag);
        if(team.getText().toString().equals("Team A")) {
            scoreTeamA += 2;
            displayForTeamA(scoreTeamA);
        } else if(team.getText().toString().equals("Team B")) {
            scoreTeamB += 2;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeam(View view) {
        TextView team = (TextView) findViewById(R.id.teamAanSlag);
        if(team.getText().toString().equals("Team A")) {
            scoreTeamA++;
            displayForTeamA(scoreTeamA);
        } else if(team.getText().toString().equals("Team B")) {
            scoreTeamB++;
            displayForTeamB(scoreTeamB);
        }
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for both teams.
     */
    public void displayReset(int score) {
        TextView scoreView = (TextView) findViewById(R.id.reset);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));

    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));

    }
}