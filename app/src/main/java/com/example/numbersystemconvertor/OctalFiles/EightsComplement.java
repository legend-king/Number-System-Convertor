package com.example.numbersystemconvertor.OctalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class EightsComplement extends AppCompatActivity {
    Button eightsCompBtn;
    EditText editEightsComp;
    TextView eightsCompRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eights_complement);

        eightsCompBtn = findViewById(R.id.eightsCompBtn);
        editEightsComp = findViewById(R.id.editEightsComp);
        eightsCompRes = findViewById(R.id.eightsCompResult);

        eightsCompBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o1 = editEightsComp.getText().toString();
                String eightsCompAns = "";
                if (o1.equals("")) {
                    Toast.makeText(EightsComplement.this, "Please Enter an octal value first", Toast.LENGTH_LONG).show();
                }
                else {
                    boolean c = true;
                    for (int i = 0; i < o1.length(); i++) {
                        char a = o1.charAt(i);
                        if (!(o1.charAt(i)>=48 && o1.charAt(i)<=55)){
                            Toast.makeText(EightsComplement.this, "Octal number can only contain digits from 0 to 7", Toast.LENGTH_LONG).show();
                            c=false;
                            break;
                        }
                    }
                    if (c){
                        eightsCompAns = sevensComp(o1);
                        eightsCompAns = octalAdd(eightsCompAns, "1");
                    }
                }
                eightsCompRes.setText(getText(R.string.eightscomplementcolon) + " " +eightsCompAns);
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