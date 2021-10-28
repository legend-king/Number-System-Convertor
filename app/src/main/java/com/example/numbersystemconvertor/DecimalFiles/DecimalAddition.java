package com.example.numbersystemconvertor.DecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.BinaryFiles.BinaryAddition;
import com.example.numbersystemconvertor.R;

public class DecimalAddition extends AppCompatActivity {
    EditText decimalAdd1, decimalAdd2;
    Button decimalAddBtn;
    TextView decimalAddResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_addition);

        decimalAdd1 = findViewById(R.id.decimalAdd1);
        decimalAdd2 = findViewById(R.id.decimalAdd2);
        decimalAddBtn = findViewById(R.id.decimalAddBtn);
        decimalAddResult = findViewById(R.id.decimalAddResult);

        decimalAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = decimalAdd1.getText().toString();
                String d2 = decimalAdd2.getText().toString();
                String ans="";
                if (d1.equals("") || d2.equals("")) {
                    Toast.makeText(DecimalAddition.this, "Please Enter a decimal value first", Toast.LENGTH_LONG).show();
                }else{
                    ans = addStrings(d1, d2);
                }
                decimalAddResult.setText(getString(R.string.ans)+ans);
            }
        });
    }

    public static String addStrings(String num1, String num2) {
        boolean x = false;
        int l1 = num1.length();
        int l2 = num2.length();
        int m=l1;
        StringBuilder ans = new StringBuilder();
        String z;
        if (l1>l2) {
            String y="";
            for (int i=0;i<l1-l2;i++) {
                y+="0";
            }
            num2 = y+num2;
        }
        else if (l2>l1){
            String y="";
            for (int i=0;i<l2-l1;i++) {
                y+="0";
            }
            num1 = y+num1;
            m=l2;
        }
        for (int i=m-1;i>=0;i--) {
            if (x) {
                z = String.valueOf(num1.charAt(i)-48+ num2.charAt(i)-48+1);
            }
            else {
                z = String.valueOf(num1.charAt(i)-48+ num2.charAt(i)-48);
            }
            if (z.length()==2) {
                x=true;
                ans.append(z.charAt(1));
            }
            else {
                ans.append(z);
                x = false;
            }
        }
        if (x) {
            ans.append('1');
        }
        return String.valueOf(ans.reverse());
    }
}