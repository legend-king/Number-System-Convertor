package com.example.numbersystemconvertor.HexaDecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class HexaDecimalConvertor extends AppCompatActivity {
    Button hexaDecimalConvertBtn;
    EditText editHexaDecimalConvert;
    TextView hexaDecimalBinary, hexaDecimalOctal, hexaDecimalDecimal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hexa_decimal_convertor);

        hexaDecimalConvertBtn = findViewById(R.id.hexaDecimalConvertBtn);
        editHexaDecimalConvert = findViewById(R.id.editHexaDecimalConvert);
        hexaDecimalBinary = findViewById(R.id.hexadecimal_binary);
        hexaDecimalOctal = findViewById(R.id.hexadecimal_octal);
        hexaDecimalDecimal = findViewById(R.id.hexadecimal_decimal);

        hexaDecimalConvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h1 = editHexaDecimalConvert.getText().toString();
                boolean c = true;
                String bin="", oct="", dec="";
                if (h1.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter a HexaDecimal value first", Toast.LENGTH_LONG).show();
                } else {
                    for (int i = 0; i < h1.length(); i++) {
                        char a = h1.charAt(i);
                        if (!((a >= 48 && a <= 57) || (a >= 'A' && a <= 'F'))) {
                            Toast.makeText(getApplicationContext(), "HexaDecimal number can only contain digits and characters from 'A' to 'F'", Toast.LENGTH_LONG).show();
                            c = false;
                            break;
                        }
                    }
                    if (c) {
                        bin = hexaDecimalToBinaryConvert(h1);
                        dec = binaryToDecimalConvert(bin);
                        oct = binaryToOctalConvert(bin);
                    }
                }
                String binAns = getString(R.string.binarycolon)+bin;
                String octAns = getString(R.string.octalcolon)+oct;
                String decAns = getString(R.string.hexadecimalcolon)+dec+"\n\n";
                hexaDecimalBinary.setText(binAns);
                hexaDecimalOctal.setText(octAns);
                hexaDecimalDecimal.setText(decAns);
            }
        });
    }

    public static String hexaDecimalToBinaryConvert(String h1){
        int l = h1.length();
        String ans="";
        for (int i=0;i<l;i++){
            char a = h1.charAt(i);
            if (a=='0'){
                ans += "0000";
            }
            else if (a=='1'){
                ans += "0001";
            }
            else if (a=='2'){
                ans += "0010";
            }
            else if (a=='3'){
                ans += "0011";
            }
            else if (a=='4'){
                ans += "0100";
            }
            else if (a=='5'){
                ans += "0101";
            }
            else if (a=='6'){
                ans += "0110";
            }
            else if (a=='7'){
                ans += "0111";
            }
            else if (a=='8'){
                ans += "1000";
            }
            else if (a=='9'){
                ans += "1001";
            }
            else if (a=='A'){
                ans += "1010";
            }
            else if (a=='B'){
                ans += "1011";
            }
            else if (a=='C'){
                ans += "1100";
            }
            else if (a=='D'){
                ans += "1101";
            }
            else if (a=='E'){
                ans += "1110";
            }
            else if (a=='F'){
                ans += "1111";
            }
        }
        return ans;
    }

    public static String binaryToDecimalConvert(String b1){
        String num1="0";
        String num2="1";
        int j=0;
        boolean x=true;
        for (int i=b1.length()-1;i>=0;i--) {
            if (x) {
                num2 = "1";
                x=false;
            }
            else {
                num2 = multiplyStrings(num2, "2");
            }
            char a = b1.charAt(i);
            if (a=='1') {
                num1 = addStrings(num1, num2);
            }
            j++;
        }
        return num1;
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

    public static String multiplyStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if (len1 == 0 || len2 == 0)
            return "0";

        int result[] = new int[len1 + len2];

        int i_n1 = 0;
        int i_n2 = 0;

        for (int i = len1 - 1; i >= 0; i--) {
            int carry = 0;
            int n1 = num1.charAt(i) - '0';

            i_n2 = 0;

            for (int j = len2 - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';

                int sum = n1 * n2 + result[i_n1 + i_n2] + carry;

                carry = sum / 10;

                result[i_n1 + i_n2] = sum % 10;

                i_n2++;
            }

            if (carry > 0)
                result[i_n1 + i_n2] += carry;

            i_n1++;
        }

        int i = result.length - 1;
        while (i >= 0 && result[i] == 0)
            i--;

        if (i == -1)
            return "0";

        String s = "";

        while (i >= 0)
            s += (result[i--]);

        return s;
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
}