package com.example.android.baseball_counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import static com.example.android.baseball_counter.R.id.teamAanSlag;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0, scoreTeamB = 0;
    TextView team;
    CheckBox out1, out2, out3;
    CheckBox strike1, strike2, strikeout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        team = (TextView) findViewById(teamAanSlag);
        out1 = (CheckBox) findViewById(R.id.out1);
        out2 = (CheckBox) findViewById(R.id.out2);
        out3 = (CheckBox) findViewById(R.id.out3);
        strike1 = (CheckBox) findViewById(R.id.strike1);
        strike2 = (CheckBox) findViewById(R.id.strike2);
        strikeout = (CheckBox) findViewById(R.id.strikeout);
        strike1.setEnabled(true);
        strike2.setEnabled(false);
        strikeout.setEnabled(false);
        out1.setEnabled(true);
        out2.setEnabled(false);
        out3.setEnabled(false);
    }

    /**
     * Increases the strikes. When 3rd strike happens its one out.
     */
    public void strikes(View view) {
        if (strike1.isChecked()) {
            strike2.setEnabled(true);
        } else {
            strike2.setEnabled(false);
        }
        if (!strike1.isChecked() && (strike2.isChecked() || strikeout.isChecked())) {
            strike1.setChecked(false);
            strike2.setChecked(false);
            strikeout.setChecked(false);
        }
        if (strike1.isChecked() && strike2.isChecked()) {
            strikeout.setEnabled(true);
        } else {
            strikeout.setEnabled(false);
        }
        if (strike1.isChecked() && strike2.isChecked() && strikeout.isChecked()) {
            strike1.setChecked(false);
            strike2.setChecked(false);
            strikeout.setChecked(false);
            strike2.setEnabled(false);
            strikeout.setEnabled(false);

            if (!out1.isChecked() && !out2.isChecked() && !out3.isChecked()) {
                out1.setChecked(true);
                out2.setEnabled(true);
            } else if (out1.isChecked() && !out2.isChecked() && !out3.isChecked()) {
                out2.setChecked(true);
                out3.setEnabled(true);
            } else if (out1.isChecked() && out2.isChecked() && !out3.isChecked()) {
                out3.setChecked(true);
            }
            if (out1.isChecked() && out2.isChecked() && out3.isChecked()) {
                out1.setChecked(false);
                out2.setChecked(false);
                out3.setChecked(false);
                out2.setEnabled(false);
                out3.setEnabled(false);
                if (team.getText().toString().equals("Team A")) {
                    displayTeam("Team B");
                } else {
                    displayTeam("Team A");
                }
            }
        }
    }

    /**
     * Increases the outs. When 3 out happens, the teams will be switched.
     */
    public void outs(View view) {
        if (out1.isChecked()) {
            out2.setEnabled(true);
        } else {
            out2.setEnabled(false);
        }
        if (!out1.isChecked() && (out2.isChecked() || out3.isChecked())) {
            out1.setChecked(false);
            out2.setChecked(false);
            out3.setChecked(false);
        }
        if (out1.isChecked() && out2.isChecked()) {
            out3.setEnabled(true);
        } else {
            out3.setEnabled(false);
        }
        if (out1.isChecked() && out2.isChecked() && out3.isChecked()) {
            strike1.setChecked(false);
            strike2.setChecked(false);
            strikeout.setChecked(false);
            strike2.setEnabled(false);
            strikeout.setEnabled(false);
            out1.setChecked(false);
            out2.setChecked(false);
            out3.setChecked(false);
            out2.setEnabled(false);
            out3.setEnabled(false);
            if (team.getText().toString().equals("Team A")) {
                displayTeam("Team B");
            } else {
                displayTeam("Team A");
            }
        }
    }

    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeam(View view) {
        strike1.setChecked(false);
        strike2.setChecked(false);
        strikeout.setChecked(false);
        strike2.setEnabled(false);
        strikeout.setEnabled(false);
        if (team.getText().toString().equals("Team A")) {
            scoreTeamA++;
            displayForTeamA(scoreTeamA);
        } else if (team.getText().toString().equals("Team B")) {
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
        out1.setChecked(false);
        out2.setChecked(false);
        out3.setChecked(false);
        out2.setEnabled(false);
        out3.setEnabled(false);
        strike1.setChecked(false);
        strike2.setChecked(false);
        strikeout.setChecked(false);
        strike2.setEnabled(false);
        strikeout.setEnabled(false);
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
        displayTeam("Team A");
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

    /**
     * Displays the Team.
     */
    public void displayTeam(String score) {
        TextView scoreView = (TextView) findViewById(teamAanSlag);
        scoreView.setText(String.valueOf(score));
    }
}