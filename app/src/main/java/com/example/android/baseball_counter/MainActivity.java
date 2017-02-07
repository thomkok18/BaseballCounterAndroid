package com.example.android.baseball_counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0, scoreTeamB = 0;
    TextView team;
    CheckBox out1, out2, out3;
    CheckBox strike1, strike2, strikeout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team = (TextView) findViewById(R.id.teamAanSlag);
        out1 = (CheckBox) findViewById(R.id.out1);
        out2 = (CheckBox) findViewById(R.id.out2);
        out3 = (CheckBox) findViewById(R.id.out3);
        strike1 = (CheckBox) findViewById(R.id.strike1);
        strike2 = (CheckBox) findViewById(R.id.strike2);
        strikeout = (CheckBox) findViewById(R.id.strikeout);
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void strikes(View view) {
        strike1.isChecked();

        if(strike1.isChecked() || strike2.isChecked() || strikeout.isChecked()) {

        }
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeam(View view) {
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
        if (out1.isChecked() || out2.isChecked() || out3.isChecked() || strike1.isChecked() || strike2.isChecked() || strikeout.isChecked()) {
            out1.setChecked(false);
            out2.setChecked(false);
            out3.setChecked(false);
            strike1.setChecked(false);
            strike2.setChecked(false);
            strikeout.setChecked(false);
        }
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
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