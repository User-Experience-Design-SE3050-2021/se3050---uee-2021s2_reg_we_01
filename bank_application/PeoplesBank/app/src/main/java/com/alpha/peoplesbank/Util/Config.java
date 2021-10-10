package com.alpha.peoplesbank.Util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;


public class Config {

    public static String USER_NAME = "USER_NAME";
    public static final String LOGIN_USER ="LOGIN_USER" ;
    public static final String LOGIN_TAGS ="LOGIN_TAGS" ;


    public static void setHeader(String title){

        String headerTitle = title;
//        header.setText(headerTitle);

    }

    public static int getDeviceScreenWidth(Context context)
    {
        int width = -1;

        try
        {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            width = displayMetrics.widthPixels;
        }
        catch (Exception e)
        {
            System.out.println("Utill getDeviceScreenWidth error: " + e.getMessage());
            width = -1;
        }

        return width;
    }



}