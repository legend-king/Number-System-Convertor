package com.example.numbersystemconvertor.BinaryFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class OnesComplement extends AppCompatActivity {
    EditText editOnesComp;
    Button onesCompBtn;
    TextView onesCompResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ones_complement);

        editOnesComp = findViewById(R.id.editOnesComp);
        onesCompBtn = findViewById(R.id.onesCompBtn);
        onesCompResult = findViewById(R.id.onesCompResult);

        onesCompBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b1 = editOnesComp.getText().toString();
                String onesCompAns = "";
                if (b1.equals("")) {
                    Toast.makeText(OnesComplement.this, "Please Enter a binary value first", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean c = true;
                    for (int i = 0; i < b1.length(); i++) {
                        char a = b1.charAt(i);
                        if (a != '0' && a != '1') {
                            Toast.makeText(OnesComplement.this, "Binary number can only contain 0 and 1", Toast.LENGTH_LONG).show();
                            c = false;
                            break;
                        }
                    }
                    if (c){
                        onesCompAns = onesComp(b1);
                    }
                }
                onesCompResult.setText(getText(R.string.onescomplementcolon) + onesCompAns);
            }
        });
    }

    public static String onesComp(String b1){
        String onesCompAns = "";
        for (int i=0;i<b1.length();i++){
            char a = b1.charAt(i);
            if (a=='1'){
                onesCompAns+='0';
            }
            else{
                onesCompAns+='1';
            }
        }
        return onesCompAns;
    }
}