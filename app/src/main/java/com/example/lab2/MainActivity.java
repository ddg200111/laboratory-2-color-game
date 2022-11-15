package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView gameRules, colorName, colorText, timer, result;
    Button yesButton, noButton;
    int correct, name, text;

    List<String> listNames = Arrays.asList("Красный", "Зеленый", "Синий", "Черный", "Пурпурный", "Голубой");
    List<Integer> listColors = Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.BLACK, Color.MAGENTA, Color.CYAN);

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameRules = (TextView) findViewById(R.id.textView3);
        colorName = (TextView) findViewById(R.id.textView);
        colorText = (TextView) findViewById(R.id.textView2);
        timer = (TextView) findViewById(R.id.textView4);
        result = (TextView) findViewById(R.id.textView5);

        yesButton = (Button) findViewById(R.id.button);
        noButton = (Button) findViewById(R.id.button2);

        correct = 0;

        colorName.setText(listNames.get((int) (Math.random() * listNames.size())));
        colorName.setTextColor(listColors.get((int) (Math.random() * listColors.size())));
        colorText.setText(listNames.get((int) (Math.random() * listNames.size())));
        colorText.setTextColor(listColors.get((int) (Math.random() * listColors.size())));

        name = listNames.indexOf(colorName);
        text = listColors.indexOf(colorText.getCurrentTextColor());

        CountDownTimer my_timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {timer.setText(Long.toString(l / 1000));}

            @Override
            public void onFinish() {
                timer.setText("Игра завершена");
                String score = Integer.toString(correct);
                result.append(score);
                yesButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setClickable(false);
                    }
                });
                noButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        v.setClickable(false);
                    }
                });
            }
        };

        my_timer.start();

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name == text){
                    correct++;
                }

                colorName.setText(listNames.get((int) (Math.random() * listNames.size())));
                colorName.setTextColor(listColors.get((int) (Math.random() * listColors.size())));
                colorText.setText(listNames.get((int) (Math.random() * listNames.size())));
                colorText.setTextColor(listColors.get((int) (Math.random() * listColors.size())));

            }
        });
        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (name != text){
                    correct++;
                }

                colorName.setText(listNames.get((int) (Math.random() * listNames.size())));
                colorName.setTextColor(listColors.get((int) (Math.random() * listColors.size())));
                colorText.setText(listNames.get((int) (Math.random() * listNames.size())));
                colorText.setTextColor(listColors.get((int) (Math.random() * listColors.size())));
            }
        });
    }


}