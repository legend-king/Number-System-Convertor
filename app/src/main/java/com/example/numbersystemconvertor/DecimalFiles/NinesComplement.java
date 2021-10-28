package com.example.numbersystemconvertor.DecimalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class NinesComplement extends AppCompatActivity {
    EditText editNinesComp;
    Button ninesCompBtn;
    TextView ninesCompResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nines_complement);

        editNinesComp = findViewById(R.id.editNinesComp);
        ninesCompBtn = findViewById(R.id.ninesCompBtn);
        ninesCompResult = findViewById(R.id.ninesCompResult);

        ninesCompBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d1 = editNinesComp.getText().toString();
                String ans="";
                if (d1.equals("")){
                    Toast.makeText(getApplicationContext(), "Please Enter a Decimal Value First", Toast.LENGTH_SHORT).show();
                }
                else{
                    ans = ninesComp(d1);
                }
                ninesCompResult.setText(getText(R.string.ninescomplementcolon) + ans);
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
}