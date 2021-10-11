package com.alpha.peoplesbank.ui.login;

import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.alpha.peoplesbank.R;
import com.alpha.peoplesbank.retrofit.APIClient;
import com.alpha.peoplesbank.retrofit.APIInterface;
import com.alpha.peoplesbank.ui.login.LoginViewModel;
import com.alpha.peoplesbank.ui.login.LoginViewModelFactory;
import com.alpha.peoplesbank.databinding.ActivityLoginBinding;

import org.json.JSONObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    public EditText etUN, etPwd;
    public Button btnLogin;
    public TextView tvForgotPassword, tvSignup, tvUnError, tvPwdError, tvTermsAndCondtion;
    public LinearLayout loUsername, loPassword;
    public String userName = "", loginType = "NA";
    public String googleName = "", googleUniqueId = "", profileImageUrl = "", facebookUniqueId = "", signUpText = "", termsAndConditionText = "", fcmToken = "NA";
    public ImageView ivShowHidePwd;

    public boolean isShowPassword = false;
    static APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initialize();
        eventHandler();
    }


    @Override
    public void onBackPressed()
    {
        finish();
    }



    public void initialize() {

        etUN = (EditText) findViewById(R.id.et_userName);
        etPwd = (EditText) findViewById(R.id.et_password);

        loUsername = (LinearLayout) findViewById(R.id.lo_userName);
        loPassword = (LinearLayout) findViewById(R.id.lo_password);

        btnLogin = (Button) findViewById(R.id.btn_login);

        tvForgotPassword = (TextView) findViewById(R.id.tv_forgotPwd);
        //tvTermsAndCondtion = (TextView) findViewById(R.id.tv_termsAndConditionLogin);
        tvSignup = (TextView) findViewById(R.id.tv_signUp);
        tvUnError = (TextView) findViewById(R.id.tv_unErrorLogin);
        tvPwdError = (TextView) findViewById(R.id.tv_pwdErrorLogin);

        ivShowHidePwd = (ImageView) findViewById(R.id.iv_passwordShowHide);
        new APIClient(LoginActivity.this, LoginActivity.this);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        signUpText = "Do not have an profile? Sign Up";

        termsAndConditionText = "By Sign In, you agree to our Terms & Conditions.";

    }

    public void eventHandler() {
        setSignUpTextColor();
        showHidePasswordEventHandler();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginButtonClickEvent();
            }
        });


        etPwd.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(etPwd.getWindowToken(), 0);

                    loginButtonClickEvent();

                    handled = true;
                }
                return handled;
            }
        });


        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent in = new Intent(LoginActivity.this, Reg.class);
//                in.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
//                in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                startActivity(in);
            }
        });




    }

    public void showHidePasswordEventHandler() {
        etPwd.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = s.toString();

                if (text.length() > 0) {
                    ivShowHidePwd.setVisibility(View.VISIBLE);
                } else {
                    ivShowHidePwd.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
        });


        ivShowHidePwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isShowPassword) {
                    etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());

                    ivShowHidePwd.setImageResource(R.mipmap.ic_pwd_visible);
                    isShowPassword = false;
                } else {
                    etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());

                    ivShowHidePwd.setImageResource(R.mipmap.ic_pwd_visible);
                    isShowPassword = true;
                }
            }
        });
    }

    public void loginButtonClickEvent() {
            boolean userNameStatus = false, passwordStatus = false;

            userName = etUN.getText().toString().trim();
            String password = etPwd.getText().toString().trim();

            if (userName.equals("")) {
                loginType = "NA";
                userNameStatus = false;
                //etUN.setError(getString(R.string.username_error_msg));
            } else {
                userNameStatus = true;
            }

            if (password.equals("")) {
                passwordStatus = false;
                //etPwd.setError(getString(R.string.password_error_msg));
            } else {
                passwordStatus = true;
                //etPwd.setError(null);
            }




            if (userNameStatus && passwordStatus) {
                //customProgressLoggin.showDialog(getString(R.string.validating_msg));

                    Login(userName,password);

            }

    }

    public void setSignUpTextColor() {
        SpannableString ssTermsAndConditionText = new SpannableString(signUpText);
        ForegroundColorSpan fcsBlue = new ForegroundColorSpan(getResources().getColor(R.color.red));
        ssTermsAndConditionText.setSpan(fcsBlue, 23, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tvSignup.setText(ssTermsAndConditionText);
    }



    public void Login(String UserName, String pwd) {
        Call<ResponseBody> response = apiInterface.LoginUrl(UserName,pwd);

        response.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> rawResponse) {

                if (rawResponse.isSuccessful()) {


                    //log.d("SLT Selfcare TAG", response.code() + "");
                    //Config.logPrint(Config.TAG + "RetroFit2.0 :isSuccessful: ");

                    onSuccessResponse(rawResponse, UserName);


                }
                else {
                    // error case
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                // other stuff...
            }
        });
    }



    public void onSuccessResponse(Response response, String UserName) {

        String pkgNameS = "", pkgNameT = "", volumeUnitS = "", volumeUnitT = "";
        double useS = 0.0, useT = 0.0, limitS = 0.0, limitT = 0.0, percentageS = 0.0, percentageT = 0.0;


        try {
            //if(response.body()!=null){
            ResponseBody resource = (ResponseBody) response.body();
            JSONObject jsonResult = new JSONObject(((ResponseBody) response.body()).string());



        } catch (Exception e) {

            //Config.CommonWidgets(getApplicationContext(), ExGBActivity.this);

        }
    }

}