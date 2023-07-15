package com.example.calculator;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public int op=0,c=0;
    double num1,num2;
    int[] ch = new int[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        TextView txt = findViewById(R.id.txt2);
        TextView txt1 = findViewById(R.id.txt3);

        Button btn1 = findViewById(R.id.button);
        txt.setMovementMethod(new ScrollingMovementMethod());

        btn1.setOnClickListener(view -> {
            txt.setText(null);
            txt1.setText(null);
            op=0;
        });
        @SuppressLint("CutPasteId") Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(view -> {
            ch[op]=txt.length();
            op++;

            txt.append("^");

        });
        Button btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(view -> {
            ch[op]=txt.length();
            op++;
            txt.append("%");
        });
        Button btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(view ->
        {
            ch[op]=txt.length();
            op++;
            txt.append("/");

        });
        Button btn5 = findViewById(R.id.button6);
        btn5.setOnClickListener(view -> txt.append("7"));
        Button btn6 = findViewById(R.id.button7);
        btn6.setOnClickListener(view -> txt.append("8"));
        Button btn7 = findViewById(R.id.button8);
        btn7.setOnClickListener(view -> txt.append("9"));
        Button btn8 = findViewById(R.id.button9);
        btn8.setOnClickListener(view ->
        {
            ch[op]=txt.length();
            op++;

            txt.append("*");
        });
        Button btn9 = findViewById(R.id.button11);
        btn9.setOnClickListener(view -> txt.append("4"));
        Button btn10 = findViewById(R.id.button12);
        btn10.setOnClickListener(view -> txt.append("5"));
        Button btn11 = findViewById(R.id.button13);
        btn11.setOnClickListener(view -> txt.append("6"));
        Button btn12 = findViewById(R.id.button14);
        btn12.setOnClickListener(view ->
        {
            ch[op]=txt.length();
            op++;

            txt.append("-");
        });
        Button btn13 = findViewById(R.id.button15);
        btn13.setOnClickListener(view -> txt.append("1"));
        Button btn14 = findViewById(R.id.button16);
        btn14.setOnClickListener(view -> txt.append("2"));
        Button btn15 = findViewById(R.id.button17);
        btn15.setOnClickListener(view -> txt.append("3"));
        Button btn16 = findViewById(R.id.button18);
        btn16.setOnClickListener(view ->
        {
            ch[op]=txt.length();
            op++;

            txt.append("+");
        });
        Button btn17 = findViewById(R.id.button19);
        btn17.setOnClickListener(view ->  txt.append("0"));
        Button btn18 = findViewById(R.id.button20);
        btn18.setOnClickListener(view ->
        {
            c++;
            txt.append(".");
        });
        Button btn19 = findViewById(R.id.button21);
        btn19.setOnClickListener(view -> {
            if(!Character.isDigit(txt.getText().toString().charAt(txt.length()-1)))
            {
                op--;
            }
            String s = txt.getText().toString().substring(0, txt.length() - 1);
            txt.setText(s);
        });
        Button btn20 = findViewById(R.id.button22);
        btn20.setOnClickListener(view -> {
            if(Character.isDigit(txt.getText().toString().charAt(txt.length()-1))) {
                txt1.setText("");
                for (int i = 0; i < op; i++) {
                    if (i == 0) {
                        num1 = Double.parseDouble(txt.getText().toString().substring(0, ch[i]));
                    }
                    if (i == op - 1) {
                        num2 = Double.parseDouble(txt.getText().toString().substring(ch[i] + 1, txt.length()));
                    } else {
                        num2 = Double.parseDouble(txt.getText().toString().substring(ch[i] + 1, ch[i + 1]));
                    }
                    if (num2 == 0) {
                        c = -1;
                        break;
                    }

                    switch (txt.getText().toString().charAt(ch[i])) {
                        case '/':

                            num1 = num1 / num2;
                            break;
                        case '*':
                            num1 = num1 * num2;
                            break;
                        case '+':
                            num1 = num1 + num2;
                            break;
                        case '-':
                            num1 = num1 - num2;
                            break;

                        case '%':
                            num1 = (num1 * num2) / 100;
                            c++;
                            break;
                        case '^':
                            num1 = Math.pow(num1, num2);
                            break;

                    }
                }
                if (c == -1) {
                    String s = "Can't Divide By Zero";
                    txt1.setText(s);

                } else if (c > 0) {
                    txt1.append(String.valueOf(num1));
                } else {
                    txt1.append(String.valueOf((int) num1));

                }
            }
        });






}
}