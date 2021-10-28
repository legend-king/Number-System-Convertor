package com.example.numbersystemconvertor.BinaryFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.numbersystemconvertor.R;

public class BinaryNumberSystem extends AppCompatActivity {
    Button binaryConvertor, binaryAddition, binaryOnesComplement, binaryTwosComplement, binarySubtraction, binaryConvertorPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_number_system);

        binaryConvertor = findViewById(R.id.binaryconvertor);
        binaryAddition = findViewById(R.id.binaryAddition);
        binaryOnesComplement = findViewById(R.id.binaryones);
        binaryTwosComplement = findViewById(R.id.binarytwos);
        binarySubtraction = findViewById(R.id.binarySubtraction);
        binaryConvertorPoint = findViewById(R.id.binaryconvertorpoint);


        binaryConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BinaryConvertor.class);
                startActivity(intent);
            }
        });

        binaryAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BinaryAddition.class);
                startActivity(intent);
            }
        });

        binaryOnesComplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OnesComplement.class);
                startActivity(intent);
            }
        });

        binaryTwosComplement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TwosComplement.class);
                startActivity(intent);
            }
        });

        binarySubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BinarySubtraction.class);
                startActivity(intent);
            }
        });

        binaryConvertorPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BinaryPointConvertor.class);
                startActivity(intent);
            }
        });
    }
}