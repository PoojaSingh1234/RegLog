package com.example.user.reglog;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by USER on 31-01-2018.
 */

public class SharedPrefManager {



    /**
     * Created by Belal on 9/5/2017.
     */

//here for this class we are using a singleton pattern


        //the constants
        private static final String SHARED_PREF_NAME = "simplifiedcodingsharedpref";
        private static final String KEY_NAME = "keyname";
        private static final String KEY_EMAIL = "keyemail";
        private static final String KEY_MOBILE = "keymobile";
        private static final String KEY_CITY = "keycity";
        private static final String KEY_AADHAR = "keyaadhar";
        private static final String KEY_ID = "keyid";

        private static SharedPrefManager mInstance;
        private static Context mCtx;

        private SharedPrefManager(Context context) {
            mCtx = context;
        }

        public static synchronized SharedPrefManager getInstance(Context context) {
            if (mInstance == null) {
                mInstance = new SharedPrefManager(context);
            }
            return mInstance;
        }

        //method to let the user login
        //this method will store the user data in shared preferences
        public void userLogin(User user) {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt(KEY_ID, user.getID());
            editor.putString(KEY_NAME, user.getName());
            editor.putString(KEY_EMAIL, user.getEmail());
            editor.putInt(KEY_MOBILE, user.getMobile());
            editor.putString(KEY_CITY, user.getCity());
            editor.putInt(KEY_AADHAR, user.getAadhar());
            editor.apply();
        }

        //this method will checker whether user is already logged in or not
        public boolean isLoggedIn() {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return sharedPreferences.getString(KEY_EMAIL, null) != null;
        }

        //this method will give the logged in user
        public User getUser() {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            return new User(
                    sharedPreferences.getInt(KEY_ID, 0),
                    sharedPreferences.getString(KEY_NAME, null),
                    sharedPreferences.getString(KEY_EMAIL, null),
                    sharedPreferences.getInt(KEY_MOBILE, 0),
                    sharedPreferences.getString(KEY_CITY, null),
                    sharedPreferences.getInt(KEY_AADHAR, 0)

            );
        }

        //this method will logout the user
        public void logout() {
            SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            mCtx.startActivity(new Intent(mCtx, login.class));
        }
    }




