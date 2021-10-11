package com.alpha.peoplesbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.alpha.peoplesbank.ui.login.LoginActivity;

public class Registration1 extends AppCompatActivity {

    public Spinner FromAcc, IdentityType;
    public EditText AccNo, IdentityNo;
    public Button Next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration1);


        initialize();
        eventHandler();
    }


    public void initialize() {
        FromAcc = findViewById(R.id.sp_accounts);
        IdentityType = findViewById(R.id.re_id_type);

        AccNo = findViewById(R.id.et_toAccount);
        IdentityNo = findViewById(R.id.re_id_number);

        Next = findViewById(R.id.btn_transaction1_next);
    }


    public void eventHandler() {

        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signupButtonClickEvent();
            }
        });
    }


    public void signupButtonClickEvent() {

        String AccNumber = AccNo.getText().toString().trim();

        String IdentityNumber = IdentityNo.getText().toString().trim();

        Intent i = new Intent(Registration1.this, Registration2.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(i);
        finish();
    }

}