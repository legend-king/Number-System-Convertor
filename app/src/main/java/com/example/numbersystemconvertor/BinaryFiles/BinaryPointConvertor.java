package com.example.numbersystemconvertor.BinaryFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class BinaryPointConvertor extends AppCompatActivity {

    Button binaryPointConvert;
    EditText editBinaryTextPoint;
    TextView binaryDecimalPoint, binaryOctalPoint, binaryHexaDecimalPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_point_convertor);

        binaryPointConvert = findViewById(R.id.binaryConvertPoint);
        editBinaryTextPoint = findViewById(R.id.editBinaryPointConvert);
        binaryDecimalPoint = findViewById(R.id.binary_decimal_point);
        binaryOctalPoint = findViewById(R.id.binary_octal_point);
        binaryHexaDecimalPoint = findViewById(R.id.binary_hexadecimal_point);

        binaryPointConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b1 = editBinaryTextPoint.getText().toString();
                String dec="", oct="", hexa="";
                if (b1.equals("")) {
                    Toast.makeText(BinaryPointConvertor.this, "Please Enter a binary value first", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean c = true;
                    for (int i = 0; i < b1.length(); i++) {
                        char a = b1.charAt(i);
                        if (a != '0' && a != '1' && a!='.') {
                            Toast.makeText(BinaryPointConvertor.this, "Binary number can only contain 0 and 1", Toast.LENGTH_LONG).show();
                            c = false;
                            break;
                        }
                    }
                    if (c){
                        int x = b1.indexOf('.');
                        int l = b1.length();
                        if (x==-1){
                            dec = binaryToDecimalConvert(b1);
                            oct = binaryToOctalConvert(b1);
                            hexa = binaryToHexaDecimalConvert(b1);
                        }
                        else if (b1.charAt(l-1)=='.'){
                            dec = binaryToDecimalConvert(b1.substring(0,l-1));
                            oct = binaryToOctalConvert(b1.substring(0,l-1));
                            hexa = binaryToHexaDecimalConvert(b1.substring(0,l-1));
                        }
                        else{
                            String b2 = b1.substring(0,x);
                            String b3 = b1.substring(x+1);

                            dec = binaryToDecimalConvert(b2)+binaryToDecimalPointConvert(b3);
                            oct = binaryToOctalConvert(b2)+"."+binaryToOctalConvertPoint(b3);
                            hexa = binaryToHexaDecimalConvert(b2)+"."+binaryToHexaDecimalPointConvert(b3);

                        }
                    }
                }
                String decAns = getString(R.string.decimalcolon)+dec;
                String octAns = getString(R.string.octalcolon)+oct;
                String hexaAns = getString(R.string.hexadecimalcolon)+hexa+"\n\n";
                binaryDecimalPoint.setText(decAns);
                binaryOctalPoint.setText(octAns);
                binaryHexaDecimalPoint.setText(hexaAns);
            }
        });
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

    public static String binaryToDecimalPointConvert(String b1){
        int l = b1.length();
        double j = 0.5;
        double sum=0;
        for (int i=0;i<l;i++){
            if (b1.charAt(i)=='1'){
                sum+=j;
            }
            j/=2;
        }
        if (sum==0){
            return ".0";
        }
        return String.valueOf(sum).substring(1);
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

    public static String binaryToOctalConvertPoint(String b){
        int l = b.length();
        if (l%3==2) {
            b = b+"0";
        }
        else if (l%3==1) {
            b = b+"00";
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

    public static String binaryToHexaDecimalPointConvert(String b1){
        int l1=b1.length();
        if (l1%4==3) {
            b1 = b1+"0";
        }
        else if (l1%4==2) {
            b1 = b1+"00";
        }
        else if (l1%4==1) {
            b1 = b1 + "000";
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