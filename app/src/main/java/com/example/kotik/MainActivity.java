package com.example.kotik;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kotik.StartActivity;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private TextView questionTextView;
    private Button option1Button, option2Button, option3Button, option4Button;

    // Здесь вы можете добавить свои вопросы и правильные ответы
    private String[] questions = {
            "Пойдем спать??",
            "Вам погладить спинку пепред сном?",
            // Добавьте еще вопросы...
    };

    private String[] options1 = {
            "дя",
            "дя",
            // Добавьте еще варианты...
    };

    private String[] options2 = {
            "неть",
            "дя",
            // Добавьте еще варианты...
    };

    private String[] options3 = {
            "ур",
            "неть",
            // Добавьте еще варианты...
    };

    private String[] options4 = {
            "мур",
            "неть",
            // Добавьте еще варианты...
    };

    private int currentQuestionIndex = 0;
    private int[] correctAnswers = {3, 2, /* Добавьте правильные ответы... */};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        /////
        //   Intent intent = new Intent(this, StartActivity.class);
      //  startActivity(intent); //Убрал что бы не  гонять по кругу стартовый экран
      //  finish();
        //////

        // Инициализация MediaPlayer
        mediaPlayer = MediaPlayer.create(this, R.raw.r3);
        questionTextView = findViewById(R.id.questionTextView);
        option1Button = findViewById(R.id.option1Button);
        option2Button = findViewById(R.id.option2Button);
        option3Button = findViewById(R.id.option3Button);
        option4Button = findViewById(R.id.option4Button);

        updateQuestion();

        option1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(1);
            }
        });

        option2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(2);
            }
        });

        option3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(3);
            }
        });

        option4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(4);
            }
        });
    }

    private void updateQuestion() {
        questionTextView.setText(questions[currentQuestionIndex]);
        option1Button.setText(options1[currentQuestionIndex]);
        option2Button.setText(options2[currentQuestionIndex]);
        option3Button.setText(options3[currentQuestionIndex]);
        option4Button.setText(options4[currentQuestionIndex]);
    }

    private void playAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.start();  // Начать воспроизведение
        }
    }
    private void checkAnswer(int selectedOption) {
        if (selectedOption == correctAnswers[currentQuestionIndex]) {
            playAudio();
            // Ваш код для обработки правильного ответа
        } else {
            playAudio();
            // Ваш код для обработки неправильного ответа
        }

        // Переход к следующему вопросу
        currentQuestionIndex++;
        if (currentQuestionIndex < questions.length) {
            updateQuestion();
        } else {
            // Игра завершена
            // Ваш код для завершения игры
        }
    }
}