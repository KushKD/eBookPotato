package com.honsol.potatoebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferences settings = getSharedPreferences("Permissions", 0);
                //Get "hasLoggedIn" value. If the value doesn't exist yet false is returned
                //   boolean hasParkingSelected_ = settings.getBoolean("hasParkingSelected", false);

                int currentapiVersion = android.os.Build.VERSION.SDK_INT;
                if (currentapiVersion >= android.os.Build.VERSION_CODES.LOLLIPOP){

                    boolean Flag_Permissions = settings.getBoolean("PermissionsFlag",false);
                    if(Flag_Permissions)
                    {
                        Intent login_Intent = new Intent(SplashScreen.this, Main_Activity.class);
                        SplashScreen.this.startActivity(login_Intent);
                        SplashScreen.this.finish();

                    }else{
                        Intent login_Intent = new Intent(SplashScreen.this, Permissions.class);
                        SplashScreen.this.startActivity(login_Intent);
                        SplashScreen.this.finish();
                    }
                } else{

                    Intent mainIntent = new Intent(SplashScreen.this, Main_Activity.class);
                    SplashScreen.this.startActivity(mainIntent);
                    SplashScreen.this.finish();
                }





            }
        }, 2000);
    }
}
