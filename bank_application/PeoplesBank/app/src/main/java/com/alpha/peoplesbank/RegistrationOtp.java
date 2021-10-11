package com.alpha.peoplesbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alpha.peoplesbank.ui.login.LoginActivity;

public class RegistrationOtp extends AppCompatActivity {
    public Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_otp);

        initialize();
        eventHandler();

    }

    public void initialize() {

        Next = findViewById(R.id.btn_submit_re);
    }

    public void eventHandler() {

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup2ButtonClickEvent();
            }
        });
    }

    public void signup2ButtonClickEvent() {


        Intent i = new Intent(RegistrationOtp.this, LoginActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
        finish();
    }

}