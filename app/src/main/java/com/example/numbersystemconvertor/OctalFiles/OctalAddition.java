package com.example.numbersystemconvertor.OctalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.BinaryFiles.BinaryAddition;
import com.example.numbersystemconvertor.R;

public class OctalAddition extends AppCompatActivity {
    EditText octalAdd1, octalAdd2;
    Button octalAddBtn;
    TextView octalAddResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal_addition);

        octalAdd1 = findViewById(R.id.octalAdd1);
        octalAdd2 = findViewById(R.id.octalAdd2);
        octalAddBtn = findViewById(R.id.octalAddBtn);
        octalAddResult = findViewById(R.id.octalAddResult);

        octalAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o1 = octalAdd1.getText().toString();
                String o2 = octalAdd2.getText().toString();
                String addAns="";
                int l1 = o1.length();
                int l2 = o2.length();
                if (o1.equals("") || o2.equals("")) {
                    Toast.makeText(OctalAddition.this, "Please Enter an octal value first", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean c = true;
                    for (int i = 0; i < l1; i++) {
                        char a = o1.charAt(i);
                        if (!(o1.charAt(i)>=48 && o1.charAt(i)<=55)){
                            Toast.makeText(OctalAddition.this, "Octal number can only contain digits from 0 to 7", Toast.LENGTH_LONG).show();
                            c=false;
                            break;
                        }
                    }
                    if (c){
                        for (int i = 0; i < l2; i++) {
                            char a = o2.charAt(i);
                            if (!(o2.charAt(i)>=48 && o2.charAt(i)<=55)){
                                Toast.makeText(OctalAddition.this, "Octal number can only contain digits from 0 to 7", Toast.LENGTH_LONG).show();
                                c=false;
                                break;
                            }
                        }
                        if (c) {
                            addAns = octalAdd(o1,o2);
                        }

                    }
                }
                octalAddResult.setText(getString(R.string.ans)+addAns);
            }
        });
    }

    public static String octalAdd(String o1, String o2){
        int l1 = o1.length();
        int l2 = o2.length();
        int m  = l1;
        StringBuilder addAns = new StringBuilder();
        boolean carry=false;
        if (l1>l2){
            String y="0";
            for (int i=0;i<l1-l2-1;i++){
                y += "0";
            }
            o2 = y+o2;
        }
        else if(l2>l1){
            String y="0";
            for (int i=0;i<l2-l1-1;i++){
                y += "0";
            }
            m = l2;
            o1 = y+o1;
        }
        String y;
        for (int i=m-1;i>=0;i--){
            char a = o1.charAt(i);
            char b = o2.charAt(i);
            if (carry){
                y = String.valueOf(octal(a - 48 + b - 48+1));
            }
            else {
                y = String.valueOf(octal(a - 48 + b - 48));
            }
            if (y.length()==2){
                carry=true;
                addAns.append(y.charAt(1));
            }
            else{
                addAns.append(y);
                carry=false;
            }

        }
        if (carry){
            addAns.append("1");
        }
        return String.valueOf(addAns.reverse());
    }

    public static int octal(int a){
        if (a<=7)
            return a;
        return (a%8)+10 * octal(a/8);
    }
}