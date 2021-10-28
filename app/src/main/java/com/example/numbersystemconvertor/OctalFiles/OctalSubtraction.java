package com.example.numbersystemconvertor.OctalFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class OctalSubtraction extends AppCompatActivity {
    EditText octalSub1, octalSub2;
    Button octalSubBtn;
    TextView octalSubResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_octal_subtraction);

        octalSub1 = findViewById(R.id.octalSub1);
        octalSub2 = findViewById(R.id.octalSub2);
        octalSubBtn = findViewById(R.id.octalSubBtn);
        octalSubResult = findViewById(R.id.octalSubResult);

        octalSubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o1 = octalSub1.getText().toString();
                String o2 = octalSub2.getText().toString();
                String subAns="";
                int l1 = o1.length();
                int l2 = o2.length();
                if (o1.equals("") || o2.equals("")) {
                    Toast.makeText(OctalSubtraction.this, "Please Enter an octal value first", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean c = true;
                    for (int i = 0; i < l1; i++) {
                        char a = o1.charAt(i);
                        if (!(a>=48 && a<=55)){
                            Toast.makeText(OctalSubtraction.this, "Octal number can only contain digits from 0 to 7", Toast.LENGTH_LONG).show();
                            c=false;
                            break;
                        }
                    }
                    if (c){
                        for (int i = 0; i < l2; i++) {
                            char a = o2.charAt(i);
                            if (!(a>=48 && a<=55)){
                                Toast.makeText(OctalSubtraction.this, "Octal number can only contain digits from 0 to 7", Toast.LENGTH_LONG).show();
                                c=false;
                                break;
                            }
                        }
                        if (c) {
                            subAns = octalSub(o1,o2);
                        }

                    }
                }
                octalSubResult.setText(getString(R.string.ans)+ " " +subAns);
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

    public static String octalSub(String o1, String o2){
        int l1 = o1.length();
        int l2 = o2.length();
        if (l1>l2){
            String y = "0";
            for (int i=0;i<l1-l2-1;i++){
                y+= "0";
            }
            o2 = y+o2;
        }
        else if (l2>l1){
            String y="0";
            for (int i=0;i<l2-l1-1;i++){
                y += "0";
            }
            o1 = y+o1;
        }
        String ans;
        if (o1.equals(o2)) {
            ans = "0";
        }
        else {
            o2 = eightsComplement(o2);
            ans = octalAdd2(o1, o2);
            if (ans.charAt(0)=='-'){
                int x = 1;
                while (ans.charAt(x)=='0'){
                    x++;
                }
                ans = "-"+ans.substring(x);
            }
            else{
                int x = 0;
                while (ans.charAt(x)=='0'){
                    x++;
                }
                ans = ans.substring(x);
            }
        }
        return ans;
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
    public static String eightsComplement(String o1){
        o1 = sevensComp(o1);
        return octalAdd(o1, "1");
    }

    public static String octalAdd2(String o1, String o2){
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
        addAns.reverse();
        if (carry) {
            return String.valueOf(addAns);
        }
        else {
            return "-"+eightsComplement(String.valueOf(addAns));
        }
    }
}