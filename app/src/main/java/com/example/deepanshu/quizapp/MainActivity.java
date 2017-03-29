package com.example.deepanshu.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int scores = 0;

    // Declare all views
    private RadioGroup one;
    private LinearLayout two;
    private CheckBox twoB;
    private CheckBox twoD;
    private RadioGroup three;
    private RadioGroup four;
    private RadioGroup five;
    private EditText six;
    private RadioGroup seven;
    private RadioGroup eight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all views
        one = (RadioGroup) findViewById(R.id.q_one_rg);
        two = (LinearLayout) findViewById(R.id.checkbox_question);
        twoB = (CheckBox) findViewById(R.id.q_two_b);
        twoD = (CheckBox) findViewById(R.id.q_two_d);
        three = (RadioGroup) findViewById(R.id.q_three_rg);
        four = (RadioGroup) findViewById(R.id.q_four_rg);
        five = (RadioGroup) findViewById(R.id.q_five_rg);
        six = (EditText) findViewById(R.id.q_six_answer);
        seven = (RadioGroup) findViewById(R.id.q_seven_rg);
        eight = (RadioGroup) findViewById(R.id.q_eight_rg);
    }

    /**
     * Submit Answer
     * @param view
     */
    public void submitAnswer(View view) {
        int totalScores = 16;

        // check for all answer
        checkAnswer();

        // Show Score
        if (scores == totalScores) {
            showToastMessage(
                    getString(R.string.all_answer) + " Your Score: " + String.valueOf(scores)
            );

            // Reset the quiz
            resetQuiz();
        } else {
            showToastMessage(
                    getString(R.string.all_question) + " Your Score: " + String.valueOf(scores)
            );
        }
    }

    /**
     * Check all the answer and increase the score
     * For each answer 2point will get added in scores
     */
    private void checkAnswer() {
        // clear the scores
        scores = 0;

        // Check for answer one
        if (one.getCheckedRadioButtonId() == R.id.q_one_d) {
            increaseScore();
        }

        // Check for answer two
        if (twoB.isChecked()) {
            scores++;
        }

        if (twoD.isChecked()) {
            scores++;
        }

        // Check for answer three
        if (three.getCheckedRadioButtonId() == R.id.q_three_c) {
            increaseScore();
        }

        // Check for answer four
        if (four.getCheckedRadioButtonId() == R.id.q_four_a) {
            increaseScore();
        }

        // Check for answer five
        if (five.getCheckedRadioButtonId() == R.id.q_five_c) {
            increaseScore();
        }

        // check for answer six
        if (six.getText().toString().equalsIgnoreCase("4")) {
            increaseScore();
        }

        // Check for answer seven
        if (seven.getCheckedRadioButtonId() == R.id. q_seven_a) {
            increaseScore();
        }

        // Check for answer eight
        if (eight.getCheckedRadioButtonId() == R.id.q_eight_d) {
            increaseScore();
        }
    }

    private void increaseScore() {
        scores += 2;
    }

    /**
     * To Reset the quiz
     */
    private void resetQuiz() {
        // Clear all the answers
        one.clearCheck();
        uncheckAllChildern(two);
        three.clearCheck();
        four.clearCheck();
        five.clearCheck();
        six.setText("");
        six.clearFocus();
        seven.clearCheck();
        eight.clearCheck();
    }

    /**
     * Uncheck all children
     * @param viewGroup
     */
    private void uncheckAllChildern(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof CheckBox) {
                ((CheckBox) childAt).setChecked(false);
            }
        }
    }

    /**
     * To display toast message
     * @param message
     */
    private void showToastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
