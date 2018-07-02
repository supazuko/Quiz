package com.example.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.EditText;
import java.lang.String;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit (View view) {
        RadioButton QuestionTwoAnswer = (RadioButton) findViewById(R.id.question_2a);
        RadioButton QuestionFiveAnswer = (RadioButton) findViewById(R.id.question_5d);

        markGermanQuestions (R.id.question_1, "Extended Markup Language");
        markQuestionRadioButton (QuestionTwoAnswer);
        markQuestionThree();
        markGermanQuestions (R.id.question_4,"andelaLearningCommunity");
        markQuestionRadioButton (QuestionFiveAnswer);
        markQuestionSix();

        toastResult(score);
        score = 0;
    }

    private int markQuestionThree () {

        CheckBox checkBoxQuestion3a = findViewById(R.id.question_3a);
        CheckBox checkBoxQuestion3b = findViewById(R.id.question_3b);
        CheckBox checkBoxQuestion3c = findViewById(R.id.question_3c);
        CheckBox checkBoxQuestion3d = findViewById(R.id.question_3d);

        boolean ischeckBoxQuestion3aChecked = checkBoxQuestion3a.isChecked();
        boolean ischeckBoxQuestion3bChecked = checkBoxQuestion3b.isChecked();
        boolean ischeckBoxQuestion3cChecked = checkBoxQuestion3c.isChecked();
        boolean ischeckBoxQuestion3dChecked = checkBoxQuestion3d.isChecked();
        if (!ischeckBoxQuestion3aChecked && ischeckBoxQuestion3bChecked && ischeckBoxQuestion3cChecked && !ischeckBoxQuestion3dChecked) {
            score = score + 1;
        }
        return score;
    }


    private int markQuestionSix () {

        CheckBox checkBoxQuestion6a = findViewById(R.id.question_6a);
        CheckBox checkBoxQuestion6b = findViewById(R.id.question_6b);

        boolean ischeckBoxQuestion6aChecked = checkBoxQuestion6a.isChecked();
        boolean ischeckBoxQuestion6bChecked = checkBoxQuestion6b.isChecked();

        if (!ischeckBoxQuestion6aChecked && ischeckBoxQuestion6bChecked) {
            score = score + 1;
        }
        return score;
    }

    /**
     *
     * @param correctAnswer receives the correct answers to questions. this method is valid for Radio Button questions.
     *
     */

    private int markQuestionRadioButton(View correctAnswer) {
        boolean isTheUSerAnswerCorrect = ((RadioButton) correctAnswer ).isChecked();
        if (isTheUSerAnswerCorrect) {
            score = score + 1;
        } else {
            correctAnswer.setBackgroundColor(100);
        }
        return score;
    }


    private int markGermanQuestions (int userResponse, String correctAnswers) {
        EditText userInputField = (EditText) findViewById(userResponse);
        String userInput = userInputField.getText().toString();
        if (userInput.matches(correctAnswers))
        {score = score + 1;}
        return score;
    }


    public void reset(View view) {

        EditText editText = findViewById(R.id.question_1);
        editText.setText("");

        EditText editText1= findViewById(R.id.question_4);
        editText1.setText("");

        RadioGroup radioGroup = findViewById(R.id.radio_group_question_2);
        radioGroup.clearCheck();

        CheckBox checkBox = findViewById(R.id.question_3a);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_3b);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_3c);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_3d);
        checkBox.setChecked(false);

        radioGroup = findViewById(R.id.radio_group_question_5);
        radioGroup.clearCheck();

        checkBox = findViewById(R.id.question_6a);
        checkBox.setChecked(false);

        checkBox = findViewById(R.id.question_6b);
        checkBox.setChecked(false);


    }

    /**
     * @param result receives the return score from the entire Score calculated and sends a toast message
     **/
    public void toastResult(int result) {
        String message = result + " out of 6. ";

        if (result == 0) {
            message += "SMH";
        } else if (result == 1) {
            message += "Really?.";
        } else if (result == 2) {
            message += "Okay.";
        } else if (result == 3) {
            message += "Good.";
        } else if (result == 4) {
            message += "Well done!.";
        } else if (result == 5) {
            message += "Great!";
        } else if (result == 6) {
            message += "Awesome!.. Make Sure You Vote Come 2019!";
        }

        Toast reportResult = Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT);
        reportResult.show();
    }

}