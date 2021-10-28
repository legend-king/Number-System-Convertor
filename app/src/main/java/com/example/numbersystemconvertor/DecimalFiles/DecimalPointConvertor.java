package com.example.numbersystemconvertor.DecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class DecimalPointConvertor extends AppCompatActivity {
    Button decimalPointConvertBtn;
    EditText editDecimalPointConvert;
    TextView decimalBinaryPoint, decimalOctalPoint, decimalHexaDecimalPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decimal_point_convertor);

        decimalPointConvertBtn = findViewById(R.id.decimalPointConvertBtn);
        editDecimalPointConvert = findViewById(R.id.editDecimalPointConvert);
        decimalBinaryPoint = findViewById(R.id.decimal_binary_point);
        decimalOctalPoint = findViewById(R.id.decimal_octal_point);
        decimalHexaDecimalPoint = findViewById(R.id.decimal_hexadecimal_point);

        decimalPointConvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = editDecimalPointConvert.getText().toString();
                String bin="", oct="", hexa="";
                if (d1.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter a Decimal Value First", Toast.LENGTH_SHORT).show();
                }
                else{
                    int x = d1.indexOf('.');
                    int l = d1.length();
                    if (x==-1){
                        bin = decimalToBinaryConvert(d1);
                        oct = binaryToOctalConvert(bin);
                        hexa = binaryToHexaDecimalConvert(bin);
                    }
                    else if (d1.charAt(l-1)=='.'){
                        bin = decimalToBinaryConvert(d1.substring(0,l-1));
                        oct = binaryToOctalConvert(bin);
                        hexa = binaryToHexaDecimalConvert(bin);
                    }
                    else{
                        String d2 = d1.substring(0,x);
                        String d3 = d1.substring(x+1);
                        String bin1 = decimalToBinaryConvert(d2);
                        String bin2 = decimalToBinaryPointConvert(d3);
                        bin = bin1 + ".";
                        int lb = bin2.length();
                        int d3l = d3.length()+2;
                        if (d3l<bin2.length()){
                            bin+=bin.substring(0, d3l);
                        }
                        else{
                            bin+=bin2;
                        }
                        oct = binaryToOctalConvert(bin1) + "." + binaryToOctalConvertPoint(bin2);
                        hexa = binaryToHexaDecimalConvert(bin1) + "." + binaryToHexaDecimalPointConvert(bin2);
                    }
                }
                String binAns = getString(R.string.binarycolon)+ " " +bin;
                String octAns = getString(R.string.octalcolon)+ " " +oct;
                String hexaAns = getString(R.string.hexadecimalcolon)+ " " +hexa+"\n\n";
                decimalBinaryPoint.setText(binAns);
                decimalOctalPoint.setText(octAns);
                decimalHexaDecimalPoint.setText(hexaAns);
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

    public static String decimalToBinaryPointConvert(String d){
        int x = 0;
        int l=d.length()-1;
        while (d.charAt(x)=='0' && x<l) {
            x++;
        }
        d=d.substring(x);
        if (d.equals("0")){
            return "0";
        }

        StringBuilder b = new StringBuilder();
        String ans;
        for (int i=0;i<=l+((l+1)*2*3);i++) {
            if (d.charAt(0)<53) {
                b.append(0);
                d = multiplyStrings(d, "2");
            }
            else if (d.charAt(0)==53 && d.length()==1){
                b.append("1");
                break;
            }
            else {
                b.append("1");
                d = multiplyStrings(d, "2");
                d = d.substring(1);
            }
            StringBuilder d1 = new StringBuilder();
            d1.append(d);
            d1.reverse();
            int x1 = 0, l1=d1.length();
            while (d1.charAt(x1)=='0') {
                x1++;
            }
            d = d.substring(0,l1-x1);
        }
        return String.valueOf(b);
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
}