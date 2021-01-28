package com.amirht97.workoutn4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Detail1Activity extends AppCompatActivity {

    public static final String NAME = "fullname";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final int CODESHAREPREF = 12;
    EditText et_FullName,et_PhoneNumber,et_Email;
    Button btn_GoSave;
    TextView tv_PhoneNumber_res,tv_FullName_res,tv_Email_res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);
        init();
    }

    private void init() {
        //EditText
        et_FullName=findViewById(R.id.et_FullName);
        et_PhoneNumber=findViewById(R.id.et_PhoneNumber);
        et_Email=findViewById(R.id.et_Email);
        //TextView
        tv_FullName_res=findViewById(R.id.tv_FullName_res);
        tv_PhoneNumber_res=findViewById(R.id.tv_PhoneNumber_res);
        tv_Email_res=findViewById(R.id.tv_Email_res);
        //Button
        btn_GoSave=findViewById(R.id.btn_GoSave);
        btn_GoSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Detail1Activity.this,Detail2Activity.class);
                intent.putExtra(NAME,et_FullName.getText().toString());
                intent.putExtra(EMAIL,et_Email.getText().toString());
                intent.putExtra(PHONE,et_PhoneNumber.getText().toString());
                startActivityForResult(intent,CODESHAREPREF);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CODESHAREPREF)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                tv_FullName_res.setText(data.getStringExtra(NAME));
                tv_PhoneNumber_res.setText(data.getStringExtra(PHONE));
                tv_Email_res.setText(data.getStringExtra(EMAIL));
            }
        }
    }
}