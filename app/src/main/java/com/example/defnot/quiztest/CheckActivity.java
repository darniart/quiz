package com.example.defnot.quiztest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheckActivity extends AppCompatActivity {

    Button mRegister_btn, mLogin_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        mRegister_btn = findViewById(R.id.register_btn);
        mLogin_btn = findViewById(R.id.login_btn);

        mRegister_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start RegisterActivity
                startActivity(new Intent(CheckActivity.this, RegisterActivity.class));
            }
        });

        //handle login button click
        mLogin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // start LoginActivity
                startActivity(new Intent(CheckActivity.this, LoginActivity.class));
            }
        });

    }
}
