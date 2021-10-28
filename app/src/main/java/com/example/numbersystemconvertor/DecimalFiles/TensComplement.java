package com.example.numbersystemconvertor.DecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class TensComplement extends AppCompatActivity {
    EditText editTensComp;
    Button tensCompBtn;
    TextView tensCompResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tens_complement);

        editTensComp = findViewById(R.id.editTensComp);
        tensCompBtn = findViewById(R.id.tensCompBtn);
        tensCompResult = findViewById(R.id.tensCompResult);

        tensCompBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = editTensComp.getText().toString();
                String ans="";
                if (d1.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter a Decimal Value First", Toast.LENGTH_SHORT).show();
                }
                else{
                    d1 = ninesComp(d1);
                    ans = addStrings(d1, "1");
                }
                tensCompResult.setText(getText(R.string.tenscomplementcolon) + ans);
            }
        });
    }

    public static String ninesComp(String d1){
        int l = d1.length();
        String ans="";
        for (int i=0;i<l;i++){
            char a = d1.charAt(i);
            ans += String.valueOf(9-Integer.parseInt(String.valueOf(a)));
        }
        return ans;
    }

    public static String addStrings(String num1, String num2) {
        boolean x = false;
        int l1 = num1.length();
        int l2 = num2.length();
        int m;
        StringBuilder ans = new StringBuilder();
        String z;
        if (l1>l2) {
            String y="";
            for (int i=0;i<l1-l2;i++) {
                y+="0";
            }
            num2 = y+num2;
            m=l1;
        }
        else {
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