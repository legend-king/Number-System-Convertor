package com.example.numbersystemconvertor.OctalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.BinaryFiles.OnesComplement;
import com.example.numbersystemconvertor.R;

import org.w3c.dom.Text;

public class SevensComplement extends AppCompatActivity {
    Button sevensCompBtn;
    EditText editSevensComp;
    TextView sevensCompRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sevens_complement);

        sevensCompBtn = findViewById(R.id.sevensCompBtn);
        editSevensComp = findViewById(R.id.editSevensComp);
        sevensCompRes = findViewById(R.id.sevensCompResult);

        sevensCompBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o1 = editSevensComp.getText().toString();
                String sevensCompAns = "";
                if (o1.equals("")) {
                    Toast.makeText(SevensComplement.this, "Please Enter an octal value first", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean c = true;
                    for (int i = 0; i < o1.length(); i++) {
                        char a = o1.charAt(i);
                        if (!(o1.charAt(i)>=48 && o1.charAt(i)<=55)){
                            Toast.makeText(SevensComplement.this, "Octal number can only contain digits from 0 to 7", Toast.LENGTH_LONG).show();
                            c=false;
                            break;
                        }
                    }
                    if (c){
                        sevensCompAns = sevensComp(o1);
                    }
                }
                sevensCompRes.setText(getText(R.string.sevenscomplementcolon) + " " +sevensCompAns);
            }
        });
    }

    public static String sevensComp(String o1){
        int l = o1.length();
        String ans="";
        for (int i=0;i<l;i++){
            char a = o1.charAt(i);
            ans += String.valueOf(7-Integer.parseInt(String.valueOf(a)));
        }
        return ans;
    }
}