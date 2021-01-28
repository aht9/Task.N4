package com.amirht97.workoutn4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DialActivity extends AppCompatActivity {

    EditText et_PhoneNumber_call;
    Button btn_Call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dial);
        et_PhoneNumber_call=findViewById(R.id.et_PhoneNumber_call);
        btn_Call=findViewById(R.id.btn_Call);
        btn_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:" + et_PhoneNumber_call.getText().toString()));
                startActivity(callIntent);
            }
        });
    }
}