package com.example.numbersystemconvertor.OctalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.numbersystemconvertor.R;

public class OctalNumberSystem extends AppCompatActivity {
    Button octalConvertor, octalConvertorPoint, octalAddition, octalSevens, octalEights, octalSubtraction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal_number_system);

        octalConvertor = findViewById(R.id.octalconvertor);
        octalConvertorPoint = findViewById(R.id.octalconvertorpoint);
        octalAddition = findViewById(R.id.octalAddition);
        octalSevens = findViewById(R.id.octalsevens);
        octalEights = findViewById(R.id.octaleights);
        octalSubtraction = findViewById(R.id.octalSubtraction);

        octalConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OctalConvertor.class);
                startActivity(intent);
            }
        });

        octalConvertorPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OctalPointConvertor.class);
                startActivity(intent);
            }
        });

        octalAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OctalAddition.class);
                startActivity(intent);
            }
        });

        octalSevens.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SevensComplement.class);
                startActivity(intent);
            }
        });

        octalEights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EightsComplement.class);
                startActivity(intent);
            }
        });

        octalSubtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OctalSubtraction.class);
                startActivity(intent);
            }
        });
    }
}