package com.example.fourbasiccalculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editNum1;
    private EditText editNum2;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);

        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);

        textResult = findViewById(R.id.textResult);

        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSubtract.setOnClickListener(v -> calculate("-"));
        btnMultiply.setOnClickListener(v -> calculate("*"));
        btnDivide.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operator) {

        String firstValue = editNum1.getText().toString();
        String secondValue = editNum2.getText().toString();

        if (firstValue.isEmpty() || secondValue.isEmpty()) {
            textResult.setText("Please enter both numbers");
            return;
        }

        double num1 = Double.parseDouble(firstValue);
        double num2 = Double.parseDouble(secondValue);

        double result;

        switch (operator) {

            case "+":
                result = num1 + num2;
                break;

            case "-":
                result = num1 - num2;
                break;

            case "*":
                result = num1 * num2;
                break;

            case "/":
                if (num2 == 0) {
                    textResult.setText("Cannot divide by zero");
                    return;
                }

                result = num1 / num2;
                break;

            default:
                return;
        }

        textResult.setText("Result: " + result);
    }
}