package com.example.numbersystemconvertor.DecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class DecimalConvertor extends AppCompatActivity {
    Button decimalConvertBtn;
    EditText editDecimalConvert;
    TextView decimalBinary, decimalOctal, decimalHexaDecimal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_convertor);

        decimalConvertBtn = findViewById(R.id.decimalConvertBtn);
        editDecimalConvert = findViewById(R.id.editDecimalConvert);
        decimalBinary = findViewById(R.id.decimal_binary);
        decimalOctal = findViewById(R.id.decimal_octal);
        decimalHexaDecimal = findViewById(R.id.decimal_hexadecimal);

        decimalConvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = editDecimalConvert.getText().toString();
                String bin="", oct="", hexa="";
                if (d1.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter a Decimal Value First", Toast.LENGTH_SHORT).show();
                }
                else{
                    bin = decimalToBinaryConvert(d1);
                    oct = binaryToOctalConvert(bin);
                    hexa = binaryToHexaDecimalConvert(bin);
                }
                String binAns = getString(R.string.binarycolon)+bin;
                String octAns = getString(R.string.octalcolon)+oct;
                String hexaAns = getString(R.string.hexadecimalcolon)+hexa+"\n\n";
                decimalBinary.setText(binAns);
                decimalOctal.setText(octAns);
                decimalHexaDecimal.setText(hexaAns);
            }
        });
    }

    public static String decimalToBinaryConvert(String d1){
        StringBuilder ans = new StringBuilder();
        int l=d1.length()-1;
        while (!d1.equals("1")){
            if (d1.charAt(l)%2==0) {
                ans.append("0");
            }
            else {
                ans.append("1");
            }
            d1 = longDivision(d1, 2);
            l = d1.length()-1;
        }
        ans.append("1");
        return String.valueOf(ans.reverse());
    }

    public static String longDivision(String number, int divisor) {
        StringBuilder result = new StringBuilder();
        char[] dividend = number.toCharArray();
        int carry = 0;
        for (char c : dividend) {
            int x = carry * 10 + Character.getNumericValue(c);
            result.append(x / divisor);
            carry = x % divisor;
        }
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                return result.substring(i);
            }
        }
        return "";
    }

    public static String binaryToOctalConvert(String b){
        int l=b.length();
        if (l%3==2) {
            String y = "0";
            b = y+b;
        }
        else if (l%3==1) {
            String y = "00";
            b = y+b;
        }
        String o="";
        for (int i=0;i<=l-1;i+=3) {
            String x=b.substring(i,i+3);
            switch (x) {
                case "000":
                    o += "0";
                    break;
                case "001":
                    o += "1";
                    break;
                case "010":
                    o += "2";
                    break;
                case "011":
                    o += "3";
                    break;
                case "100":
                    o += "4";
                    break;
                case "101":
                    o += "5";
                    break;
                case "110":
                    o += "6";
                    break;
                case "111":
                    o += "7";
                    break;
            }

        }
        return o;
    }

    public static String binaryToHexaDecimalConvert(String b1){
        int l1=b1.length();
        if (l1%4==3) {
            String y = "0";
            b1 = y+b1;
        }
        else if (l1%4==2) {
            String y = "00";
            b1 = y+b1;
        }
        else if (l1%4==1) {
            String y = "000";
            b1 = y+b1;
        }
        String h="";
        for (int i=0;i<=l1-1;i+=4) {
            String x=b1.substring(i,i+4);
            switch (x) {
                case "0000":
                    h += "0";
                    break;
                case "0001":
                    h += "1";
                    break;
                case "0010":
                    h += "2";
                    break;
                case "0011":
                    h += "3";
                    break;
                case "0100":
                    h += "4";
                    break;
                case "0101":
                    h += "5";
                    break;
                case "0110":
                    h += "6";
                    break;
                case "0111":
                    h += "7";
                    break;
                case "1000":
                    h += "8";
                    break;
                case "1001":
                    h += "9";
                    break;
                case "1010":
                    h += "A";
                    break;
                case "1011":
                    h += "B";
                    break;
                case "1100":
                    h += "C";
                    break;
                case "1101":
                    h += "D";
                    break;
                case "1110":
                    h += "E";
                    break;
                case "1111":
                    h += "F";
                    break;
            }

        }
        return h;
    }
}