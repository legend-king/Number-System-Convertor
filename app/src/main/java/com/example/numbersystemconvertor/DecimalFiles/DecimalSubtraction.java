package com.example.numbersystemconvertor.DecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class DecimalSubtraction extends AppCompatActivity {
    EditText decimalSub1, decimalSub2;
    Button decimalSubBtn;
    TextView decimalSubResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_subtraction);

        decimalSub1 = findViewById(R.id.decimalSub1);
        decimalSub2 = findViewById(R.id.decimalSub2);
        decimalSubBtn = findViewById(R.id.decimalSubBtn);
        decimalSubResult = findViewById(R.id.decimalSubResult);

        decimalSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = decimalSub1.getText().toString();
                String d2 = decimalSub2.getText().toString();
                String ans="";
                if (d1.equals("") || d2.equals("")) {
                    Toast.makeText(DecimalSubtraction.this, "Please Enter a decimal value first", Toast.LENGTH_LONG).show();
                }else{
                    ans = subStrings(d1, d2);
                }
                decimalSubResult.setText(getString(R.string.ans)+ "."+ans);
            }
        });
    }

    public static String subStrings(String d1, String d2){
        int l1 = d1.length();
        int l2=d2.length();
        if (l1>l2){
            String y = "0";
            for (int i=0;i<l1-l2-1;i++){
                y+= "0";
            }
            d2 = y+d2;
        }
        else if (l2>l1){
            String y="0";
            for (int i=0;i<l2-l1-1;i++){
                y += "0";
            }
            d1 = y+d1;
        }
        String ans;
        if (d1.equals(d2)) {
            return "0";
        }
        else{
            d2 = tensComp(d2);
            ans = addStrings2(d1, d2);
            if (ans.charAt(0)=='-'){
                int x = 1;
                while (ans.charAt(x)=='0'){
                    x++;
                }
                ans = "-"+ans.substring(x);
            }
            else{
                int x = 0;
                while (ans.charAt(x)=='0'){
                    x++;
                }
                ans = ans.substring(x);
            }
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

    public static String addStrings2(String num1, String num2) {
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
        ans.reverse();
        if (x) {
            return String.valueOf(ans);
        }
        else{
            return "-"+tensComp(String.valueOf(ans));
        }
    }

    public static String tensComp(String d1){
        int l = d1.length();
        String ans="";
        for (int i=0;i<l;i++){
            char a = d1.charAt(i);
            ans += String.valueOf(9-Integer.parseInt(String.valueOf(a)));
        }
        return addStrings(ans, "1");
    }
}