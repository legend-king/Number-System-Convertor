package com.example.numbersystemconvertor.HexaDecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class FifteensComplement extends AppCompatActivity {
    EditText editFifteensComp;
    Button fifteensCompBtn;
    TextView fifteensCompResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifteens_complement);

        editFifteensComp = findViewById(R.id.editFifteensComp);
        fifteensCompBtn = findViewById(R.id.fifteensCompBtn);
        fifteensCompResult = findViewById(R.id.fifteensCompResult);

        fifteensCompBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String h1 = editFifteensComp.getText().toString();
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
                        ans = fifteensComplement(h1);
                    }
                }
                fifteensCompResult.setText(getText(R.string.fifteenscomplementcolon)+" "+ans);
            }
        });
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

}