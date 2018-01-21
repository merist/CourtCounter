package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
     * This method displays the score for team A
     */
    public void displayForTeamA(int score)
    {
        TextView scoreView = (TextView)findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /*
    * This method displays the score for team B
    */
    public void displayForTeamB(int score)
    {
        TextView scoreView = (TextView)findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addThreeForTeamA(View view)
    {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View view)
    {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    public void addOneFormTeamA(View view)
    {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamB(View view)
    {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View view)
    {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    public void addOneFormTeamB(View view)
    {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }
    /*
     * Reset score for team A and B to 0.
     */
    public void resetScore(View view)
    {
        scoreTeamB = 0;
        scoreTeamA = 0;
        displayForTeamB(scoreTeamB);
        displayForTeamA(scoreTeamA);
    }
}
