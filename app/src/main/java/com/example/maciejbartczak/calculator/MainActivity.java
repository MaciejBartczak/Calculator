package com.example.maciejbartczak.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewTop;
    TextView textViewMiddle;
    TextView textViewBottom;
    boolean statement = true;   // Determines the add-numbers statement

    protected void putInTextView(String text){
        String temporary;
        if(text == "*" || text == "+" || text == "-" || text == "/"){
            textViewMiddle.setText(text);
            statement = false;
            return;
        }

        if(statement) {
            if(textViewTop.getText() == "0"){
                if(text == ".") {
                    textViewTop.setText("0" + text);
                    return;
                }
                textViewTop.setText("");
            }
            if(textViewTop.length() <= 13) {
                temporary = textViewTop.getText() + text;
                textViewTop.setText(temporary);
            }
        }
        else{
            if(textViewBottom.getText() == "") {
                if(text == "."){
                    textViewBottom.setText("0" + text);
                    return;
                }
                textViewBottom.setText(text);
            }
            else if(textViewBottom.length() <= 13){
                temporary = textViewBottom.getText() + text;
                textViewBottom.setText(temporary);
            }
        }
    }
    
    protected void Count(View view){
        if(textViewBottom.getText() == "")
            return;
        String character = (String) textViewMiddle.getText();
        float firstNumber = Float.parseFloat((String) textViewTop.getText());
        float secondNumber = Float.parseFloat((String) textViewBottom.getText());
        onClickClear(view);

        switch (character) {
            case "+":
                textViewTop.setText(Float.toString(firstNumber + secondNumber));

                break;
            case "-":
                textViewTop.setText(Float.toString(firstNumber - secondNumber));

                break;
            case "*":
                textViewTop.setText(Float.toString(firstNumber * secondNumber));

                break;
            case "/":
                textViewTop.setText(Float.toString(firstNumber / secondNumber));

                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTop = (TextView) findViewById(R.id.textViewTop);
        textViewTop.setText("0");
        textViewMiddle = (TextView) findViewById(R.id.textViewMiddle);
        textViewMiddle.setText("");
        textViewBottom = (TextView) findViewById(R.id.textViewBottom);
        textViewBottom.setText("");
    }

    protected void onClickOne(View view){
        putInTextView("1");
    }

    protected void onClickTwo(View view){
        putInTextView("2");
    }

    protected void onClickThree(View view){
        putInTextView("3");
    }

    protected void onClickFour(View view){
        putInTextView("4");
    }

    protected void onClickFive(View view){
        putInTextView("5");
    }

    protected void onClickSix(View view){
        putInTextView("6");
    }

    protected void onClickSeven(View view){
        putInTextView("7");
    }

    protected void onClickEight(View view){
        putInTextView("8");
    }

    protected void onClickNine(View view){
        putInTextView("9");
    }

    protected void onClickZero(View view){
        putInTextView("0");
    }

    protected void onClickClear(View view) {
        textViewTop.setText("0");
        textViewMiddle.setText("");
        textViewBottom.setText("");
        statement = true;
    }

    protected void onClickPlus(View view) {
        putInTextView("+");
    }

    protected void onClickMinus(View view) {
        putInTextView("-");
    }

    protected void onClickMultiply(View view) {
        putInTextView("*");
    }

    protected void onClickDivide(View view) {
        putInTextView("/");
    }

    protected void onClickEquals(View view) {
        Count(view);
    }

    protected void onClickDot(View view){
        putInTextView(".");
    }
}

