package com.example.numbersystemconvertor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.numbersystemconvertor.BinaryFiles.BinaryNumberSystem;
import com.example.numbersystemconvertor.DecimalFiles.DecimalNumberSystem;
import com.example.numbersystemconvertor.HexaDecimalFiles.HexaDecimalNumberSystem;
import com.example.numbersystemconvertor.OctalFiles.OctalNumberSystem;

public class MainActivity extends AppCompatActivity {
    Button binary, octal, decimal, hexadecimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binary = findViewById(R.id.binary);
        octal = findViewById(R.id.octal);
        decimal = findViewById(R.id.decimal);
        hexadecimal = findViewById(R.id.hexadecimal);

        binary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BinaryNumberSystem.class);
                startActivity(intent);
            }
        });

        octal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OctalNumberSystem.class);
                startActivity(intent);
            }
        });

        decimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DecimalNumberSystem.class);
                startActivity(intent);
            }
        });

        hexadecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HexaDecimalNumberSystem.class);
                startActivity(intent);
            }
        });


    }
}