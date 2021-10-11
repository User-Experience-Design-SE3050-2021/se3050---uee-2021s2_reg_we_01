package com.alpha.peoplesbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Registration2 extends AppCompatActivity {

    public EditText mobile, email, pwd, confirmPwd;
    public Button Next;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration2);

        initialize();
        eventHandler();
    }

    public void initialize() {
        mobile = findViewById(R.id.re_mob_num);
        email = findViewById(R.id.re_email);

        pwd = findViewById(R.id.re_pss_wrd);
        confirmPwd = findViewById(R.id.re_cnfrm_pass);

        Next = findViewById(R.id.btn_transaction_next);
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

        String Mobile = mobile.getText().toString().trim();

        String Email = email.getText().toString().trim();
        String ConfirmPwd = confirmPwd.getText().toString().trim();
        String Pwd = pwd.getText().toString().trim();

//        Intent i = new Intent(Registration2.this, Registration2.class);
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        i.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//        startActivity(i);
//        finish();
    }


}