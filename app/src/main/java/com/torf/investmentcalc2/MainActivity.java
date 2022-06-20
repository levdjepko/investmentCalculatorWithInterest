package com.torf.investmentcalc2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // initialize our variable portions of the app
    private EditText amountInput;
    private EditText amountYears;
    private EditText amountPercentage;
    private TextView resultingAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Investment Calculator");
        amountInput = (EditText) findViewById(R.id.amountInput);
        amountYears = (EditText) findViewById(R.id.timeInput);
        amountPercentage = (EditText) findViewById(R.id.percentageInput);
        resultingAmount = (TextView) findViewById(R.id.resultAmount);
    }

    public void handleClick(View view) {
        Integer amount =  Integer.parseInt(amountInput.getText().toString());
        Integer years =   Integer.parseInt(amountYears.getText().toString());
        Integer percent = Integer.parseInt(amountPercentage.getText().toString());

        Integer result = calculateInvestment(amount, years, percent);
        resultingAmount.setText(result.toString());
    }

    public Integer calculateInvestment(int amount, int years, int percent) {
        double result = 0;
        for (int i = 0; i < years * 12; i++) {
            //monthly calculation
            result = (float)result + result * ((float)percent / 12 / 100);
            result += amount;
        }
        return (int)result;
    }

}