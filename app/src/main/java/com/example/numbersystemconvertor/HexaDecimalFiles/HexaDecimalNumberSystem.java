package com.example.numbersystemconvertor.HexaDecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.numbersystemconvertor.R;

public class HexaDecimalNumberSystem extends AppCompatActivity {
    Button hexadecimalConvertor, hexadecimalConvertorPoint, hexadecimalAddition, hexadecimalFifteens, hexadecimalSixteens, hexadecimalSubtraction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexa_decimal_number_system);

        hexadecimalConvertor = findViewById(R.id.hexadecimalconvertor);
        hexadecimalConvertorPoint = findViewById(R.id.hexadecimalconvertorpoint);
        hexadecimalAddition = findViewById(R.id.hexadecimalAddition);
        hexadecimalFifteens = findViewById(R.id.hexadecimalfifteens);
        hexadecimalSixteens = findViewById(R.id.hexadecimalsixteens);
        hexadecimalSubtraction = findViewById(R.id.hexadecimalSubtraction);

        hexadecimalConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HexaDecimalConvertor.class);
                startActivity(intent);
            }
        });

        hexadecimalConvertorPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HexaDecimalPointConvertor.class);
                startActivity(intent);
            }
        });

        hexadecimalAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HexaDecimalAddition.class);
                startActivity(intent);
            }
        });

        hexadecimalFifteens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), FifteensComplement.class);
                startActivity(intent);
            }
        });

        hexadecimalSixteens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SixteensComplement.class);
                startActivity(intent);
            }
        });

        hexadecimalSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HexaDecimalSubtraction.class);
                startActivity(intent);
            }
        });
    }
}