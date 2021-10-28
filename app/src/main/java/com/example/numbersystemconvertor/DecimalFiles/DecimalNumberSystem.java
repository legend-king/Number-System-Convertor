package com.example.numbersystemconvertor.DecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.numbersystemconvertor.R;

public class DecimalNumberSystem extends AppCompatActivity {
    Button decimalConvertor, decimalConvertorPoint, decimalAddition, decimalNines, decimalTens, decimalSubtraction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_number_system);

        decimalConvertor = findViewById(R.id.decimalconvertor);
        decimalConvertorPoint = findViewById(R.id.decimalconvertorpoint);
        decimalAddition = findViewById(R.id.decimalAddition);
        decimalNines = findViewById(R.id.decimalnines);
        decimalTens = findViewById(R.id.decimaltens);
        decimalSubtraction = findViewById(R.id.decimalSubtraction);

        decimalConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DecimalConvertor.class);
                startActivity(intent);
            }
        });

        decimalConvertorPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DecimalPointConvertor.class);
                startActivity(intent);
            }
        });

        decimalAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DecimalAddition.class);
                startActivity(intent);
            }
        });

        decimalNines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NinesComplement.class);
                startActivity(intent);
            }
        });

        decimalTens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TensComplement.class);
                startActivity(intent);
            }
        });

        decimalSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DecimalSubtraction.class);
                startActivity(intent);
            }
        });
    }
}