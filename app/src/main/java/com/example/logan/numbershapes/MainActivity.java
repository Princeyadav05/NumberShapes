package com.example.logan.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Number {
        int number;

        public boolean isSquare() {

            double squareRoot = Math.sqrt(number);

            if(squareRoot == Math.floor(squareRoot)) return true;
            else return false;

        }

        public boolean isTriangular() {
            int x = 1;

            int triangular = 1;

            while (triangular < number ) {

                x++;
                triangular += x;

            }

            if (triangular == number) return true;
            else return false;
        }
    }

    public void testNumber(View view){

        EditText editText = (EditText) findViewById(R.id.editText);

        String message;

        if(editText.getText().toString().isEmpty()) {

            message = "Please enter a Number";

        } else {

            Number myNumber = new Number();
            myNumber.number = Integer.parseInt(editText.getText().toString());

            message = editText.getText().toString();

            if(myNumber.isSquare() && myNumber.isTriangular()) {

                message += " is both square and traingular.";

            } else if (myNumber.isSquare()) {

                message += " is square but not traingular.";

            } else if (myNumber.isTriangular()) {

                message += " is traingular but not sqaure.";

            } else {

                message += " is neither traingular or square";

            }
        }


        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
