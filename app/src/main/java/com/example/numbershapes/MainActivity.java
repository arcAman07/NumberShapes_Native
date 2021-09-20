package com.example.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    class Number {
        int number;
        int squareNumber = 0;
        int triangularNumber = 0;
        Number(int number) {
            this.number = number;
        }
        public int isSquare() {
            double number1 = Math.pow(number,0.5);
            if ((int)number1 == number1) {
                squareNumber = 1;
            }
            return squareNumber;

        }
        public int isTriangular() {
            int i=1;
            int sum = 0;
            for (i=1;sum<number;i++) {
                sum = sum+i;
                if (sum == number) {
                    triangularNumber = 1;
                    break;
                }
            }
            return triangularNumber;
        }

    }
    public void clickFunction(View view) {
        String message;
        EditText editText = (EditText) findViewById(R.id.editNumber);
        String no = editText.getText().toString();
        int finalNumber = Integer.parseInt(no);
        Number number = new Number(finalNumber);
        int resultSquare = number.isSquare();
        int resultTriangular = number.isTriangular();
        if (resultSquare==1 & resultTriangular==1) {
            message = "Both Square and Triangular";
        }
        else if (resultSquare==1 && resultTriangular==0) {
            message = "Square but not Triangular";
        }
        else if (resultSquare==0 && resultTriangular==1) {
            message = "Triangular but not Square";
        }
        else {
            message = "Neither Square nor Triangular";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}