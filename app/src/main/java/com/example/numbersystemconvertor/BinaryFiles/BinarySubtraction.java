package com.example.numbersystemconvertor.BinaryFiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.numbersystemconvertor.R;

public class BinarySubtraction extends AppCompatActivity {

    EditText binarySub1, binarySub2;
    Button binarySubBtn;
    TextView binarySubResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_subtraction);

        binarySub1 = findViewById(R.id.binarySub1);
        binarySub2 = findViewById(R.id.binarySub2);
        binarySubBtn = findViewById(R.id.binarySubBtn);
        binarySubResult = findViewById(R.id.binarySubResult);

        binarySubBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b1 = binarySub1.getText().toString();
                String b2 = binarySub2.getText().toString();
                String subAns="";
                int l1 = b1.length();
                int l2 = b2.length();
                if (b1.equals("") || b2.equals("")) {
                    Toast.makeText(BinarySubtraction.this, "Please Enter a binary value first", Toast.LENGTH_LONG).show();
                }
                else{
                    boolean c = true;
                    for (int i = 0; i < l1; i++) {
                        char a = b1.charAt(i);
                        if (a != '0' && a != '1') {
                            Toast.makeText(BinarySubtraction.this, "Binary number can only contain 0 and 1", Toast.LENGTH_LONG).show();
                            c = false;
                            break;
                        }
                    }
                    if (c){
                        for (int i = 0; i < l2; i++) {
                            char a = b2.charAt(i);
                            if (a != '0' && a != '1') {
                                Toast.makeText(BinarySubtraction.this, "Binary number can only contain 0 and 1", Toast.LENGTH_LONG).show();
                                c = false;
                                break;
                            }
                        }
                        if (c) {
                            subAns = binarySub(b1,b2);
                        }

                    }
                }
                binarySubResult.setText(getString(R.string.ans)+subAns);
            }
        });
    }

    public static String binarySub(String b1, String b2){
        int l1 = b1.length();
        int l2=b2.length();
        if (l1>l2){
            String y = "0";
            for (int i=0;i<l1-l2-1;i++){
                y+= "0";
            }
            b2 = y+b2;
        }
        else if (l2>l1){
            String y="0";
            for (int i=0;i<l2-l1-1;i++){
                y += "0";
            }
            b1 = y+b1;
        }
        String ans;
        if (b1.equals(b2)) {
            return "0";
        }
        else {
            b2 = twosComplement(b2);
            ans = binaryAdd2(b1, b2);
            int x = ans.indexOf('1');
            if (ans.charAt(0)=='-'){
                ans = '-' + ans.substring(x);
            }
            else {
                ans = ans.substring(x);
            }
        }
        return ans;
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

    public static String binaryAdd(String b1, String b2){
        int l1 = b1.length();
        int l2=b2.length();
        int m=l1;
        StringBuilder addAns = new StringBuilder();
        boolean carry=false;
        if (l1>l2){
            String y = "0";
            for (int i=0;i<l1-l2-1;i++){
                y+= "0";
            }
            m = l1;
            b2 = y+b2;
        }
        else if (l2>l1){
            String y="0";
            for (int i=0;i<l2-l1-1;i++){
                y += "0";
            }
            m = l2;
            b1 = y+b1;
        }
        for (int i=m-1;i>=0;i--){
            char a1 = b1.charAt(i);
            char a2 = b2.charAt(i);
            if (a1=='0' && a2=='0' && carry){
                addAns.append("1");
                carry=false;
            }
            else if (a1=='1' && a2=='1' && carry){
                addAns.append("1");
            }
            else if ((a1=='1' || a2=='1') && carry){
                addAns.append("0");
            }
            else if (a1=='0' && a2=='0'){
                addAns.append("0");
            }
            else if (a1=='1' && a2=='1'){
                addAns.append("0");
                carry=true;
            }
            else if (a1=='1' || a2=='1'){
                addAns.append("1");
            }
        }
        if (carry) {
            addAns.append("1");
        }
        return String.valueOf(addAns.reverse());

    }

    public static String binaryAdd2(String b1, String b2) {
        int l1 = b1.length();
        int l2=b2.length();
        int m=l2;
        boolean carry = false;
        StringBuilder addAns = new StringBuilder();
        if (l1>l2){
            String y = "0";
            for (int i=0;i<l1-l2-1;i++){
                y+= "0";
            }
            m = l1;
            b2 = y+b2;
        }
        else if (l2>l1){
            String y="0";
            for (int i=0;i<l2-l1-1;i++){
                y += "0";
            }
            m = l2;
            b1 = y+b1;
        }
        for (int i=m-1;i>=0;i--){
            char a1 = b1.charAt(i);
            char a2 = b2.charAt(i);
            if (a1=='0' && a2=='0' && carry){
                addAns.append("1");
                carry=false;
            }
            else if (a1=='1' && a2=='1' && carry){
                addAns.append("1");
            }
            else if ((a1=='1' || a2=='1') && carry){
                addAns.append("0");
            }
            else if (a1=='0' && a2=='0'){
                addAns.append("0");
            }
            else if (a1=='1' && a2=='1'){
                addAns.append("0");
                carry=true;
            }
            else if (a1=='1' || a2=='1'){
                addAns.append("1");
            }
        }
        addAns.reverse();
        if (carry) {
            return String.valueOf(addAns);
        }
        else {
            return "-"+twosComplement(String.valueOf(addAns));
        }

    }

    public static String twosComplement(String b1) {
        b1 = onesComp(b1);
        return binaryAdd(b1, "1");
    }
}