package com.alpha.peoplesbank;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.alpha.peoplesbank.Util.Config;
import com.alpha.peoplesbank.ui.login.LoginActivity;


public class SplashActivity extends AppCompatActivity {

    public ImageView ivSplashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ivSplashImage = (ImageView) findViewById(R.id.iv_splashImage);

        startupAnimation();
        startApp();

    }

    public void startupAnimation()
    {
        Animation animation = AnimationUtils.loadAnimation(SplashActivity.this, R.anim.splash_popup_image);
        //use this to make it longer:  animation.setDuration(1000);
        animation.setAnimationListener(new Animation.AnimationListener()
        {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation)
            {
                ivSplashImage.setVisibility(View.VISIBLE);
            }
        });

        ivSplashImage.startAnimation(animation);
    }

    public void startApp(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                SharedPreferences mSharedPreferences = getSharedPreferences(Config.LOGIN_TAGS, MODE_PRIVATE);
                if (mSharedPreferences.contains(Config.LOGIN_USER)) {

                    Config.USER_NAME = mSharedPreferences.getString(Config.LOGIN_USER,"");
                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }else{

                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }




            }

        }, 5000);
    }
}
