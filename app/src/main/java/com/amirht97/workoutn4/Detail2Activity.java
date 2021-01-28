package com.amirht97.workoutn4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Detail2Activity extends AppCompatActivity implements View.OnClickListener {

    public static final int CODESHAREPREF = 12;
    public static final String NAME = "fullname";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

    String FullName,Email,Phone;

    TextView tv_PhoneNumber,tv_FullName,tv_Email;

    Button btn_Save,btn_Edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        init();
    }

    private void init() {
        tv_FullName=findViewById(R.id.tv_FullName);
        tv_PhoneNumber=findViewById(R.id.tv_PhoneNumber);
        tv_Email=findViewById(R.id.tv_Email);

        btn_Save=findViewById(R.id.btn_Save);
        btn_Edit=findViewById(R.id.btn_Edit);

        Intent intent = getIntent();
        FullName = intent.getStringExtra(NAME);
        Email = intent.getStringExtra(EMAIL);
        Phone = intent.getStringExtra(PHONE);

        tv_FullName.setText(FullName);
        tv_Email.setText(Email);
        tv_PhoneNumber.setText(Phone);

        btn_Edit.setOnClickListener(this);
        btn_Save.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_Edit:
                finish();
                break;
            case R.id.btn_Save:
                getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit().putString(NAME, FullName).apply();
                getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit().putString(EMAIL, Email).apply();
                getSharedPreferences("userInfo", Context.MODE_PRIVATE).edit().putString(PHONE, Phone).apply();
                Toast.makeText(Detail2Activity.this, "Items saved successfully", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.putExtra(NAME,FullName);
                intent.putExtra(EMAIL, Email);
                intent.putExtra(PHONE, Phone);
                setResult(Activity.RESULT_OK,intent);
                finish();
                break;
        }
    }
}