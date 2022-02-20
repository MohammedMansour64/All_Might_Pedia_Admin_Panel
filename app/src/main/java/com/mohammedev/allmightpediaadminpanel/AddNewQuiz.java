package com.mohammedev.allmightpediaadminpanel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.mohammedev.allmightpediaadminpanel.databinding.ActivityAddNewQuizBinding;

public class AddNewQuiz extends AppCompatActivity {
        private ActivityAddNewQuizBinding binding;
    private FirebaseDatabase dataBase = FirebaseDatabase.getInstance();
    private DatabaseReference dataBaseReference = dataBase.getReference("quiz");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_quiz);
        binding = ActivityAddNewQuizBinding.inflate(getLayoutInflater());
        findViewById(R.id.submit_question_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText questionEdit = findViewById(R.id.text_layout_question);
                EditText answerOneEdit = findViewById(R.id.text_layout_one);
                EditText answerTwoEdit = findViewById(R.id.text_layout_two);
                EditText answerThreeEdit = findViewById(R.id.text_layout_three);
                EditText answerFourEdit = findViewById(R.id.text_layout_four);
                RadioGroup radioGroup = findViewById(R.id.radioGroup);

                String questionTitle = questionEdit.getText().toString();
                String answerOne = answerOneEdit.getText().toString();
                String answerTwo = answerTwoEdit.getText().toString();
                String answerThree = answerThreeEdit.getText().toString();
                String answerFour = answerFourEdit.getText().toString();
                String correctAnswer;

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.correct_answer_one_radio:
                        System.out.println("one");
                        correctAnswer = answerOne;
                        Question question = new Question(questionTitle,answerOne,answerTwo,answerThree,answerFour,correctAnswer);
                        dataBaseReference.push().setValue(question);
                        break;
                    case R.id.correct_answer_two_radio:
                        System.out.println("two");
                        correctAnswer = answerTwo;
                        Question question1 = new Question(questionTitle,answerOne,answerTwo,answerThree,answerFour,correctAnswer);
                        dataBaseReference.push().setValue(question1);
                        break;
                    case R.id.correct_answer_three_radio:
                        System.out.println("three");
                        correctAnswer = answerThree;
                        Question question2 = new Question(questionTitle,answerOne,answerTwo,answerThree,answerFour,correctAnswer);
                        dataBaseReference.push().setValue(question2);
                        break;
                    case R.id.correct_answer_four_radio:
                        System.out.println("four");
                        correctAnswer = answerFour;
                        Question question3 = new Question(questionTitle,answerOne,answerTwo,answerThree,answerFour,correctAnswer);
                        dataBaseReference.push().setValue(question3);
                        break;
                }
            }
        });


    }
}