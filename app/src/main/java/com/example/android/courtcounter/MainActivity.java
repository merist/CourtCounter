package com.example.android.courtcounter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreTeamNo = 0;
    int scoreTeamDe = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
     * This method displays the score for Norway
     */
    public void displayForTeamNo(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /*
    * This method displays the score for Germany
    */
    public void displayForTeamDe(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void addOneHundredTwentyForNo(View view) {
        scoreTeamNo += 120;
        displayForTeamNo(scoreTeamNo);
    }

    public void addSixtyForNo(View view) {
        scoreTeamNo += 60;
        displayForTeamNo(scoreTeamNo);
    }

    public void addOneForNo(View view) {
        scoreTeamNo += 1;
        displayForTeamNo(scoreTeamNo);
    }

    public void removeOneForNo(View view) {
        scoreTeamNo -= 1;
        displayForTeamNo(scoreTeamNo);
    }

    public void addOneHundredTwentyForDe(View view) {
        scoreTeamDe += 120;
        displayForTeamDe(scoreTeamDe);
    }

    public void addSixtyForDe(View view) {
        scoreTeamDe += 60;
        displayForTeamDe(scoreTeamDe);
    }

    public void addOneForDe(View view) {
        scoreTeamDe += 1;
        displayForTeamDe(scoreTeamDe);
    }

    public void removeOneForDe(View view) {
        scoreTeamDe -= 1;
        displayForTeamDe(scoreTeamDe);
    }

    /*
     * Reset score for team A and B to 0.
     */
    public void resetScore(View view) {
        scoreTeamDe = 0;
        scoreTeamNo = 0;
        displayForTeamNo(scoreTeamDe);
        displayForTeamDe(scoreTeamNo);
    }

    /**
     * Display final result in a dialog.
     *
     * @param view
     */
    public void displayResult(View view) {
        String winnerTeam = "";

        if (scoreTeamDe > scoreTeamNo) {
            winnerTeam = getText(R.string.germany).toString();
        } else if (scoreTeamDe < scoreTeamNo) {
            winnerTeam = getText(R.string.norway).toString();
        }
        // Check if the game has started (if not display a message)
        if (scoreTeamDe == 0 && scoreTeamNo == 0) {
            Toast.makeText(this, getText(R.string.start_competition), Toast.LENGTH_SHORT).show();
        } else {
            // The competition has finished display the result
            displayDialog(winnerTeam);
        }
    }

    /**
     * Populate dialog with final result.
     *
     * @param winnerTeam
     */
    public void displayDialog(String winnerTeam) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Light_Dialog_Alert);
        alertDialogBuilder.setTitle(getText(R.string.result));
        alertDialogBuilder.setMessage(getText(R.string.winner) + " " + winnerTeam);
        // Add cancel button to return in the main activity
        alertDialogBuilder.setNegativeButton(getText(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        // Add Ok button to reset the score and return in the main page
        alertDialogBuilder.setPositiveButton(getText(R.string.ok), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent mainActivityIntent = new Intent(getApplicationContext(), MainActivity.class);
                mainActivityIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                getApplicationContext().startActivity(mainActivityIntent);
                finish();
            }
        });
        // Display the dialog
        alertDialogBuilder.show();
    }
}
