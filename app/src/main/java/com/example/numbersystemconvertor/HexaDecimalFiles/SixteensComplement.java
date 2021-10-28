package com.example.numbersystemconvertor.HexaDecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class SixteensComplement extends AppCompatActivity {
    EditText editSixteensComp;
    Button sixteensCompBtn;
    TextView sixteensCompResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixteens_complement);

        editSixteensComp = findViewById(R.id.editSixteensComp);
        sixteensCompBtn = findViewById(R.id.sixteensCompBtn);
        sixteensCompResult = findViewById(R.id.sixteensCompResult);

        sixteensCompBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h1 = editSixteensComp.getText().toString();
                String ans="";
                if (h1.equals("")){
                    Toast.makeText(getApplicationContext(), "Please enter a hexa decimal value first", Toast.LENGTH_SHORT).show();
                }
                else{
                    boolean c = true;
                    for (int i=0;i<h1.length();i++){
                        char a = h1.charAt(i);
                        if (!((a >= 48 && a <= 57) || (a >= 'A' && a <= 'F'))) {
                            Toast.makeText(getApplicationContext(), "HexaDecimal number can only contain digits and characters from 'A' to 'F'", Toast.LENGTH_LONG).show();
                            c = false;
                            break;
                        }
                    }
                    if (c){
                        ans = sixteensComplement(h1);
                    }
                }
                sixteensCompResult.setText(getText(R.string.sixteencomplementcolon)+" "+ans);
            }
        });

    }

    public static String sixteensComplement(String h1){
        h1 = fifteensComplement(h1);
        return hexaDecimalAdd(h1, "1");
    }

    public static String fifteensComplement(String h1){
        int l = h1.length();
        String ans="";
        for (int i=0;i<l;i++){
            char a = h1.charAt(i);
            if (a=='0'){
                ans += "F";
            }
            else if (a=='1'){
                ans += "E";
            }
            else if (a=='2'){
                ans += "D";
            }
            else if (a=='3'){
                ans += "C";
            }
            else if (a=='4'){
                ans += "B";
            }
            else if (a=='5'){
                ans += "A";
            }
            else if (a=='6'){
                ans += "9";
            }
            else if (a=='7'){
                ans += "8";
            }
            else if (a=='8'){
                ans += "7";
            }
            else if (a=='9'){
                ans += "6";
            }
            else if (a=='A'){
                ans += "5";
            }
            else if (a=='B'){
                ans += "4";
            }
            else if (a=='C'){
                ans += "3";
            }
            else if (a=='D'){
                ans += "2";
            }
            else if (a=='E'){
                ans += "1";
            }
            else if (a=='F'){
                ans += "0";
            }
        }
        return ans;
    }
    public static String hexaDecimalAdd(String h1, String h2){
        int l1 = h1.length();
        int l2 = h2.length();
        boolean carry=false;
        StringBuilder ans = new StringBuilder();
        int m=l1;
        if (l1>l2) {
            String y="";
            for (int i=0;i<l1-l2;i++) {
                y+="0";
            }
            h2 = y+h2;
        }
        else if (l2>l1){
            String y="";
            for (int i=0;i<l2-l1;i++) {
                y+="0";
            }
            h1 = y+h1;
            m=l2;
        }
        int x=0,y=0;
        for (int i=m-1;i>=0;i--){
            char a = h1.charAt(i);
            char b = h2.charAt(i);
            if (a>='0' && a<='9'){
                x = Integer.parseInt(String.valueOf(a));
            }
            else{
                if (a=='A'){
                    x=10;
                }
                else if (a=='B'){
                    x=11;
                }
                else if (a=='C'){
                    x=12;
                }
                else if (a=='D'){
                    x=13;
                }
                else if (a=='E'){
                    x=14;
                }
                else if (a=='F'){
                    x=15;
                }
            }
            if (b>='0' && b<='9'){
                y = Integer.parseInt(String.valueOf(b));
            }
            else{
                if (b=='A'){
                    y=10;
                }
                else if (b=='B'){
                    y=11;
                }
                else if (b=='C'){
                    y=12;
                }
                else if (b=='D'){
                    y=13;
                }
                else if (b=='E'){
                    y=14;
                }
                else if (b=='F'){
                    y=15;
                }
            }
            String z = "";
            if (carry){
                z = decimalToHexaDecimal(x+y+1);
                carry=false;
            }
            else{
                z = decimalToHexaDecimal(x+y);
            }
            int zl = z.length();
            if (zl==2){
                ans.append(z.charAt(1));
                carry=true;
            }
            else{
                ans.append(z);
                carry=false;
            }
        }
        if (carry){
            ans.append("1");
        }
        return String.valueOf(ans.reverse());
    }

    public static String decimalToHexaDecimal(int d){
        char ch='A';
        StringBuilder h = new StringBuilder();
        if (d<10){
            return String.valueOf(d);
        }
        if (d<16){
            char ch1 = (char) (ch + (d - 10));
            return String.valueOf(ch1);
        }
        while (d!=0){
            if (d%16<10){
                h.append(d%16);
            }
            else{
                h.append((char) (ch + ((d % 16)-10)));
            }
            d/=16;
        }
        return String.valueOf(h.reverse());
    }
}